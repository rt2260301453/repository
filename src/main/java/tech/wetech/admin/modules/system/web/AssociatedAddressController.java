package tech.wetech.admin.modules.system.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.wetech.admin.core.utils.BaseController;
import tech.wetech.admin.core.annotation.SystemLog;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.core.utils.Result;
import tech.wetech.admin.modules.system.dto.AssociatedAddressDto;
import tech.wetech.admin.modules.system.po.AssociatedAddress;
import tech.wetech.admin.modules.system.po.Customer;
import tech.wetech.admin.modules.system.query.AssociatedAddressQuery;
import tech.wetech.admin.modules.system.service.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author cjbi
 */
@Controller
@RequestMapping("/assAddress")
public class AssociatedAddressController extends BaseController {

    @Autowired
    private AssociatedAddressService associatedAddressService;

    @Autowired
    private QuYuService quYuService;

    @Autowired
    private SubareaService subareaService;

    @Autowired
    private FixedAreaService fixedAreaService;

    @Autowired
    private CustomerService customerService;

    @GetMapping
    @RequiresPermissions("assAddress:view")
    public String page(Model model) {
        setCommonData(model);
        return "system/fixedarea/assaddresslist";
    }

    @ResponseBody
    @RequestMapping("/list")
    @RequiresPermissions("assAddress:view")
    public PageResultSet<AssociatedAddressDto> list(AssociatedAddressQuery associatedAddressQuery) {
        return associatedAddressService.findByPage(associatedAddressQuery);
    }

    @ResponseBody
    @RequestMapping("/create")
    @RequiresPermissions("assAddress:create")
    @SystemLog("定区管理创建地址关联")
    public Result create(@Valid AssociatedAddress associatedAddress) {
        associatedAddressService.insertOne(associatedAddress);
        return Result.success();
    }

    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("assAddress:update")
    @SystemLog("定区管理更新地址关联")
    public Result update(@Valid  AssociatedAddress associatedAddress) {
        associatedAddressService.updateOne(associatedAddress);
        return Result.success();
    }

    @ResponseBody
    @RequestMapping("/delete")
    @RequiresPermissions("assAddress:delete")
    @SystemLog("定区管理删除地址关联")
    public Result delete(@RequestParam("id") Long[] ids) {
        Arrays.asList(ids).forEach(id -> associatedAddressService.deleteOne(id));
        return Result.success();
    }

    @ResponseBody
    @RequestMapping("/checkCusParNo")
    public List<AssociatedAddress> checkCusParNo(AssociatedAddress associatedAddress,Model model) {
        return associatedAddressService.selectByCondition(associatedAddress);
    }

    @ResponseBody
    @RequestMapping("/selectCus")
    public List<Map<String, Object>> selectAllCountry(Customer customer) {
        return customerService.findByCondition(customer);
    }

    private void setCommonData(Model model) {
        model.addAttribute("cityList", quYuService.selectAllCity());
        model.addAttribute("subAreaList", subareaService.findAll());
        model.addAttribute("fixedAreaList", fixedAreaService.selectAll());
    }

}
