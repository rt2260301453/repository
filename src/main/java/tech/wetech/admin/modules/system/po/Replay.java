package tech.wetech.admin.modules.system.po;

import lombok.Data;

import javax.persistence.*;
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

    private Date starttime;

    private Date endtime;

    private String station;

    private String deltag;

    private String upusername;

    private String uptime;


}