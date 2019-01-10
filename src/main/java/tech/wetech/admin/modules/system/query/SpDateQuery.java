package tech.wetech.admin.modules.system.query;

import lombok.Data;
import tech.wetech.admin.core.utils.BaseQuery;
import tech.wetech.admin.modules.system.po.SpDate;

@Data
public class SpDateQuery extends BaseQuery<SpDate> {
    private String dateName;
}