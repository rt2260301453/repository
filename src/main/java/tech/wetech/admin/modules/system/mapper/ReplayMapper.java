package tech.wetech.admin.modules.system.mapper;

import org.apache.ibatis.annotations.Select;
import tech.wetech.admin.core.utils.MyMapper;
import tech.wetech.admin.modules.system.po.Replay;

public interface ReplayMapper extends MyMapper<Replay> {
    @Select("select count(1) from replay t where t.starttime>#{starttime} or t.endtime<#{starttime} and t.replayid=#{replayid}")
    int checktimeBypid(Replay replay);
}