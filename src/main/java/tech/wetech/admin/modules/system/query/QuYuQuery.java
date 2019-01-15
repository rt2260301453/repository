package tech.wetech.admin.modules.system.query;

import lombok.*;
import tech.wetech.admin.core.utils.BaseQuery;
import tech.wetech.admin.modules.system.po.QuYu;

@Data
public class QuYuQuery extends BaseQuery<QuYu> {
    private String province;

    private String city;

    private String qu;


}
