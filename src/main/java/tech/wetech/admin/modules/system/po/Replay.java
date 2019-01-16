package tech.wetech.admin.modules.system.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.util.Date;
@Data
@Table(name = "replay")
public class Replay {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String replayid;

    private String name;

    @Future(message= "开始时间必须是一个将来时间!")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+08:00")
    private Date starttime;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
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
}