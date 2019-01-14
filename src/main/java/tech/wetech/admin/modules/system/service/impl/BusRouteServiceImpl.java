package tech.wetech.admin.modules.system.service.impl;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tech.wetech.admin.core.exception.BizException;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.core.utils.ResultCodeEnum;
import tech.wetech.admin.modules.system.dto.BusRouteDto;
import tech.wetech.admin.modules.system.mapper.BusrouteMapper;
import tech.wetech.admin.modules.system.mapper.UserMapper;
import tech.wetech.admin.modules.system.po.Busroute;
import tech.wetech.admin.modules.system.po.User;
import tech.wetech.admin.modules.system.query.BusRouteQuery;
import tech.wetech.admin.modules.system.service.*;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class BusRouteServiceImpl implements BusRouteService {
    @Resource
    private BusrouteMapper busrouteMapper;

    @Resource
    private UserMapper userMapper;

    @Autowired
    private RoleService roleService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private PasswordHelper passwordHelper;

    @Override
    @Transactional
    public PageResultSet<BusRouteDto> findByPage(BusRouteQuery busRouteQuery) {
        if(!StringUtils.isEmpty(busRouteQuery.getOrderBy())) {
            PageHelper.orderBy(busRouteQuery.getOrderBy());
        }
        Weekend<Busroute> example = Weekend.of(Busroute.class);
        WeekendCriteria<Busroute, Object> criteria = example.weekendCriteria();

        if(!StringUtils.isEmpty(busRouteQuery.getNamefrom())){
            if(!busRouteQuery.getNamefrom().equals("请输入要查询的始发地")){
                criteria.andLike(Busroute::getNamefrom, "%" + busRouteQuery.getNamefrom() + "%");
            }
        }
        if(!StringUtils.isEmpty(busRouteQuery.getNameto())){
            if(!busRouteQuery.getNameto().equals("请输入要查询的始发地")){
                criteria.andLike(Busroute::getNameto, "%" + busRouteQuery.getNameto() + "%");
            }
        }
        if(!StringUtils.isEmpty(busRouteQuery.getDriver())){
            criteria.andLike(Busroute::getDriver, "%" + busRouteQuery.getDriver() + "%");
        }
        if(!StringUtils.isEmpty(busRouteQuery.getOperators())){
            criteria.andLike(Busroute::getOperators, "%" + busRouteQuery.getOperators() + "%");
        }
        if(!StringUtils.isEmpty(busRouteQuery.getLicense())){
            criteria.andLike(Busroute::getLicense, "%" + busRouteQuery.getLicense() + "%");
        }
        if(!StringUtils.isEmpty(busRouteQuery.getStyle())){
            if(!busRouteQuery.getStyle().equals("全部")){
                criteria.andLike(Busroute::getStyle, "%" + busRouteQuery.getStyle() + "%");
            }
        }
        List<BusRouteDto> dtoList = new ArrayList<>();

        PageHelper.offsetPage(busRouteQuery.getOffset(), busRouteQuery.getLimit());

        busrouteMapper.selectByExample(example).forEach(u -> {
            BusRouteDto dto = new BusRouteDto(u);
            dto.setModel(u.getModel());
            dto.setLicense(u.getLicense());
            dto.setOperators(u.getOperators());
            dto.setBusid(u.getBusid());
            dto.setDriver(u.getDriver());
            dto.setPhone(u.getPhone());
            dto.setRemark(u.getRemark());
            dto.setStyle(u.getStyle());
            dto.setCompany(u.getCompany());
            dto.setOperator(u.getOperator());
            dto.setNamefrom(u.getNamefrom());
            dto.setNameto(u.getNameto());
            dto.setModel(u.getModel());
            dto.setWeight(u.getWeight());
             dto.setDate(u.getDate());
            dtoList.add(dto);
        });

        long total = busrouteMapper.selectCountByExample(example);
        PageResultSet<BusRouteDto> resultSet = new PageResultSet<>();
        resultSet.setRows(dtoList);
        resultSet.setTotal(total);
        return resultSet;
    }

    @Override
    @Transactional
    public List<Busroute> findAll() {
        return busrouteMapper.selectAll();
    }

    @Override
    @Transactional
    public void updateBusRoute(Busroute busroute) {
        System.out.println("&&&&&&&&&&&&&&&&&&");
        busrouteMapper.updateByPrimaryKeySelective(busroute);
    }

    @Override
    public void deletebusroute(Integer id) {
        busrouteMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void createQuYu(Busroute busroute) {
        busrouteMapper.insertSelective(busroute);
    }

    @Override
    public int selectOne(Busroute busroute) {
         return busrouteMapper.selectByNo(busroute);
    }

}
