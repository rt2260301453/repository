package tech.wetech.admin.modules.system.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import tech.wetech.admin.core.annotation.SystemLog;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.core.utils.Result;
import tech.wetech.admin.modules.system.dto.ReplayDto;
import tech.wetech.admin.modules.system.po.Replay;
import tech.wetech.admin.modules.system.po.Staff;
import tech.wetech.admin.modules.system.query.ReplayQuery;
import tech.wetech.admin.modules.system.service.ReplayService;
import tech.wetech.admin.modules.system.service.StaffService;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.Date;

@Controller
@RequestMapping("/replay")
public class ReplayController {
    @Resource
    private ReplayService replayService;
    @Autowired
    private StaffService staffService;

    @RequestMapping
    @GetMapping
    @RequiresPermissions("replay:view")
    public String page(Model model) {
        setCommonData(model);
        return "system/sendandget/relay";
    }

    @ResponseBody
    @RequestMapping("/list")
    @RequiresPermissions("replay:view")
    public PageResultSet<ReplayDto> list(ReplayQuery replayQuery) {
        System.out.println(replayQuery.getReplayid());
        return replayService.findByPage(replayQuery);
    }



    @ResponseBody
    @PostMapping("/create")
    @RequiresPermissions("replay:create")
    @SystemLog("替班管理创建替班信息")
    public Result create(@Valid Replay replay, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return Result.failure(bindingResult);
        }else {
            int count = replayService.checktime(replay);
            System.out.println(count);
            if (count==1){
                return Result.failure("400","该员工在这段时间内已分配工作");

            }else{
                String username =  (String) SecurityUtils.getSubject().getPrincipal();
                replay.setUpusername(username);
                Date date = new Date();
                replay.setUptime(date);
                System.out.println(replay.getStarttime());
                replayService.createStaff(replay);
                return Result.success();
            }
        }
    }




    @ResponseBody
    @RequestMapping("/ajax4input")
//    @SystemLog("替班管理创建替班信息")
    public Staff queryname(String replayid) {
        System.out.println(replayid);
        Staff replay = replayService.queryAllForFormSelect(replayid);
        System.out.println(replay);
        return replay;
    }



    @ResponseBody
    @PostMapping("/update")
    @RequiresPermissions("replay:update")
    @SystemLog("替班管理更新替班信息")
    public Result update(@Valid Replay replay,BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return Result.failure(bindingResult);
        }else {
            int count = replayService.checktime(replay);
            System.out.println(count);
            if (count==1){
                return Result.failure("400","该员工在这段时间没已分配工作");
            }else{
                String username =  (String) SecurityUtils.getSubject().getPrincipal();
                replay.setUpusername(username);
                Date date = new Date();
                replay.setUptime(date);
                System.out.println(replay.getStarttime());
                replayService.updatestaff(replay);
                return Result.success();
            }
        }
    }

    @ResponseBody
    @PostMapping("/delete")
    @RequiresPermissions("replay:delete")
    @SystemLog("替班管理删除替班信息")
    public Result delete(@RequestParam("id") Long[] ids) {
        // 当前用户
        Arrays.asList(ids).forEach(id -> replayService.deletereplay(id));
        return Result.success();
    }

    private void setCommonData(Model model) {
        model.addAttribute("staffList", staffService.findAll());
    }
}
