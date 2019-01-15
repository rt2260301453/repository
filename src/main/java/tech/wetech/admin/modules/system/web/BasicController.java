package tech.wetech.admin.modules.system.web;

import org.apache.shiro.SecurityUtils;
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

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.Date;

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
    @SystemLog("基本档案管理创建基本档案")
    public Result create(@Valid Basic basic) {
        Date nowoperationdate = new Date();
        String nowoperator = (String) SecurityUtils.getSubject().getPrincipal();
        basic.setOperationdate(nowoperationdate);
        basic.setOperator(nowoperator);
        basicService.createBasic(basic);
        return Result.success();
    }

    @ResponseBody
    @PostMapping("/update")
    @RequiresPermissions("basic:update")
    @SystemLog("基本档案管理更新基本档案")
    public Result update( Basic basic) {
        basicService.updateBasic(basic);
        return Result.success();
    }

    @ResponseBody
    @PostMapping("/updateremark")
    @RequiresPermissions("basic:update")
    @SystemLog("更新备注和是否分级")
    public Result updateremark(String pk,String name,String value) {
        System.out.println("********************************************************");
        System.out.println("********************************************************");
        System.out.println("********************************************************");
        System.out.println("********************************************************");
        System.out.println("pk"+pk);
        System.out.println("name"+name);
        System.out.println("value"+value);
        Basic basic = new Basic();
        basic.setBasicno(pk);
        basic.setRemark(value);
        basicService.updateBasicremark(basic);
        return Result.success();
    }

    @ResponseBody
    @PostMapping("/updateclassifying")
    @RequiresPermissions("basic:update")
    @SystemLog("更新备注和是否分级")
    public Result updateclassifying(String pk,String name,Integer value) {
        System.out.println("pk"+pk);
        System.out.println("name"+name);
        System.out.println("value"+value);
        Basic basic = new Basic();
        basic.setBasicno(pk);
        basic.setClassifying(value);
        basicService.updateBasicreclassifying(basic);
        return Result.success();
    }

    @RequestMapping("/checkNo")
    public void checkNo(String basicno, HttpServletResponse response){
        Basic basic = new Basic();
        basic.setBasicno(basicno);
        System.out.println("********************************************************");
        System.out.println("basicno="+basic.getBasicno());
        int count = basicService.selectOneno(basic);
        System.out.println("basicno="+basic.getBasicno());
        if(count == 1){
            response.setStatus(400);
        }else {
            response.setStatus(200);
        }
    }
    @RequestMapping("/checkName")
    public void checkName( Basic basic, HttpServletResponse response){
        System.out.println("********************************************************");
        System.out.println("basicname="+basic.getBasicname());
        int count = basicService.selectOnename(basic);
        System.out.println("basicname="+basic.getBasicname());
        if(count == 1){
            response.setStatus(400);
        }else {
            response.setStatus(200);
        }
    }

    @RequestMapping("/checkTrue")
    public void checkTrue( HttpServletResponse response){
        response.setStatus(200);
    }

    @ResponseBody
    @PostMapping("/delete")
    @RequiresPermissions("basic:delete")
    @SystemLog("基本档案管理删除基本档案")
    public Result delete(@RequestParam("basicno") String[] basicnos) {
        System.out.println("*********************************************************************************************");
        System.out.println(basicnos);
        Arrays.asList(basicnos).forEach(basicno -> basicService.deleteBasic(basicno));
        return Result.success();
    }

}
