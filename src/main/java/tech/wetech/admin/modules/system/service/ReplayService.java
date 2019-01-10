package tech.wetech.admin.modules.system.service;

import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.modules.system.dto.ReplayDto;
import tech.wetech.admin.modules.system.query.ReplayQuery;

public interface ReplayService {

    PageResultSet<ReplayDto> findByPage(ReplayQuery staffQuery);
}
