package tech.wetech.admin.modules.system.service;

import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.modules.system.dto.BusRouteDto;
import tech.wetech.admin.modules.system.query.BusRouteQuery;

public interface BusRouteService2 {
    PageResultSet<BusRouteDto> findByPage(BusRouteQuery busRouteQuery);
}
