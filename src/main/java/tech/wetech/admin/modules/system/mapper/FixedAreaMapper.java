package tech.wetech.admin.modules.system.mapper;

import org.apache.ibatis.annotations.Select;
import tech.wetech.admin.core.utils.MyMapper;
import tech.wetech.admin.modules.system.po.FixedArea;

public interface FixedAreaMapper extends MyMapper<FixedArea> {
    @Select(value = "select count(1) from fixedarea where fixedareano=#{fixedareano}")
    int selectByNo(FixedArea fixedArea);
}