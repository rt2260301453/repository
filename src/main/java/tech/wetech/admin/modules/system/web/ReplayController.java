package tech.wetech.admin.modules.system.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.modules.system.dto.ReplayDto;
import tech.wetech.admin.modules.system.query.ReplayQuery;
import tech.wetech.admin.modules.system.service.ReplayService;

import javax.annotation.Resource;

@Controller
@RequestMapping("/replay")
public class ReplayController {
    @Resource
    private ReplayService replayService;

    @GetMapping
    @RequiresPermissions("replay:view")
    public String page(Model model) {
        return "system/sendandget/querystafflist";
    }

    @ResponseBody
    @RequestMapping("/list")
    @RequiresPermissions("replay:view")
    public PageResultSet<ReplayDto> list(ReplayQuery replayQuery) {
        System.out.println(replayQuery.getReplayid());
        return replayService.findByPage(replayQuery);
    }
}
