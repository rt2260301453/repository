package tech.wetech.admin.modules.system.query;

import lombok.Data;
import tech.wetech.admin.core.utils.BaseQuery;
import tech.wetech.admin.modules.system.po.FixedArea;

@Data
public class FixedAreaQuery extends BaseQuery<FixedArea> {
    private String fixedareaname;
    private String fixedareamanager;

    public String getFixedareaname() {
        return fixedareaname;
    }

    public void setFixedareaname(String fixedareaname) {
        this.fixedareaname = fixedareaname;
    }

    public String getFixedareamanager() {
        return fixedareamanager;
    }

    public void setFixedareamanager(String fixedareamanager) {
        this.fixedareamanager = fixedareamanager;
    }
}
