package tech.wetech.admin.modules.system.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.wetech.admin.core.utils.BaseController;
import tech.wetech.admin.core.annotation.SystemLog;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.core.utils.Result;
import tech.wetech.admin.core.utils.ResultCodeEnum;
import tech.wetech.admin.modules.system.dto.UserDto;
import tech.wetech.admin.modules.system.po.User;
import tech.wetech.admin.modules.system.query.UserQuery;
import tech.wetech.admin.modules.system.service.GroupService;
import tech.wetech.admin.modules.system.service.OrganizationService;
import tech.wetech.admin.modules.system.service.RoleService;
import tech.wetech.admin.modules.system.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;

/**
 * @author cjbi
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private GroupService groupService;

    @GetMapping
    @RequiresPermissions("user:view")
    public String page(Model model) {
        setCommonData(model);
        return "system/user";
    }

    @ResponseBody
    @RequestMapping("/list")
    @RequiresPermissions("user:view")
    public PageResultSet<UserDto> list(UserQuery userQuery) {
        return userService.findByPage(userQuery);
    }

    @ResponseBody
    @PostMapping("/create")
    @RequiresPermissions("user:create")
    @SystemLog("�û��������û�")
    public Result create(@Valid User user) {
        userService.createUser(user);
        return Result.success();
    }

    @ResponseBody
    @PostMapping("/update")
    @RequiresPermissions("user:update")
    @SystemLog("�û���������û�")
    public Result update(User user) {
        userService.updateUser(user);
        return Result.success();
    }

    @ResponseBody
    @PostMapping("/delete")
    @RequiresPermissions("user:delete")
    @SystemLog("�û�����ɾ���û�")
    public Result delete(@RequestParam("id") Long[] ids, HttpServletRequest request) {
        // ��ǰ�û�
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        System.out.println("username:"+username);
        User user = userService.findByUsername(username);
        boolean isSelf = Arrays.stream(ids).anyMatch(id -> id.equals(user.getId()));
        if (isSelf) {
            return Result.failure(ResultCodeEnum.FAILED_DEL_OWN);
        }
        Arrays.asList(ids).forEach(id -> userService.deleteUser(id));
        return Result.success();
    }

    @ResponseBody
    @RequiresPermissions("user:update")
    @PostMapping("/{id}/change/password")
    @SystemLog("�û���������û�����")
    public Result changePassword(@PathVariable("id") Long id, String newPassword) {
        userService.changePassword(id, newPassword);
        return Result.success();
    }

    private void setCommonData(Model model) {
        model.addAttribute("organizationList", organizationService.findAll());
        model.addAttribute("roleList", roleService.findAll());
        model.addAttribute("groupList",groupService.findAll());
    }

}
