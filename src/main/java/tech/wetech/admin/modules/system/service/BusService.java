package tech.wetech.admin.modules.system.service;

import org.springframework.stereotype.Service;
import tech.wetech.admin.modules.system.po.Bus;
import tech.wetech.admin.modules.system.po.Busroute;
import tech.wetech.admin.modules.system.service.impl.BusServiceImpl;
@Service
public interface BusService {

    void insert(Bus bus);

    void update(Bus bus);

    void deletebusroute(Long id);

    int selectOne(Busroute busroute);

    Bus findAll(String a);

    Long[] DriverPhone(String s);

    Long selectByBusid(Long id);

}
