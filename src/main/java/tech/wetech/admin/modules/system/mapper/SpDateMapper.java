package tech.wetech.admin.modules.system.mapper;

import org.apache.ibatis.annotations.Select;
import tech.wetech.admin.core.utils.MyMapper;
import tech.wetech.admin.modules.system.po.SpDate;

public interface SpDateMapper extends MyMapper<SpDate> {
    @Select(value = "select count(1) from spdate where date_name=#{datename}")
    int selectByName(SpDate spDate);
}