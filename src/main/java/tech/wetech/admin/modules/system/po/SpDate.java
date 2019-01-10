package tech.wetech.admin.modules.system.po;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Table(name="spdate")
public class SpDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_name")
    private String dateName;

    @Column(name = "pacific_up")
    private Date pacificUp;

    @Column(name = "pacific_off")
    private Date pacificOff;

    @Column(name = "sat_up")
    private Date satUp;

    @Column(name = "sat_off")
    private Date satOff;

    @Column(name = "sun_up")
    private Date sunUp;

    @Column(name = "sun_off")
    private Date sunOff;

    private String state;

    private String unit;

    @Column(name = "update_id")
    private String updateId;

    @Column(name = "update_name")
    private String updateName;

    @Column(name = "update_unit")
    private String updateUnit;

    @Column(name = "update_date")
    private Date updateDate;
}