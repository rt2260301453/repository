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
    @SystemLog("送派时间管理新增角色")
    public Result create(@Valid SpDate spDate) {
        Date sj = new Date();
        spDate.setUpdatedate(sj);
        spDate.setUpdatename((String) SecurityUtils.getSubject().getPrincipal());
        spDateService.createSpDate(spDate);
        return Result.success();
    }

    @ResponseBody
    @RequestMapping("/check")
    public void check(SpDate spDate, HttpServletResponse response) {
        System.out.println("********************************************************************************");
        int count = spDateService.selectOnename(spDate);
        System.out.println("count"+count);
        System.out.println("Datename()="+spDate.getDatename());
        if(count == 1){
            response.setStatus(400);
        }else {
            
            response.setStatus(200);
        }
    }
    @ResponseBody
    @PostMapping("/update")
    @SystemLog("送派时间管理更新角色")
    public Result update(@Valid SpDate spDate) {
        Date sj = new Date();
        spDate.setUpdatedate(sj);
        spDate.setState("成功");
        spDateService.updateSpDate(spDate);
        return Result.success();
    }

    @ResponseBody
    @PostMapping("/delete")
    @SystemLog("送派时间管理删除角色")
    public Result delete(@RequestParam("id") Long[] ids) {

        Arrays.asList(ids).forEach(id -> spDateService.deleteSpDate(id));
        return Result.success();
    }

    private void setCommonData(Model model) {
        model.addAttribute("groupTypeList", GroupType.values());
    }

}
