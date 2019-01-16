package tech.wetech.admin.modules.system.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import java.util.HashMap;
import java.util.Map;

/**
 * @author rt
 */
@Controller
@RequestMapping("/fixedArea")
public class FixedAreaController {
    @Autowired
    private FixedAreaService fixedAreaService;

    @GetMapping
    @RequiresPermissions("fixedarea:view")
    public String page() {
        return "system/fixedarea/fixedarealist";
    }

    @ResponseBody
    @RequestMapping("/list")
    @RequiresPermissions("fixedarea:view")
    public PageResultSet<FixedAreaDto> list(FixedAreaQuery fixedAreaQuery) {
        System.out.println("********************************************************");
        System.out.println("fixedName="+fixedAreaQuery.getFixedareaname());
        System.out.println("fixedManager="+fixedAreaQuery.getFixedareamanager());
        return fixedAreaService.findByPage(fixedAreaQuery);
    }

    @ResponseBody
    @RequiresPermissions("fixedarea:create")
    @RequestMapping("/create")
    @SystemLog("定区管理新增定区")
    public Result insert(@Valid FixedArea fixedArea){
        fixedAreaService.insertOne(fixedArea);
        return  Result.success();
    }

    @ResponseBody
    @RequiresPermissions("fixedarea:update")
    @RequestMapping("/update")
    @SystemLog("定区管理更新定区")
    public Result update(@Valid FixedArea fixedArea){
        fixedAreaService.updateOne(fixedArea);
        return  Result.success();
    }

    @ResponseBody
    @RequiresPermissions("fixedarea:delete")
    @RequestMapping("/delete")
    @SystemLog("定区管理删除定区")
    public Result delete(@RequestParam("id") Long[] ids){
        Arrays.asList(ids).forEach(id -> fixedAreaService.deleteOne(id));
        return Result.success();
    }

    @RequestMapping("/checkNo")
    public void checkNo(@Valid FixedArea fixedArea, HttpServletResponse response){
        System.out.println("********************************************************");
        System.out.println("fixedNo="+fixedArea.getFixedareano());
        int count = fixedAreaService.selectOne(fixedArea);
        System.out.println("fixedNo="+fixedArea.getFixedareano());
        if(count == 1){
            response.setStatus(400);
        }else {
            response.setStatus(200);
        }
    }

    @RequestMapping("/checkTrue")
    public void checkTrue(@Valid FixedArea fixedArea, HttpServletResponse response){
        response.setStatus(200);
    }
}
