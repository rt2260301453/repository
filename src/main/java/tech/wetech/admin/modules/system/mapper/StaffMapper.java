package tech.wetech.admin.modules.system.mapper;

import org.apache.ibatis.annotations.Select;
import tech.wetech.admin.core.utils.MyMapper;
import tech.wetech.admin.modules.system.po.Staff;

import java.util.List;
import java.util.Map;

public interface StaffMapper extends MyMapper<Staff> {
    @Select("select count(1) from staff where staid=#{staid}")
    int selectstaffid(Staff staff);
<<<<<<< HEAD

    @Select("select * from staff where staid=#{staid}")
    public Staff queryAllRouteForSelect(String staid);

//    @Select("select station from staff where staid=#{staid}")
//    String querystation(String staid);
=======
    
    @Select("select * from staff where staid=#{staid}")
    Staff selectstaff(Staff staff);
>>>>>>> 4fda17d58cafde2acf6796a63b33a4ca9cc53f2e
}