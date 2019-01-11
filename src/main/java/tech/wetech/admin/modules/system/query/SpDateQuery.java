package tech.wetech.admin.modules.system.query;

<<<<<<< HEAD
import lombok.Data;
import tech.wetech.admin.core.utils.BaseQuery;
import tech.wetech.admin.modules.system.po.SpDate;

@Data
public class SpDateQuery extends BaseQuery<SpDate> {
    private String dateName;
}
=======
import tech.wetech.admin.core.utils.BaseQuery;
import tech.wetech.admin.modules.system.po.SpDate;

public class SpDateQuery extends BaseQuery<SpDate> {

    /**
     * 组名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
>>>>>>> 6d33d21b07cf5a9ab55662480a172d6b37992622
