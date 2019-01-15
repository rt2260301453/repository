package tech.wetech.admin.modules.system.web;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.wetech.admin.core.annotation.SystemLog;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.core.utils.Result;
import tech.wetech.admin.modules.system.enums.GroupType;
import tech.wetech.admin.modules.system.po.SpDate;
import tech.wetech.admin.modules.system.query.SpDateQuery;
import tech.wetech.admin.modules.system.service.SpDateService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.Date;

@Controller
@RequestMapping("/sp")
public class SpDateController {


    @Autowired
    private SpDateService spDateService;


    @GetMapping
    public String page(Model model) {
        setCommonData(model);
        return "system/xuyan/SpDate";
    }

    @ResponseBody
    @RequestMapping("/list")
    public PageResultSet<SpDate> list(SpDateQuery spDateQuery) {

        return spDateService.findByPage(spDateQuery);
    }

    @ResponseBody
    @PostMapping("/create")
    @SystemLog("用户管理创建用户组")
    public void create(@Valid SpDate spDate, HttpServletResponse response) {
        Date sj = new Date();
        spDate.setUpdatedate(sj);
        spDate.setUpdatename((String) SecurityUtils.getSubject().getPrincipal());
        int count = spDateService.selectOnename(spDate);
        System.out.println("Datename()="+spDate.getDatename());
        if(count == 1){
            response.setStatus(445);
        }else {
            spDate.setUnit("新增成功");
            response.setStatus(200);
        }
    }

    @ResponseBody
    @PostMapping("/update")
    @SystemLog("用户管理更新用户组")
    public Result update(@Valid SpDate spDate) {
        Date sj = new Date();
        spDate.setUpdatedate(sj);
        spDate.setState("成功");
        spDateService.updateSpDate(spDate);
        return Result.success();
    }

    @ResponseBody
    @PostMapping("/delete")
    @SystemLog("用户管理删除用户组")
    public Result delete(@RequestParam("id") Long[] ids) {

        Arrays.asList(ids).forEach(id -> spDateService.deleteSpDate(id));
        return Result.success();
    }

    private void setCommonData(Model model) {
        model.addAttribute("groupTypeList", GroupType.values());
    }

}
