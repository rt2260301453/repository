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
import tech.wetech.admin.core.utils.BaseController;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.core.utils.Result;
import tech.wetech.admin.modules.system.dto.AssociatedWidgetsDto;
import tech.wetech.admin.modules.system.dto.SpDateDto;
import tech.wetech.admin.modules.system.po.AssociatedWidgets;
import tech.wetech.admin.modules.system.po.Staff;
import tech.wetech.admin.modules.system.query.AssociatedWidgetsQuery;
import tech.wetech.admin.modules.system.query.SpDateQuery;
import tech.wetech.admin.modules.system.service.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author cjbi
 */
@Controller
@RequestMapping("/assWidgets")
public class AssociatedWidgetsController extends BaseController {

    @Autowired
    private AssociatedWidgetsService associatedWidgetsService;

    @Autowired
    private FixedAreaService fixedAreaService;

    @GetMapping
    @RequiresPermissions("assWidgets:view")
    public String page(Model model) {
        setCommonData(model);
        return "system/fixedarea/asswidgetslist";
    }

    @ResponseBody
    @RequestMapping("/list")
    @RequiresPermissions("assWidgets:view")
    public PageResultSet<AssociatedWidgetsDto> list(AssociatedWidgetsQuery associatedAddressQuery) {
        return associatedWidgetsService.findByPage(associatedAddressQuery);
    }

    @ResponseBody
    @RequestMapping("/spdatelist")
    @RequiresPermissions("assWidgets:view")
    public PageResultSet<SpDateDto> spDateList(SpDateQuery spDateQuery) {
        return associatedWidgetsService.findSpDateByPage(spDateQuery);
    }

    @ResponseBody
    @RequestMapping("/create")
    @RequiresPermissions("assWidgets:create")
    @SystemLog("定区管理创建关联取派人员")
    public Result create(@Valid AssociatedWidgets associatedWidgets) {
        associatedWidgetsService.insertOne(associatedWidgets);
        return Result.success();
    }

    @ResponseBody
    @RequestMapping("/selectfetchpeople")
    public Staff selectFetchPeople(@Valid Staff staff) {
        System.out.println("staffid="+staff.getStaid());
        Staff staff1 = associatedWidgetsService.selectOneStaff(staff);
        System.out.println("staff="+staff1);
        return staff1;
    }

    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("assWidgets:update")
    @SystemLog("定区管理更新地址关联")
    public Result update(@Valid  AssociatedWidgets associatedWidgets) {
        associatedWidgetsService.updateOne(associatedWidgets);
        return Result.success();
    }

    @ResponseBody
    @RequestMapping("/delete")
    @RequiresPermissions("assWidgets:delete")
    @SystemLog("定区管理删除地址关联")
    public Result delete(@RequestParam("id") Long[] ids) {
        Arrays.asList(ids).forEach(id -> associatedWidgetsService.deleteOne(id));
        return Result.success();
    }

    private void setCommonData(Model model) {
        model.addAttribute("fixedAreaList", fixedAreaService.selectAll());
        model.addAttribute("staffList", associatedWidgetsService.selectAllStafff());
        model.addAttribute("spDateList", associatedWidgetsService.selectAllSpDate());
    }

}
