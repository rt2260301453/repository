package tech.wetech.admin.modules.system.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tech.wetech.admin.core.annotation.SystemLog;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.core.utils.Result;
import tech.wetech.admin.modules.system.po.SubBasic;
import tech.wetech.admin.modules.system.query.SubBasicQuery;
import tech.wetech.admin.modules.system.service.SubBasicService;

import javax.validation.Valid;

/**
 * @author cjbi
 */
@Controller
@RequestMapping("/subbasic")
public class SubBasicController {

    @Autowired
    private SubBasicService subbasicService;

    @GetMapping
    @RequiresPermissions("subbasic:view")
    public String page(Model model) {
        model.addAttribute("SubBasicList", subbasicService.findAll());
        return "system/basicyc/subbasic";
    }
    @ResponseBody
    @RequestMapping("/list")
    @RequiresPermissions("subbasic:view")
    public PageResultSet<SubBasic> list(SubBasicQuery subbasicQuery) {
        return subbasicService.findByPage(subbasicQuery);
    }

    @ResponseBody
    @PostMapping("/create")
    @RequiresPermissions("subbasic:create")
    @SystemLog("用户管理创建用户组")
    public Result create(@Valid SubBasic subbasic) {
        subbasicService.createsubBasic(subbasic);
        return Result.success();
    }

    @ResponseBody
    @PostMapping("/update")
    @RequiresPermissions("subbasic:update")
    @SystemLog("用户管理更新用户组")
    public Result update(@Valid SubBasic subbasic) {
        subbasicService.updatesubBasic(subbasic);
        return Result.success();
    }

//    @ResponseBody
//    @PostMapping("/delete")
//    @SystemLog("用户管理删除用户组")
//    public Result delete(@RequestParam("id") int[] ids) {
//        Arrays.asList(ids).forEach(id -> basicService.deleteBasic(id));
//        return Result.success();
//    }

}
