package tech.wetech.admin.modules.system.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.wetech.admin.core.annotation.SystemLog;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.core.utils.Result;
import tech.wetech.admin.modules.system.dto.StaffDto;
import tech.wetech.admin.modules.system.po.Staff;
import tech.wetech.admin.modules.system.query.StaffQuery;
import tech.wetech.admin.modules.system.service.StaffService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController{
    @Autowired
    private StaffService staffService;

    @GetMapping
    @RequiresPermissions("staff:view")
    public String page(Model model) {
        setCommonData(model);
        return "system/sendandget/querystafflist";
    }



    @ResponseBody
    @RequestMapping("/list")
    @RequiresPermissions("staff:view")
    public PageResultSet<StaffDto> list(StaffQuery staffQuery) {
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println(staffQuery.getStaid());
        return staffService.findByPage(staffQuery);
    }

    @ResponseBody
    @PostMapping("/create")
    @RequiresPermissions("staff:create")
    @SystemLog("取派管理创建取派员")
    public Result create(@Valid Staff staff) {
        staffService.createStaff(staff);
        return Result.success();
    }

    @ResponseBody
    @PostMapping("/update")
    @RequiresPermissions("staff:update")
    @SystemLog("取派管理更新取派员")
    public Result update(@Valid Staff staff) {
        System.out.println("**************************************");
        System.out.println("staff="+staff);
        staffService.updatestaff(staff);
        return Result.success();
    }

    @ResponseBody
    @PostMapping("/delete")
    @RequiresPermissions("staff:delete")
    @SystemLog("取派管理删除取派员")
    public Result delete(@RequestParam("id") Long[] ids) {
        // 当前用户
//        String username = (String) SecurityUtils.getSubject().getPrincipal();
        Arrays.asList(ids).forEach(id -> staffService.deleteStaff(id));
        return Result.success();
    }

    @RequestMapping("/getwo")
    public void checktrue(@Valid Staff staff, HttpServletResponse response) {

            response.setStatus(200);

    }

    //@ResponseBody
    @RequestMapping("/check")
    public void check(@Valid Staff staff, HttpServletResponse response) {
        int count = staffService.checkstaffid(staff);
        System.out.println("****************************************");
        System.out.println(count);
        if (count==1){
            response.setStatus(400);

        }else{
            response.setStatus(200);
        }
    }
    private void setCommonData(Model model) {
        List<Staff> staff =staffService.findAll();
        for (Staff aa:staff
        ) {
            System.out.print("=====================================================");
            System.out.print("model数据："+aa);
        }
        model.addAttribute("stafflist", staffService.findAll());
        model.addAttribute("subbasicList", staffService.findbasic());
        model.addAttribute("busRouteList", staffService.findbusRoute());
    }


}
