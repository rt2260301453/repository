package tech.wetech.admin.modules.system.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import tech.wetech.admin.modules.system.po.AssociatedWidgets;

import java.util.Date;
@Data
public class AssociatedWidgetsDto {
    private Integer id;
    private String fixedareano;
    private String fetchpeopleno;
    private String fetchpeoplename;
    private String collectionstandard;
    private String collectiontime;
    private String institute;
    private String type;

    public AssociatedWidgetsDto(AssociatedWidgets associatedWidgets) {
        this.id = associatedWidgets.getId();
        this.fixedareano = associatedWidgets.getFixedareano();
        this.fetchpeopleno = associatedWidgets.getFetchpeopleno();
        this.fetchpeoplename = associatedWidgets.getFetchpeoplename();
        this.collectionstandard = associatedWidgets.getCollectionstandard();
        this.collectiontime = associatedWidgets.getCollectiontime();
        this.institute = associatedWidgets.getInstitute();
        this.type = associatedWidgets.getType();
    }
}