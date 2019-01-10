package tech.wetech.admin.modules.system.query;

import lombok.Data;
import tech.wetech.admin.core.utils.BaseQuery;
import tech.wetech.admin.modules.system.po.AssociatedAddress;
@Data
public class AssociatedAddressQuery extends BaseQuery<AssociatedAddress> {
    private String cityname;
}