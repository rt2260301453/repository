package tech.wetech.admin.modules.system.query;

import lombok.Data;
import tech.wetech.admin.core.utils.BaseQuery;
import tech.wetech.admin.modules.system.po.Basic;

/**
 * @author cjbi
 */
@Data
public class BasicQuery extends BaseQuery<Basic> {
    /**
     * 基本档案编号
     */
    private String basicno;

    private Boolean locked;
}
