package tech.wetech.admin.modules.system.query;

import lombok.Getter;
import lombok.Setter;
import tech.wetech.admin.core.utils.BaseQuery;
import tech.wetech.admin.modules.system.po.Staff;

@Setter
@Getter
public class StaffQuery extends BaseQuery<Staff> {

    private String staid;

    private String name;

    private String station;

    private String deltag;

}
