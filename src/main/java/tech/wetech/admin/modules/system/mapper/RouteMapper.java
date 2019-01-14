package tech.wetech.admin.modules.system.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tech.wetech.admin.core.utils.MyMapper;
import tech.wetech.admin.modules.system.po.Route;

import java.util.Date;

public interface RouteMapper extends MyMapper<Route> {
    @Select("select routeid  from route where date=#{date}")
    int selectByDate(Route route);
    @Update("update route set style=#{style},namefrom=#{namefrom},nameto=#{nameto}," +
            "remark=#{remark},operator=#{operator},date=#{date} where routeid=#{routeid}")
    void update(Route route);

    @Delete("delete from route where routeid=#{id}")
    void deleteByPrimaryKey1(Long id);
}