package tech.wetech.admin.modules.system.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.modules.system.dto.ReplayDto;
import tech.wetech.admin.modules.system.query.ReplayQuery;
import tech.wetech.admin.modules.system.service.ReplayService;
import tech.wetech.admin.modules.system.service.StaffService;

import javax.annotation.Resource;

@Controller
@RequestMapping("/replayof")
public class ReplayofController {

    @Resource
    private ReplayService replayService;

    @Autowired
    private StaffService staffService;

    @RequestMapping
    @RequiresPermissions("replayof:view")
    public String page(Model model) {
        return "system/sendandget/replayof";
    }

    @ResponseBody
    @RequestMapping("/list2")
    @RequiresPermissions("replayof:view")
    public PageResultSet<ReplayDto> list2(ReplayQuery replayQuery) {
        System.out.println(replayQuery.getReplayid());
        return replayService.findByPage(replayQuery);
    }
}
