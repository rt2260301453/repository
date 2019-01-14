package tech.wetech.admin.modules.system.po;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Table(name="spdate")
public class SpDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "时间名称不能为空")
    @Column(name = "date_name")
    private String datename;
    @Column(name = "pacific_up")
    @NotNull(message = "时间不能为空")
    @DateTimeFormat(pattern = "HH:mm")
    @JsonFormat(pattern = "HH:mm", timezone = "GMT+08:00")
    private Date pacificup;
    @Column(name = "pacific_off")
    @NotNull(message = "时间不能为空")
    @DateTimeFormat(pattern = "HH:mm")
    @JsonFormat(pattern = "HH:mm", timezone = "GMT+08:00")
    @NotNull(message = "时间不能为空")
    private Date pacificoff;
    @Column(name = "sat_up")
    @DateTimeFormat(pattern = "HH:mm")
    @JsonFormat(pattern = "HH:mm", timezone = "GMT+08:00")
    @NotNull(message = "时间不能为空")
    private Date satup;
    @Column(name = "sat_off")
    @DateTimeFormat(pattern = "HH:mm")
    @JsonFormat(pattern = "HH:mm", timezone = "GMT+08:00")
    @NotNull(message = "时间不能为空")
    private Date satoff;
    @Column(name = "sun_up")
    @DateTimeFormat(pattern = "HH:mm")
    @JsonFormat(pattern = "HH:mm", timezone = "GMT+08:00")
    @NotNull(message = "时间不能为空")
    private Date sunup;
    @Column(name = "sun_off")
    @DateTimeFormat(pattern = "HH:mm")
    @JsonFormat(pattern = "HH:mm", timezone = "GMT+08:00")
    @NotNull(message = "时间不能为空")
    private Date sunoff;

    private String state;

    private String unit;

    @Column(name = "update_id")
    private String updateid;

    @Column(name = "update_name")
    private String updatename;

    @Column(name = "update_unit")
    private String updateunit;
    @Column(name = "update_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+08:00")
    private Date updatedate;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return datename
     */
    public String getDatename() {
        return datename;
    }

    /**
     * @param datename
     */
    public void setDatename(String datename) {
        this.datename = datename;
    }

    /**
     * @return pacificup
     */
    public Date getPacificup() {
        return pacificup;
    }

    /**
     * @param pacificup
     */
    public void setPacificup(Date pacificup) {
        this.pacificup = pacificup;
    }

    /**
     * @return pacificoff
     */
    public Date getPacificoff() {
        return pacificoff;
    }

    /**
     * @param pacificoff
     */
    public void setPacificoff(Date pacificoff) {
        this.pacificoff = pacificoff;
    }

    /**
     * @return satup
     */
    public Date getSatup() {
        return satup;
    }

    /**
     * @param satup
     */
    public void setSatup(Date satup) {
        this.satup = satup;
    }

    /**
     * @return satoff
     */
    public Date getSatoff() {
        return satoff;
    }

    /**
     * @param satoff
     */
    public void setSatoff(Date satoff) {
        this.satoff = satoff;
    }

    /**
     * @return sunup
     */
    public Date getSunup() {
        return sunup;
    }

    /**
     * @param sunup
     */
    public void setSunup(Date sunup) {
        this.sunup = sunup;
    }

    /**
     * @return sunoff
     */
    public Date getSunoff() {
        return sunoff;
    }

    /**
     * @param sunoff
     */
    public void setSunoff(Date sunoff) {
        this.sunoff = sunoff;
    }

    /**
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * @return updateid
     */
    public String getUpdateid() {
        return updateid;
    }

    /**
     * @param updateid
     */
    public void setUpdateid(String updateid) {
        this.updateid = updateid;
    }

    /**
     * @return updatename
     */
    public String getUpdatename() {
        return updatename;
    }

    /**
     * @param updatename
     */
    public void setUpdatename(String updatename) {
        this.updatename = updatename;
    }

    /**
     * @return updateunit
     */
    public String getUpdateunit() {
        return updateunit;
    }

    /**
     * @param updateunit
     */
    public void setUpdateunit(String updateunit) {
        this.updateunit = updateunit;
    }

    /**
     * @return updatedate
     */
    public Date getUpdatedate() {
        return updatedate;
    }

    /**
     * @param updatedate
     */
    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }
}