package tech.wetech.admin.modules.system.dto;

import lombok.Data;
import tech.wetech.admin.modules.system.po.Replay;

import java.util.Date;
@Data
public class ReplayDto {
    private long id;

    private String replayid;

    private String name;

    private Date starttime;

    private Date endtime;

    private String station;

    private String deltag;

    private String upusername;

    private String uptime;

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


    }
}
