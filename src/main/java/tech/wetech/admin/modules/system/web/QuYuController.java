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
import tech.wetech.admin.modules.system.dto.QuYuDto;
import tech.wetech.admin.modules.system.dto.UserDto;
import tech.wetech.admin.modules.system.po.QuYu;
import tech.wetech.admin.modules.system.po.User;
import tech.wetech.admin.modules.system.query.QuYuQuery;
import tech.wetech.admin.modules.system.query.UserQuery;
import tech.wetech.admin.modules.system.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.Console;
import java.util.Arrays;
import java.util.List;

/**
 * @author cjbi
 */
@Controller
@RequestMapping("/quyu")
public class QuYuController extends BaseController {


    /**
     *
     */
    @Autowired
    private QuYuService quyuService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private GroupService groupService;

    @GetMapping
    @RequiresPermissions("quyu:view")
    public String page(Model model) {
        setCommonData(model);



        return "system/xzqy/quyu";
    }
    /**
     * 取汉字的首字母(默认是大写)
     *
     * @param src
     * @return
     */

    @ResponseBody
    @RequestMapping("/list")
    @RequiresPermissions("quyu:view")
    public PageResultSet<QuYuDto> list(QuYuQuery quyuQuery) {

        return quyuService.findByPage(quyuQuery);
    }

   @ResponseBody
    @PostMapping("/create")
    @RequiresPermissions("quyu:create")
    @SystemLog("区域管理创建区域")
    public Result create( QuYu quyu) {
        System.out.println("到达添加区域页面++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        quyuService.createQuYu(quyu);
        return Result.success();
    }

        @ResponseBody
        @PostMapping("/update")
        @RequiresPermissions("quyu:update")
        @SystemLog("区域管理更新区域")
        public Result update(QuYu quyu) {
            quyuService.updateQuYu(quyu);
            return Result.success();
        }

    @ResponseBody
       @PostMapping("/delete")
       @RequiresPermissions("quyu:delete")
       @SystemLog("区域管理删除区域")
       public Result delete(@RequestParam("id") Integer[] ids, HttpServletRequest request) {
           // 当前用户
         String username = (String) SecurityUtils.getSubject().getPrincipal();
          /*   User user = userService.findByUsername(username);
           boolean isSelf = Arrays.stream(ids).anyMatch(id -> id.equals(quyu.getId()));
           if (isSelf) {
               return Result.failure(ResultCodeEnum.FAILED_DEL_OWN);
           }*/
           Arrays.asList(ids).forEach(id -> quyuService.deleteQuYu(id));
           return Result.success();
       }

    /*      @ResponseBody
    @RequiresPermissions("user:update")
    @PostMapping("/{id}/change/password")
    @SystemLog("用户管理更改用户密码")
    public Result changePassword(@PathVariable("id") Long id, String newPassword) {
        userService.changePassword(id, newPassword);
        return Result.success();
    }
*/
    private void setCommonData(Model model) {
       /* model.addAttribute("organizationList", organizationService.findAll());
        model.addAttribute("roleList", roleService.findAll());
        model.addAttribute("groupList",groupService.findAll());*/
        model.addAttribute("quyuList",quyuService.findAll());
    }

}

