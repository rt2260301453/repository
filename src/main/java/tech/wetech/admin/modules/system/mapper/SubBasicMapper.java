package tech.wetech.admin.modules.system.mapper;

import org.apache.ibatis.annotations.Select;
import tech.wetech.admin.core.utils.MyMapper;
import tech.wetech.admin.modules.system.po.SubBasic;

public interface SubBasicMapper extends MyMapper<SubBasic> {

    @Select(value = "select count(1) from subbasic where subbasicno=#{subbasicno}")
    int selectByNo(SubBasic subbasic);

    @Select(value = "select subbasicname from subbasic where subbasicno=#{subbasicno}")
    SubBasic selectByName1(SubBasic subbasic);

    @Select(value = "select count(1) from subbasic where subbasicname=#{subbasicname}")
    int selectByName(SubBasic subbasic);
}