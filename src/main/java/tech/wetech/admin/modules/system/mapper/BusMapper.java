package tech.wetech.admin.modules.system.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tech.wetech.admin.core.utils.MyMapper;
import tech.wetech.admin.modules.system.po.Bus;
import tech.wetech.admin.modules.system.po.Busroute;

public interface BusMapper extends MyMapper<Bus> {
    @Update(value = "update bus set license=#{license},model=#{model},driver=#{driver}," +
            "phone=#{phone},operater=#{operater},weight=#{weight},date=#{date} where busid=#{busid}")
    void update(Bus bus);

    @Delete("delete from bus where busid=#{id}")
    void deleteByPrimaryKey1(Long id);

    @Select(value = "select count(1) from bus where license=#{license}")
    int selectByNo(Busroute busroute);
    
@Select("select * from bus where lincese=#{a}")
    Bus selectByLinence(String a);

@Select("select phone from bus where driver=#{a}")
    Long[] DriverPhone(String a);

    @Select("select routeid from bus where busid=#{id}")
    Long selectByBusid(Long id);

}