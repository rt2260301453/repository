package tech.wetech.admin.modules.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.admin.modules.system.mapper.NamefromtoMapper;
import tech.wetech.admin.modules.system.po.Namefromto;
import tech.wetech.admin.modules.system.service.NamefromtoService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NamefromtoServiceImpl implements NamefromtoService {

    @Resource
    private NamefromtoMapper namefromtoMapper;

    @Override
    public List<Namefromto> findAll() {
        return namefromtoMapper.selectAll();
    }
}
