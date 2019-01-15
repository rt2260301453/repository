package tech.wetech.admin.modules.system.query;

import lombok.Data;
import tech.wetech.admin.core.utils.BaseQuery;
import tech.wetech.admin.modules.system.po.Subarea;

@Data
public class SubareaQuery extends BaseQuery<Subarea> {

    private String id;
    private String pro;
    private String city;
    private String county;
    private String keyword;
    private String auxiliarykeywords;


}
