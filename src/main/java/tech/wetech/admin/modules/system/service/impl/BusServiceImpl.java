package tech.wetech.admin.modules.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.wetech.admin.modules.system.mapper.BusMapper;
import tech.wetech.admin.modules.system.po.Bus;
import tech.wetech.admin.modules.system.po.Busroute;
import tech.wetech.admin.modules.system.service.BusService;

import javax.annotation.Resource;


@Service
public class BusServiceImpl implements BusService {

    @Resource
    private BusMapper busMapper;
    @Override
    public void insert(Bus bus) {
        System.out.println("这里是新增的bus内容");
        System.out.println(bus.toString());
        System.out.println("*************");
        busMapper.insertSelective(bus);
    }

    @Override
    @Transactional
    public void update(Bus bus) {
        System.out.println("这里是update的内容:bus");
        System.out.println(bus.toString());
        System.out.println("*************");
        busMapper.update(bus);
    }

    @Override
    public void deletebusroute(Long id) {
        busMapper.deleteByPrimaryKey1(id);
    }

    @Override
    public int selectOne(Busroute busroute) {
        System.out.println("********************");
        System.out.println(busroute.toString());
        int a = busMapper.selectByNo(busroute);
        System.out.println("********************");
        return a;
    }

    @Override
    public Bus findAll(String a) {
        return busMapper.selectByLinence(a);
    }

    @Override
    public Long[] DriverPhone(String a) {
        return busMapper.DriverPhone(a);
    }

    @Override
    public Long selectByBusid(Long id) {
        return busMapper.selectByBusid(id);
    }

}
