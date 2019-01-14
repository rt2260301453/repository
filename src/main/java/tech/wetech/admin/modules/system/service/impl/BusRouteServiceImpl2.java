package tech.wetech.admin.modules.system.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.modules.system.dto.BusRouteDto;
import tech.wetech.admin.modules.system.mapper.BusRouteMapper2;
import tech.wetech.admin.modules.system.po.Busroute;
import tech.wetech.admin.modules.system.query.BusRouteQuery;
import tech.wetech.admin.modules.system.service.BusRouteService2;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BusRouteServiceImpl2 implements BusRouteService2 {
    @Resource
    private BusRouteMapper2 busRouteMapper2;
    @Override
    public PageResultSet<BusRouteDto> findByPage(BusRouteQuery busRouteQuery) {
        if(!StringUtils.isEmpty(busRouteQuery.getOrderBy())) {
            PageHelper.orderBy(busRouteQuery.getOrderBy());
        }
        Weekend<Busroute> example = Weekend.of(Busroute.class);
        WeekendCriteria<Busroute, Object> criteria = example.weekendCriteria();

        List<BusRouteDto> dtoList = new ArrayList<>();
        PageHelper.offsetPage(busRouteQuery.getOffset(), busRouteQuery.getLimit());
        System.out.println(busRouteQuery.toString());

        dtoList = busRouteMapper2.selectByQuery(busRouteQuery);
        PageResultSet<BusRouteDto> resultSet = new PageResultSet<>();
        resultSet.setRows(dtoList);
        long a = dtoList.size();
        resultSet.setTotal(a);
        return resultSet;
    }
}
