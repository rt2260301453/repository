package tech.wetech.admin.modules.system.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import tech.wetech.admin.modules.system.po.Replay;

import java.util.Date;
@Data
public class ReplayDto {
    private long id;

    private String replayid;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+08:00")
    private Date starttime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+08:00")
    private Date endtime;

    private String station;

    private String deltag;

    private String upusername;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+08:00")
    private Date uptime;

    private String replayofid;

    private String nameof;

    private String stationof;

    public ReplayDto(Replay replay){
        this.id = replay.getId();
        this.replayid = replay.getReplayid();
        this.name = replay.getName();
        this.starttime = replay.getStarttime();
        this.endtime = replay.getEndtime();
        this.station = replay.getStation();
        this .deltag = replay.getDeltag();
        this.upusername = replay.getUpusername();
        this.uptime = replay.getUptime();
        this.replayofid = replay.getReplayofid();
        this.nameof = replay.getNameof();
        this.stationof = replay.getStationof();
    }
}
