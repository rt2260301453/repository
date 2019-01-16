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
import tech.wetech.admin.modules.system.dto.BusRouteDto;
import tech.wetech.admin.modules.system.po.Bus;
import tech.wetech.admin.modules.system.po.Busroute;
import tech.wetech.admin.modules.system.po.Namefromto;
import tech.wetech.admin.modules.system.po.Route;
import tech.wetech.admin.modules.system.query.BusRouteQuery;
import tech.wetech.admin.modules.system.service.BusRouteService2;
import tech.wetech.admin.modules.system.service.BusService;
import tech.wetech.admin.modules.system.service.NamefromtoService;
import tech.wetech.admin.modules.system.service.RouteService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/bus1")
public class BusRouteController2 {
    @GetMapping
    @RequiresPermissions("bus:view")
    public String page(Model model) {
        setCommonData(model);
        return "system/busroute/busroute";
    }

    @Resource
    private NamefromtoService namefromtoService;

    private void setCommonData(Model model) {
        List<Namefromto> a = namefromtoService.findAll();
        System.out.println(a.toString());
        model.addAttribute("namefromList", a);
    }

    @Autowired
    private BusRouteService2 busRouteService2;

    @ResponseBody
    @RequestMapping("/list")
    @RequiresPermissions("bus:view")
    public PageResultSet<BusRouteDto> list(BusRouteQuery busRouteQuery) {
        return busRouteService2.findByPage(busRouteQuery);
        //return null;
    }

    @Autowired
    private RouteService routeService;

    @Autowired
    private BusService busService;

    @ResponseBody
    @PostMapping("/create")
    @RequiresPermissions("bus:view")
    @SystemLog("新增班车路线信息")
    public Result create(Busroute busroute) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        busroute.setOperator(username);
        busroute.setCompany("啦啦啦公司");
        Date a = new Date();
        busroute.setDate(a);

        @Valid
        Bus bus = new Bus();
        bus.setLicense(busroute.getLicense());
        bus.setDriver(busroute.getDriver());
        bus.setOperators(busroute.getOperators());
        bus.setBusid(busroute.getBusid());
        bus.setCompany(busroute.getCompany());
        bus.setPhone(busroute.getPhone());
        bus.setDate(busroute.getDate());
        bus.setModel(busroute.getModel());
        bus.setOperater(busroute.getOperator());
        bus.setWeight(busroute.getWeight());

        @Valid
        Route route = new Route();
        route.setCompany(busroute.getCompany());
        route.setDate(busroute.getDate());
        route.setNamefrom(busroute.getNamefrom());
        route.setNameto(busroute.getNameto());
        route.setOperator(busroute.getOperator());
        route.setRemark(busroute.getRemark());
        route.setStyle(busroute.getStyle());

        routeService.insert(route);
        int routeid = routeService.selectByDate(route);
        bus.setRouteid(routeid);
        busService.insert(bus);
        return Result.success();
    }

    @ResponseBody
    @PostMapping("/update")
    @RequiresPermissions("bus:view")
    @SystemLog("跟新班车路线信息")
    public Result update(Busroute busroute) {
        System.out.println("这里是update的busroute内容");
        System.out.println(busroute.toString());
        System.out.println("*************");
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        busroute.setOperator(username);
        busroute.setCompany("啦啦啦公司");

        Date a = new Date();
        busroute.setDate(a);
        @Valid
        Bus bus = new Bus();
        bus.setRouteid(busroute.getRouteid());
        bus.setLicense(busroute.getLicense());
        bus.setDriver(busroute.getDriver());
        bus.setOperators(busroute.getOperators());
        bus.setBusid(busroute.getBusid());
        bus.setCompany(busroute.getCompany());
        bus.setPhone(busroute.getPhone());
        bus.setDate(busroute.getDate());
        bus.setModel(busroute.getModel());
        bus.setOperater(busroute.getOperator());
        bus.setWeight(busroute.getWeight());

        @Valid
        Route route = new Route();
        route.setCompany(busroute.getCompany());
        route.setDate(busroute.getDate());
        route.setNamefrom(busroute.getNamefrom());
        route.setNameto(busroute.getNameto());
        route.setOperator(busroute.getOperator());
        route.setRemark(busroute.getRemark());
        route.setStyle(busroute.getStyle());
        route.setRouteid(busroute.getRouteid());

        routeService.update(route);
        busService.update(bus);
        return Result.success();
    }


    @ResponseBody
    @PostMapping("/delete")
    @RequiresPermissions("bus:view")
    @SystemLog("删除班车路线信息")
    public Result delete(@RequestParam("routeid") Long[] ids, HttpServletRequest request) {
        System.out.println("删除环节");
        Arrays.asList(ids).forEach(id -> routeService.deletebusroute(id));
        return Result.success();
    }

    @RequestMapping("/checkNo")
    public void checkNo(Busroute busroute, HttpServletResponse response) {
        int count = busService.selectOne(busroute);
        if (count == 1) {
            response.setStatus(400);
        } else {
            response.setStatus(200);
        }
    }


    @RequestMapping("/checkTrue")
    public void checkTrue(Busroute busroute, HttpServletResponse response) {
        response.setStatus(200);
    }


    @ResponseBody
    @RequestMapping("/checkNo1")
    @RequiresPermissions("bus:view")
    public String DriverPhone(String driver, HttpServletResponse response, Model model) {
        System.out.println(driver);
        System.out.println("进入到由司机自动填充电话的");
        if(driver.equals("")){
            return "";
        }
        Long[] number = busService.DriverPhone(driver);
        System.out.println(number.toString());
        System.out.println("****************");
        if (number.length!= 0) {
            return Long.toString(number[0]);
        } else {
            return "";
        }
    }

    @RequestMapping("/checknamefromto")
    public void checknamefromto(String namefrom,String nameto, HttpServletResponse response) {
        System.out.println(namefrom);
        System.out.println("*************");
        System.out.println(nameto);
        if (namefrom == nameto) {
            response.setStatus(400);
        } else {
            response.setStatus(200);
        }
    }
}
