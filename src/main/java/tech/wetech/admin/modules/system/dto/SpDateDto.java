package tech.wetech.admin.modules.system.dto;

import lombok.Data;
import tech.wetech.admin.modules.system.po.SpDate;

import javax.persistence.*;
import java.util.Date;
@Data
public class SpDateDto {
    private String dateName;
    private Date pacificUp;
    private Date pacificOff;
    private Date satUp;
    private Date satOff;
    private Date sunUp;
    private Date sunOff;
    public SpDateDto(SpDate spDate){
        this.dateName = spDate.getDateName();
        this.pacificUp = spDate.getPacificUp();
        this.pacificOff = spDate.getPacificOff();
        this.satUp = spDate.getSatUp();
        this.satOff = spDate.getSatOff();
        this.sunUp = spDate.getSunUp();
        this.sunOff = spDate.getSunOff();
    }
}