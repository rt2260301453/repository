package tech.wetech.admin.modules.system.service;

import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.modules.system.dto.ReplayDto;
import tech.wetech.admin.modules.system.po.Replay;
import tech.wetech.admin.modules.system.po.Staff;
import tech.wetech.admin.modules.system.query.ReplayQuery;

public interface ReplayService {

    PageResultSet<ReplayDto> findByPage(ReplayQuery replayQuery);

    void createStaff(Replay replay);

    void updatestaff(Replay replay);

    Staff queryAllForFormSelect(String replayid);

//    String queryAllForForminput(String replayid);

    void deletereplay(Long id);

    int checktime(Replay replay);
}
