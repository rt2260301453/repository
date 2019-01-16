package tech.wetech.admin.modules.system.service;

import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.modules.system.dto.StaffDto;
import tech.wetech.admin.modules.system.po.Bus;
import tech.wetech.admin.modules.system.po.Staff;
import tech.wetech.admin.modules.system.po.SubBasic;
import tech.wetech.admin.modules.system.query.StaffQuery;

import java.util.List;


public interface StaffService {

    PageResultSet<StaffDto> findByPage(StaffQuery staffQuery);

    List<Staff> findAll();

    void createStaff(Staff staff);

    void updatestaff(Staff staff);

    void deleteStaff(Long id);

    int checkstaffid(Staff id);

    List<SubBasic> findbasic();


    List<Bus> findbusRoute();
}
