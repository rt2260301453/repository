package tech.wetech.admin.modules.system.mapper;

import org.apache.ibatis.annotations.Select;
import tech.wetech.admin.core.utils.MyMapper;
import tech.wetech.admin.modules.system.po.Staff;

public interface StaffMapper extends MyMapper<Staff> {
    @Select("select count(1) from staff where staid=#{staid}")
    int selectstaffid(Staff staff);
}