package tech.wetech.admin.modules.system.query;

import lombok.Data;
import tech.wetech.admin.core.utils.BaseQuery;
import tech.wetech.admin.modules.system.po.Replay;

@Data
public class ReplayQuery extends BaseQuery<Replay> {
    private String replayid;

    private String name;

    private String replayofid;

    private String nameof;
}
