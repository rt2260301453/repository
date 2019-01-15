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
import tech.wetech.admin.modules.system.po.SubBasic;
import tech.wetech.admin.modules.system.query.SubBasicQuery;
import tech.wetech.admin.modules.system.service.SubBasicService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.Date;

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
        Date nowoperationdate = new Date();
        String nowoperator = (String) SecurityUtils.getSubject().getPrincipal();
        subbasic.setSuboperationdate(nowoperationdate);
        subbasic.setSuboperator(nowoperator);
        subbasicService.createsubBasic(subbasic);
        return Result.success();
    }

    @ResponseBody
    @PostMapping("/update")
    @RequiresPermissions("subbasic:update")
    @SystemLog("用户管理更新用户组")
    public Result update(SubBasic subbasic) {
        Date nowoperationdate = new Date();
        String nowoperator = (String) SecurityUtils.getSubject().getPrincipal();
        subbasic.setSuboperationdate(nowoperationdate);
        subbasic.setSuboperator(nowoperator);
        System.out.println("********************************************************");
        System.out.println("********************************************************");
        System.out.println("********************************************************");
        System.out.println("********************************************************");
        System.out.println("********************************************************");
        System.out.println("********************************************************");
        System.out.println("77777777777777777777777777777="+subbasic.getSubbasicname());
        System.out.println("77777777777777777777777777777="+subbasic.getSubbasicno());
        subbasicService.updatesubBasic(subbasic);
        return Result.success();
    }

    @ResponseBody
    @PostMapping("/delete")
    @SystemLog("用户管理删除用户组")
    public Result delete(@RequestParam("subbasicno") String[] subbasicnos) {
        Arrays.asList(subbasicnos).forEach(subbasicno -> subbasicService.deletesubBasic(subbasicno));
        return Result.success();
    }

    @RequestMapping("/checkNo")
    public void checkNo(String subbasicno, HttpServletResponse response){
        SubBasic subbasic = new SubBasic();
        subbasic.setSubbasicno(subbasicno);
        System.out.println("********************************************************");
        System.out.println("subbasicno="+subbasic.getSubbasicno());
        int count = subbasicService.selectOneno(subbasic);
        System.out.println("subbasicno="+subbasic.getSubbasicno());
        if(count == 1){
            response.setStatus(400);
        }else {
            response.setStatus(200);
        }
    }
    @RequestMapping("/checkName")
    public void checkName( SubBasic subbasic, HttpServletResponse response){
        System.out.println("********************************************************");
        System.out.println("subbasicname="+subbasic.getSubbasicname());
        int count = subbasicService.selectOnename(subbasic);
        System.out.println("subbasicname="+subbasic.getSubbasicname());
        if(count == 1){
            response.setStatus(400);
        }else {
            response.setStatus(200);
        }
    }

    @RequestMapping("/checkName1")
    public void checkName1( SubBasic subbasic, HttpServletResponse response){
        System.out.println("********************************************************");
        System.out.println("subbasicname="+subbasic.getSubbasicname());
        System.out.println("subbasicno="+subbasic.getSubbasicno());
        int count = subbasicService.selectOnename(subbasic);
        SubBasic b = subbasicService.selectOnename1(subbasic);
        System.out.println("********************************************************");
        System.out.println("subbasicname="+b.getSubbasicname());
        if(count == 1){
            if(b.getSubbasicname().equals(subbasic.getSubbasicname())){
                System.out.println("22222222222222222222222222222222222222222222222222222222");
                System.out.println("********************************************************");
                System.out.println("********************************************************");
                response.setStatus(200);
            }else{
                System.out.println("33333333333333333333333333333333333333333333333333333333");
                System.out.println("********************************************************");
                System.out.println("********************************************************");
                response.setStatus(400);
            }
        }else {
            System.out.println("44444444444444444444444444444444444444444444444444444444");
            System.out.println("********************************************************");
            System.out.println("********************************************************");
            response.setStatus(200);
        }
    }

}
