package tech.wetech.admin.modules.system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import tech.wetech.admin.modules.system.po.FixedArea;

@Data
public class FixedAreaDto {
    private Integer id;
    private String fixedareano;
    private String fixedareaname;
    private String fixedareamanager;
    private String phone;
    private String institute;
    public FixedAreaDto(FixedArea fixedArea){
        this.id=fixedArea.getId();
        this.fixedareaname=fixedArea.getFixedareaname();
        this.fixedareano=fixedArea.getFixedareano();
        this.fixedareamanager=fixedArea.getFixedareamanager();
        this.phone=fixedArea.getPhone();
        this.institute=fixedArea.getInstitute();
    }
}
