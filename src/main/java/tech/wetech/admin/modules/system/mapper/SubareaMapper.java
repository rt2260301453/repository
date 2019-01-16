package tech.wetech.admin.modules.system.mapper;

import org.apache.ibatis.annotations.Select;
import tech.wetech.admin.core.utils.MyMapper;
import tech.wetech.admin.modules.system.po.Addr;
import tech.wetech.admin.modules.system.po.Subarea;

import java.util.List;
import java.util.Map;

public interface SubareaMapper extends MyMapper<Subarea> {

    @Select(value = "select count(1) from Subarea where id=#{id}")
    int selectByNo(Subarea subarea);

    @Select(value = "select DISTINCT pro from Subarea")
    List<Addr> selectByPro();

    @Select(value = "select DISTINCT pro,city,county from Subarea")
    List<Addr> selectByAddr();

    @Select(value = "select distinct city from subarea where pro=#{pro}")
    List<Addr> selectCity(Addr addr);

    @Select(value = "select distinct county from subarea where city=#{city}")
    List<Addr> selectCou(Addr addr);


}