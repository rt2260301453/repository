package tech.wetech.admin.modules.system.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.wetech.admin.core.annotation.SystemLog;
import tech.wetech.admin.core.utils.BaseController;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.core.utils.Result;
import tech.wetech.admin.modules.system.dto.SubareaDto;
import tech.wetech.admin.modules.system.po.Subarea;
import tech.wetech.admin.modules.system.query.SubareaQuery;
import tech.wetech.admin.modules.system.service.*;
import javax.validation.Valid;

/**
 * @author cjbi
 */
@Controller
@RequestMapping("/subarea")
public class SubareaController extends BaseController {

    @Autowired
    private SubareaService subareaService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private GroupService groupService;

    @GetMapping
    @RequiresPermissions("subarea:view")
    public String page(Model model) {
        setCommonData(model);
        System.out.println("进去分区数据,");
        return "system/subarea/subarea";
    }

    @ResponseBody
    @RequestMapping("/list")
    @RequiresPermissions("subarea:view")
    public PageResultSet<SubareaDto> list(SubareaQuery subareaQuery) {
        System.out.println("subareaQuery："+subareaQuery);
        System.out.println("查询分区数据list:");
        return subareaService.findByPage(subareaQuery);
    }

    @ResponseBody
    @PostMapping("/create")
    @RequiresPermissions("subarea:create")
    @SystemLog("分区管理新增用户")
    public Result create(@Valid Subarea subarea) {
        System.out.println(subarea);
        System.out.println("添加分区数据");
        subareaService.createUser(subarea);
        return Result.success();
    }

    /*@ResponseBody
    @PostMapping("/update")
    @RequiresPermissions("subarea:update")
    @SystemLog("用户管理更新用户")
    public Result update(User user) {
        userService.updateUser(user);
        return Result.success();
    }

    @ResponseBody
    @PostMapping("/delete")
    @RequiresPermissions("subarea:delete")
    @SystemLog("用户管理删除用户")
    public Result delete(@RequestParam("id") Long[] ids, HttpServletRequest request) {
        // 当前用户
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        User user = userService.findByUsername(username);
        boolean isSelf = Arrays.stream(ids).anyMatch(id -> id.equals(user.getId()));
        if (isSelf) {
            return Result.failure(ResultCodeEnum.FAILED_DEL_OWN);
        }
        Arrays.asList(ids).forEach(id -> userService.deleteUser(id));
        return Result.success();
    }

    @ResponseBody
    @RequiresPermissions("subarea:update")
    @PostMapping("/{id}/change/password")
    @SystemLog("用户管理更改用户密码")
    public Result changePassword(@PathVariable("id") Long id, String newPassword) {
        userService.changePassword(id, newPassword);
        return Result.success();
    }*/

    private void setCommonData(Model model) {
        model.addAttribute("organizationList", organizationService.findAll());
        model.addAttribute("roleList", roleService.findAll());
        model.addAttribute("groupList",groupService.findAll());
    }

}
