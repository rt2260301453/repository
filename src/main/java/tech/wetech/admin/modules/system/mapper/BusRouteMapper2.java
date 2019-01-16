package tech.wetech.admin.modules.system.mapper;

import tech.wetech.admin.core.utils.MyMapper;
import tech.wetech.admin.modules.system.dto.BusRouteDto;
import tech.wetech.admin.modules.system.po.Bus;
import tech.wetech.admin.modules.system.query.BusRouteQuery;

import java.util.List;

public interface BusRouteMapper2  extends MyMapper<Bus>{

    List<BusRouteDto> selectByQuery(BusRouteQuery busRouteQuery);


}
