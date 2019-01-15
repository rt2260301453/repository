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
import tech.wetech.admin.core.utils.ResultCodeEnum;
import tech.wetech.admin.modules.system.dto.SubareaDto;
import tech.wetech.admin.modules.system.po.Addr;
import tech.wetech.admin.modules.system.po.Subarea;
import tech.wetech.admin.modules.system.query.SubareaQuery;
import tech.wetech.admin.modules.system.service.*;
import tech.wetech.admin.modules.system.service.excel.PoiExcelExport;
import tech.wetech.admin.modules.system.service.excel.ServletUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author cjbi
 */
@Controller
@RequestMapping("/subarea")
public class SubareaController extends BaseController {

    @Autowired
    private SubareaService subareaService;

    @Autowired
    private OrganizationService organizationService;

    @GetMapping
    @RequiresPermissions("subarea:view")
    public String page(Model model) {
        setCommonData(model);
        return "system/subarea/subarea";
    }

    @ResponseBody
    @RequestMapping("/list")
    @RequiresPermissions("subarea:view")
    @SystemLog("���������ѯ����")
    public PageResultSet<SubareaDto> list(SubareaQuery subareaQuery) {
        System.out.println("subareaQuery��"+subareaQuery);
        System.out.println("subareaQuery��"+StringUtils.isEmpty(subareaQuery.getCity()));
        if (!StringUtils.isEmpty(subareaQuery.getCity())&&!StringUtils.isEmpty(subareaQuery.getCity())){
            if(subareaQuery.getCity().equals("��ѡ��") || subareaQuery.getCounty().equals("��ѡ��")){
            subareaQuery = new SubareaQuery();
            }
        }
        return subareaService.findByPage(subareaQuery);
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
    @SystemLog("����������������")
    public Result create(@Valid Subarea subarea) {
        System.out.println("��ӷ�������:"+subarea);
        subareaService.createUser(subarea);
        System.out.println("��ӷ�������Result.success():"+Result.success());
        return Result.success();
    }


    @ResponseBody
    @PostMapping("/update")
    @RequiresPermissions("subarea:update")
    @SystemLog("�û���������û�")
    public Result update(Subarea subarea) {
        subareaService.updateUser(subarea);
        return Result.success();
    }

    @ResponseBody
    @PostMapping("/delete")
    @RequiresPermissions("subarea:delete")
    @SystemLog("��������ɾ������")
    public Result delete(@RequestParam("id") String[] ids, HttpServletRequest request) {
        // ��ȡ����id�����飩
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


    @RequestMapping("/exportexcel")//����excel
    public void exportExcel(HttpServletRequest request, HttpServletResponse response) {
        // ��ȡ����
        String fileName = "���������.xls";
        System.out.println("subareaMapper.selectAll()123121");
        ServletUtil su = new ServletUtil(fileName, request, response);
        su.poiExcelServlet();

        //-----------------apache.POI���----------------------------------

        String[] heads = { "�ּ���", "�������", "ʡ","��","��","����","�ؼ���","�����ؼ���","��ʼ��","��ֹ��","��˫��"};//excel��ͷ
        String[] cols = { "id", "fixedareaId", "pro","city","county","attribute","keyword","auxiliarykeywords","starnum","endnum", "single"};
        int[] numerics = {};//����������

        List<Subarea> list = subareaService.excel();
        System.out.println("subareaMapper.selectAll()123121:"+list);
        //---------------------------------------------------
        ServletUtil suresp = new ServletUtil(response);
        PoiExcelExport<Subarea> pee = new PoiExcelExport<Subarea>(fileName, heads, cols, list, numerics, suresp.getOut());
        pee.exportExcel();
    }






    private void setCommonData(Model model) {
        model.addAttribute("findAddr",subareaService.findPro());
        model.addAttribute("findEdit",subareaService.findEdit());
        model.addAttribute("organizationList", organizationService.findAll());
        System.out.println("-------------------------------------"+subareaService.findPro());
        System.out.println("-------------------------------------"+subareaService.findEdit());
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
    }

    @ResponseBody
    @RequestMapping("/selectCity")
    public List<Addr> selectAllCountry(Addr addr) {
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        System.out.println(subareaService.selectCity(addr));
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        return subareaService.selectCity(addr);
    }

    @ResponseBody
    @RequestMapping("/selectCou")
    public List<Addr> selectAllCou(Addr addr) {
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        System.out.println(subareaService.selectCou(addr));
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        return subareaService.selectCou(addr);
    }

}
