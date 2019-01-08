package tech.wetech.admin.modules.system.query;

import lombok.Data;
import tech.wetech.admin.core.utils.BaseQuery;
import tech.wetech.admin.modules.system.po.AssociatedWidgets;

@Data
public class AssociatedWidgetsQuery extends BaseQuery<AssociatedWidgets> {
    private String fixedareano;
    private String fetchpeoplename;
}