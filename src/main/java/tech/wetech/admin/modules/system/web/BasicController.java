package tech.wetech.admin.modules.system.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.wetech.admin.core.annotation.SystemLog;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.core.utils.Result;
import tech.wetech.admin.modules.system.po.Basic;
import tech.wetech.admin.modules.system.query.BasicQuery;
import tech.wetech.admin.modules.system.service.BasicService;

import javax.validation.Valid;

/**
 * @author cjbi
 */
@Controller
@RequestMapping("/basic")
public class BasicController {

    @Autowired
    private BasicService basicService;

    @GetMapping
    public String page(Model model) {
        model.addAttribute("BasicList", basicService.findAll());
        return "system/basicyc/basic";
    }
    @ResponseBody
    @RequestMapping("/list")
    public PageResultSet<Basic> list(BasicQuery basicQuery) {
        return basicService.findByPage(basicQuery);
    }

    @ResponseBody
    @PostMapping("/create")
    @RequiresPermissions("basic:create")
    @SystemLog("用户管理创建用户组")
    public Result create(@Valid Basic basic) {
        basicService.createBasic(basic);
        return Result.success();
    }

    @ResponseBody
    @PostMapping("/update")
    @RequiresPermissions("basic:update")
    @SystemLog("用户管理更新用户组")
    public Result update(@Valid Basic basic) {
        basicService.updateBasic(basic);
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
