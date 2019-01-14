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
import tech.wetech.admin.modules.system.dto.BusRouteDto;
import tech.wetech.admin.modules.system.dto.UserDto;
import tech.wetech.admin.modules.system.po.Busroute;
import tech.wetech.admin.modules.system.po.FixedArea;
import tech.wetech.admin.modules.system.po.Namefromto;
import tech.wetech.admin.modules.system.po.User;
import tech.wetech.admin.modules.system.query.BusRouteQuery;
import tech.wetech.admin.modules.system.query.UserQuery;
import tech.wetech.admin.modules.system.service.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.Console;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author cjbi
 */
@Controller
@RequestMapping("/bus")
public class BusRouteController extends BaseController {
    /**
     *
     */
    @Autowired
    private BusRouteService busRouteService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private GroupService groupService;

    @GetMapping
    @RequiresPermissions("bus:view")
    public String page(Model model) {
        setCommonData(model);
        return "system/bus";
    }

    @ResponseBody
    @RequestMapping("/list")
    @RequiresPermissions("bus:view")
    public PageResultSet<BusRouteDto> list(BusRouteQuery busRouteQuery) {
        return busRouteService.findByPage(busRouteQuery);
    }

    @ResponseBody
    @PostMapping("/create")
    @RequiresPermissions("bus:view")
    public Result create( Busroute busroute) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        busroute.setOperator(username);
        busroute.setCompany("啦啦啦公司");
        busroute.setDate(new Date());
        busRouteService.createQuYu(busroute);
        return Result.success();
    }

    @ResponseBody
    @PostMapping("/update")
    @RequiresPermissions("bus:view")
    @SystemLog("用户管理更新班车")
    public Result update(Busroute busroute) {
        System.out.println(busroute.toString());
        System.out.println("&&&&&&&&&&&");
        busRouteService.updateBusRoute(busroute);
        return Result.success();
    }

    @ResponseBody
    @PostMapping("/delete")
    @RequiresPermissions("bus:view")
    @SystemLog("用户管理删除用户")
    public Result delete(@RequestParam("busid") Integer[] ids, HttpServletRequest request) {
        Arrays.asList(ids).forEach(id -> busRouteService.deletebusroute(id));
        return Result.success();
    }

    @Resource
    private NamefromtoService namefromtoService;

    private void setCommonData(Model model) {
        List<Namefromto> a = namefromtoService.findAll();
        model.addAttribute("namefromList",a);
        model.addAttribute("busRouteList",busRouteService.findAll());
    }

    @RequestMapping("/checkNo")
    public void checkNo( Busroute busroute, HttpServletResponse response){
        int count = busRouteService.selectOne(busroute);
        if(count == 1){
            response.setStatus(400);
        }else {
            response.setStatus(200);
        }
    }
    @RequestMapping("/checkTrue")
    public void checkTrue( Busroute busroute,  HttpServletResponse response){
        response.setStatus(200);
    }

}


