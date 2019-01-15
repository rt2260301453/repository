package tech.wetech.admin.modules.system.mapper;

import org.apache.ibatis.annotations.Select;
import tech.wetech.admin.core.utils.MyMapper;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.modules.system.dto.BusRouteDto;
import tech.wetech.admin.modules.system.po.Busroute;
import tech.wetech.admin.modules.system.query.BusRouteQuery;

public interface BusrouteMapper extends MyMapper<Busroute> {
    @Select(value = "select count(1) from busroute where license=#{license}")
    int selectByNo(Busroute busroute);
}