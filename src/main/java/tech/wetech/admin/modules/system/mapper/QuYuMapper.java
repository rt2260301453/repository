package tech.wetech.admin.modules.system.mapper;

import org.apache.ibatis.annotations.Select;
import tech.wetech.admin.core.utils.MyMapper;
import tech.wetech.admin.modules.system.po.QuYu;

import java.util.List;

public interface QuYuMapper extends MyMapper<QuYu> {
    @Select(value = "select distinct(city) from xzqyinfo")
    List<QuYu> selectAllCity();

    @Select(value = "select distinct(province) from xzqyinfo")

    List<QuYu> selectAllProvince();
    @Select(value = "select distinct(qu) from xzqyinfo")
    List<QuYu> selectAllQu();
}