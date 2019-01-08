<<<<<<< HEAD
package tech.wetech.admin.modules.system.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tech.wetech.admin.core.annotation.SystemLog;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.core.utils.Result;
import tech.wetech.admin.modules.system.dto.FixedAreaDto;
import tech.wetech.admin.modules.system.po.FixedArea;
import tech.wetech.admin.modules.system.query.FixedAreaQuery;
import tech.wetech.admin.modules.system.service.FixedAreaService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Arrays;

/**
 * @author rt
 */
//@Controller
//@RequestMapping("/associatedAddress")
public class AssociatedAddressController {
=======
//package tech.wetech.admin.modules.system.web;
//
//import org.apache.shiro.authz.annotation.RequiresPermissions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import tech.wetech.admin.core.annotation.SystemLog;
//import tech.wetech.admin.core.utils.PageResultSet;
//import tech.wetech.admin.core.utils.Result;
//import tech.wetech.admin.modules.system.dto.FixedAreaDto;
//import tech.wetech.admin.modules.system.po.FixedArea;
//import tech.wetech.admin.modules.system.query.FixedAreaQuery;
//import tech.wetech.admin.modules.system.service.FixedAreaService;
//
//import javax.servlet.http.HttpServletResponse;
//import javax.validation.Valid;
//import java.util.Arrays;
//
///**
// * @author rt
// */
//@Controller
//@RequestMapping("/associatedAddress")
//public class AssociatedAddressController {
>>>>>>> 9320f168ee4236616d541127070bacea9db63df7
//    @Autowired
//    private FixedAreaService fixedAreaService;
//
//    @GetMapping
//    @RequiresPermissions("fixedarea:view")
//    public String page() {
//        setCommonData(model);
//        return "system/fixedarea/associatedaddresslist";
//    }
//
//    @ResponseBody
//    @RequestMapping("/list")
//    @RequiresPermissions("fixedarea:view")
//    public PageResultSet<FixedAreaDto> list(FixedAreaQuery fixedAreaQuery) {
//        System.out.println("********************************************************");
//        System.out.println("fixedName="+fixedAreaQuery.getFixedareaname());
//        System.out.println("fixedManager="+fixedAreaQuery.getFixedareamanager());
//        return fixedAreaService.findByPage(fixedAreaQuery);
//    }
//
//    @ResponseBody
//    @RequiresPermissions("fixedarea:create")
//    @RequestMapping("/create")
//    public Result insert(@Valid FixedArea fixedArea){
//        fixedAreaService.insertOne(fixedArea);
//        return  Result.success();
//    }
//
//    @ResponseBody
//    @RequiresPermissions("fixedarea:update")
//    @RequestMapping("/update")
//    @SystemLog("定区管理更新定区")
//    public Result update(@Valid FixedArea fixedArea){
//        fixedAreaService.updateOne(fixedArea);
//        return  Result.success();
//    }
//
//    @ResponseBody
//    @RequiresPermissions("fixedarea:delete")
//    @RequestMapping("/delete")
//    @SystemLog("定区管理删除定区")
//    public Result delete(@RequestParam("id") Long[] ids){
//        Arrays.asList(ids).forEach(id -> fixedAreaService.deleteOne(id));
//        return Result.success();
//    }
//
//    @RequestMapping("/checkNo")
//    public void checkNo(@Valid FixedArea fixedArea, HttpServletResponse response){
//        int count = fixedAreaService.selectOne(fixedArea);
//        System.out.println("fixedNo="+fixedArea.getFixedareano());
//        if(count == 1){
//            response.setStatus(400);
//        }else {
//            response.setStatus(200);
//        }
//    }
//
//    private void setCommonData(Model model) {
//        model.addAttribute("organizationList", organizationService.findAll());
//        model.addAttribute("roleList", roleService.findAll());
//        model.addAttribute("groupList",groupService.findAll());
//    }
<<<<<<< HEAD
}
=======
//}
>>>>>>> 9320f168ee4236616d541127070bacea9db63df7
