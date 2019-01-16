package tech.wetech.admin.modules.system.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.modules.system.dto.StaffDto;
import tech.wetech.admin.modules.system.mapper.BusRouteMapper2;
import tech.wetech.admin.modules.system.mapper.StaffMapper;
import tech.wetech.admin.modules.system.mapper.SubBasicMapper;
import tech.wetech.admin.modules.system.po.Bus;
import tech.wetech.admin.modules.system.po.Staff;
import tech.wetech.admin.modules.system.po.SubBasic;
import tech.wetech.admin.modules.system.query.StaffQuery;
import tech.wetech.admin.modules.system.service.StaffService;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    @Resource
    private StaffMapper staffMapper;

    @Resource
    private SubBasicMapper subBasicMapper;

    @Resource
    private BusRouteMapper2 busRouteMapper2;

    @Override
    public PageResultSet<StaffDto> findByPage(StaffQuery staffQuery) {
        if(!StringUtils.isEmpty(staffQuery.getOrderBy())) {
            PageHelper.orderBy(staffQuery.getOrderBy());
        }

        Weekend<Staff> example = Weekend.of(Staff.class);
        WeekendCriteria<Staff, Object> criteria = example.weekendCriteria();

        if (!StringUtils.isEmpty(staffQuery.getStaid())) {
            criteria.andLike(Staff::getStaid, "%" + staffQuery.getStaid() + "%");
        }

        if (!StringUtils.isEmpty(staffQuery.getName())) {
            criteria.andLike(Staff::getName, "%" + staffQuery.getName() + "%");
        }

        if (!StringUtils.isEmpty(staffQuery.getDeltag())) {
            criteria.andLike(Staff::getDeltag, "%" + staffQuery.getDeltag() + "%");
        }

        if (!StringUtils.isEmpty(staffQuery.getStation())) {
            criteria.andLike(Staff::getStation, "%" + staffQuery.getStation() + "%");
        }

        List<StaffDto> dtoList = new ArrayList<>();

        PageHelper.offsetPage(staffQuery.getOffset(), staffQuery.getLimit());
        staffMapper.selectByExample(example).forEach(u -> {
            StaffDto dto = new StaffDto(u);
            dtoList.add(dto);
        });

        long total = staffMapper.selectCountByExample(example);
        PageResultSet<StaffDto> resultSet = new PageResultSet<>();
        resultSet.setRows(dtoList);
        resultSet.setTotal(total);
        return resultSet;

    }

    @Override
    public List<Staff> findAll() {
        System.out.print("=====================================================");
        List<Staff> staff = staffMapper.selectAll();
        for (Staff aa:staff
             ) {
            System.out.print("=====================================================");
            System.out.print("数据："+aa);
        }
       return staffMapper.selectAll();
    }

    @Override
    @Transactional
    public void createStaff(Staff staff) {
        staffMapper.insertSelective(staff);
    }

    @Override
    @Transactional
    public void updatestaff(Staff staff) {
        staffMapper.updateByPrimaryKeySelective(staff);
    }

    @Override
    @Transactional
    public void deleteStaff(Long id) {
        staffMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int checkstaffid(Staff id) {
        int count = (int) staffMapper.selectstaffid(id);
        return count;
    }

    @Override
    public List<SubBasic> findbasic() {
        List<SubBasic> subBasic = subBasicMapper.selectAll();
        return subBasic;
    }

    @Override
    public List<Bus> findbusRoute() {
        List<Bus> subBasic = busRouteMapper2.selectAll();
        return subBasic;
    }
}
