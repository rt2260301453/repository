package tech.wetech.admin.modules.system.mapper;

import org.apache.ibatis.annotations.Select;
import tech.wetech.admin.core.utils.MyMapper;
import tech.wetech.admin.modules.system.po.SpDate;

public interface SpDateMapper extends MyMapper<SpDate> {

    @Select(value = "select count(1) from spdate where datename=#{datename}")
    int selectByName(SpDate datename);
}