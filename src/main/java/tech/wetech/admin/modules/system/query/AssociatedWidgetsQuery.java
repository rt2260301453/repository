package tech.wetech.admin.modules.system.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import tech.wetech.admin.core.utils.BaseQuery;
import tech.wetech.admin.modules.system.po.AssociatedWidgets;

import java.util.Date;

@Data
public class AssociatedWidgetsQuery extends BaseQuery<AssociatedWidgets> {
    private String fetchpeoplename;
    private String collectiontime;
}