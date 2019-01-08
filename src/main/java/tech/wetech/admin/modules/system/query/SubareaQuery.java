package tech.wetech.admin.modules.system.query;

import lombok.Data;
import tech.wetech.admin.core.utils.BaseQuery;
import tech.wetech.admin.modules.system.po.Subarea;

@Data
public class SubareaQuery extends BaseQuery<Subarea> {

    private String id;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

}
