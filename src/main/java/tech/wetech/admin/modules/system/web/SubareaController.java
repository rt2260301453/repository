package tech.wetech.admin.modules.system.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import tech.wetech.admin.core.annotation.SystemLog;
import tech.wetech.admin.core.utils.BaseController;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.core.utils.Result;
import tech.wetech.admin.modules.system.dto.SubareaDto;
import tech.wetech.admin.modules.system.po.Addr;
import tech.wetech.admin.modules.system.po.Subarea;
import tech.wetech.admin.modules.system.query.QuYuQuery;
import tech.wetech.admin.modules.system.query.SubareaQuery;
import tech.wetech.admin.modules.system.service.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * @author cjbi
 */
@Controller
@RequestMapping("/subarea")
public class SubareaController extends BaseController {

    @Autowired
    private SubareaService subareaService;

    @Autowired
    private QuYuService quYuService;


    @GetMapping
    @RequiresPermissions("subarea:view")
    public String page(Model model) {
        setCommonData(model);
        return "system/subarea/subarea";
    }

    @ResponseBody
    @RequestMapping("/list")
    @RequiresPermissions("subarea:view")
    @SystemLog("分区管理查询分区")
    public PageResultSet<SubareaDto> list(SubareaQuery subareaQuery) {
        System.out.println("subareaQuery："+subareaQuery);
        System.out.println("subareaQuery："+StringUtils.isEmpty(subareaQuery.getCity()));
        if (!StringUtils.isEmpty(subareaQuery.getCity())&&!StringUtils.isEmpty(subareaQuery.getCity())){
            if(subareaQuery.getCity().equals("请选择") || subareaQuery.getCounty().equals("请选择")){
            subareaQuery = new SubareaQuery();
            }
        }
        return subareaService.findByPage(subareaQuery);
    }

    @ResponseBody
    @RequestMapping("/addCity")
    public List findQuYuCity(QuYuQuery quYuQuery ) {
        System.out.println("quYuQuery"+quYuQuery);
        System.out.println("subareaService.findQuYuCity(quYuQuery)"+subareaService.findQuYuCity(quYuQuery));
        return subareaService.findQuYuCity(quYuQuery);
    }

    @ResponseBody
    @RequestMapping("/addcounty")
    public List findQuYuCounty(QuYuQuery quYuQuery) {
        return subareaService.findQuYuCounty(quYuQuery);
    }


    @ResponseBody
    @RequestMapping("/city")
    public List findcity(SubareaQuery subareaQuery) {
        return subareaService.findCity(subareaQuery);
    }

    @ResponseBody
    @RequestMapping("/county")
    public List findcounty(SubareaQuery subareaQuery) {
        return subareaService.findCounty(subareaQuery);
    }

    @ResponseBody
    @PostMapping("/create")
    @RequiresPermissions("subarea:create")
    @SystemLog("分区管理新增分区")
    public Result create(@Valid Subarea subarea) {
        System.out.println("添加分区数据:"+subarea);
        subareaService.createUser(subarea);
        System.out.println("添加分区数据Result.success():"+Result.success());
        return Result.success();
    }


    @ResponseBody
    @PostMapping("/update")
    @RequiresPermissions("subarea:update")
    @SystemLog("用户管理更新用户")
    public Result update(Subarea subarea) {
        subareaService.updateUser(subarea);
        return Result.success();
    }

    @ResponseBody
    @PostMapping("/delete")
    @RequiresPermissions("subarea:delete")
    @SystemLog("分区管理删除分区")
    public Result delete(@RequestParam("id") String[] ids, HttpServletRequest request) {
        // 获取分区id（数组）
        Arrays.asList(ids).forEach(id ->subareaService.deleteId(id));
        System.out.println("Result.success:"+Result.success());
        return Result.success();
    }

    @RequestMapping("/checkId")
    public void checkNo(String id, HttpServletResponse response){
        Subarea subarea = new Subarea();
        subarea.setId(id);
      int count = subareaService.selectOneno(subarea);
        if(count == 1){
           response.setStatus(400);
        }else {
            response.setStatus(200);
        }
    }







    private void setCommonData(Model model) {
        model.addAttribute("findAddr",subareaService.findPro());
        model.addAttribute("findEdit",subareaService.findEdit());
        model.addAttribute("findQuYuAll",subareaService.findQuYuAll());
    }

    @ResponseBody
    @RequestMapping("/selectCity")
    public List<Addr> selectAllCountry(Addr addr) {

        return subareaService.selectCity(addr);
    }

    @ResponseBody
    @RequestMapping("/selectCou")
    public List<Addr> selectAllCou(Addr addr) {
        return subareaService.selectCou(addr);
    }

}
