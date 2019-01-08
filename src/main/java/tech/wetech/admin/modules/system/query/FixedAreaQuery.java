package tech.wetech.admin.modules.system.query;

import lombok.Getter;
import lombok.Setter;
import tech.wetech.admin.core.utils.BaseQuery;
import tech.wetech.admin.modules.system.po.FixedArea;

@Getter
@Setter
public class FixedAreaQuery extends BaseQuery<FixedArea> {
    private String fixedareaname;
    private String fixedareamanager;
}
