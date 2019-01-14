package tech.wetech.admin.modules.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.transaction.annotation.Transactional;
import tech.wetech.admin.modules.system.mapper.RouteMapper;
import tech.wetech.admin.modules.system.po.Route;
import tech.wetech.admin.modules.system.service.RouteService;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class RouteServiceImpl implements RouteService {
    @Resource
    private RouteMapper routeMapper;

    @Override
    public void insert(Route route) {
        System.out.println("这里是新增的route内容");
        System.out.println(route.toString());
        System.out.println("*********************");
        routeMapper.insertSelective(route);
    }

    @Override
    public int selectByDate(Route route) {
        return routeMapper.selectByDate(route);
    }

    @Override
    public void update( Route route) {
        System.out.println("这里是update的内容:route");
        System.out.println(route.toString());
        System.out.println("*************");
        routeMapper.update(route);
    }

    @Override
    public void deletebusroute(Long id) {
        routeMapper.deleteByPrimaryKey1(id);
    }
}
