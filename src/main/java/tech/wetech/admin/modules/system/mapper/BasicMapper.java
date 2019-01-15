package tech.wetech.admin.modules.system.mapper;

import org.apache.ibatis.annotations.Select;
import tech.wetech.admin.core.utils.MyMapper;
import tech.wetech.admin.modules.system.po.Basic;

public interface BasicMapper extends MyMapper<Basic> {

    @Select(value = "select count(1) from basic where basicno=#{basicno}")
    int selectByNo(Basic basic);

    @Select(value = "select count(1) from basic where basicname=#{basicname}")
    int selectByName(Basic basic);

    @Select(value = "select classifying from basic where basicno=#{basicno}")
    int selectByClass(Basic basic);

}