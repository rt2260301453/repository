package tech.wetech.admin.modules.system.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import tech.wetech.admin.modules.system.po.SpDate;
import java.util.Date;
@Data
public class SpDateDto {
    private String dateName;
    @DateTimeFormat(pattern = "HH:mm")
    @JsonFormat(pattern = "HH:mm", timezone = "GMT+08:00")
    private Date pacificUp;
    @DateTimeFormat(pattern = "HH:mm")
    @JsonFormat(pattern = "HH:mm", timezone = "GMT+08:00")
    private Date pacificOff;
    @DateTimeFormat(pattern = "HH:mm")
    @JsonFormat(pattern = "HH:mm", timezone = "GMT+08:00")
    private Date satUp;
    @DateTimeFormat(pattern = "HH:mm")
    @JsonFormat(pattern = "HH:mm", timezone = "GMT+08:00")
    private Date satOff;
    @DateTimeFormat(pattern = "HH:mm")
    @JsonFormat(pattern = "HH:mm", timezone = "GMT+08:00")
    private Date sunUp;
    @DateTimeFormat(pattern = "HH:mm")
    @JsonFormat(pattern = "HH:mm", timezone = "GMT+08:00")
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