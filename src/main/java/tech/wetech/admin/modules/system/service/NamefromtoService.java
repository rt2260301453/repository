package tech.wetech.admin.modules.system.service;

import org.springframework.stereotype.Service;
import tech.wetech.admin.core.utils.MyMapper;
import tech.wetech.admin.modules.system.po.Namefromto;

import java.util.List;

@Service
public interface NamefromtoService  {
    List<Namefromto> findAll();
}
