package tech.wetech.admin.modules.system.service;

import org.springframework.stereotype.Service;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.modules.system.dto.BusRouteDto;
import tech.wetech.admin.modules.system.po.Busroute;
import tech.wetech.admin.modules.system.po.FixedArea;
import tech.wetech.admin.modules.system.query.BusRouteQuery;

import java.util.List;

@Service
public interface BusRouteService {
    PageResultSet<BusRouteDto> findByPage(BusRouteQuery busRouteQuery);

    List<Busroute> findAll();

    void updateBusRoute(Busroute busroute);

    void deletebusroute(Integer id);

    void createQuYu(Busroute busroute);

    int selectOne(Busroute busroute);
}
