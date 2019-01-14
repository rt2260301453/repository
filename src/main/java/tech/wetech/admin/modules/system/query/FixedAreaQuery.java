package tech.wetech.admin.modules.system.query;

<<<<<<< HEAD
=======
import lombok.Data;
>>>>>>> dev
import lombok.Getter;
import lombok.Setter;
import tech.wetech.admin.core.utils.BaseQuery;
import tech.wetech.admin.modules.system.po.FixedArea;
<<<<<<< HEAD

=======
@Data
>>>>>>> dev
@Getter
@Setter
public class FixedAreaQuery extends BaseQuery<FixedArea> {
    private String fixedareaname;
    private String fixedareamanager;
<<<<<<< HEAD
=======

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
>>>>>>> dev
}
