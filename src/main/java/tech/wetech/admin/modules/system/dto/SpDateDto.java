package tech.wetech.admin.modules.system.dto;

import lombok.Data;
import tech.wetech.admin.modules.system.po.SpDate;
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
        this.dateName = spDate.getDatename();
        this.pacificUp = spDate.getPacificup();
        this.pacificOff = spDate.getPacificoff();
        this.satUp = spDate.getSatup();
        this.satOff = spDate.getSatoff();
        this.sunUp = spDate.getSunup();
        this.sunOff = spDate.getSunoff();
    }
}