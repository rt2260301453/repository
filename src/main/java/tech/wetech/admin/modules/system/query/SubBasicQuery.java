package tech.wetech.admin.modules.system.query;

import lombok.Data;
import tech.wetech.admin.core.utils.BaseQuery;
import tech.wetech.admin.modules.system.po.SubBasic;

/**
 * @author cjbi
 */
@Data
public class SubBasicQuery extends BaseQuery<SubBasic> {
    /**
     * 基本档案编号
     */
    private String subbasicno;



}
