package tech.wetech.admin.modules.system.po;

import javax.persistence.*;

@Table(name = "staff")
public class Staff {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 员工编号
     */
    private String staid;

    /**
     * 员工名称
     */
    private String name;

    /**
     * 电话
     */
    private String telephone;

    /**
     * 移动设备
     */
    private String haspad;

    private String deltag;

    /**
     * 单位
     */
    private String station;

    /**
     * 班车id
     */
    private Integer shuttleid;

    /**
     * 收取标准id
     */
    private Integer standardid;

    private Integer basisid;

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
     * 获取员工编号
     *
     * @return staid - 员工编号
     */
    public String getStaid() {
        return staid;
    }

    /**
     * 设置员工编号
     *
     * @param staid 员工编号
     */
    public void setStaid(String staid) {
        this.staid = staid;
    }

    /**
     * 获取员工名称
     *
     * @return name - 员工名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置员工名称
     *
     * @param name 员工名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取电话
     *
     * @return telephone - 电话
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置电话
     *
     * @param telephone 电话
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 获取移动设备
     *
     * @return haspad - 移动设备
     */
    public String getHaspad() {
        return haspad;
    }

    /**
     * 设置移动设备
     *
     * @param haspad 移动设备
     */
    public void setHaspad(String haspad) {
        this.haspad = haspad;
    }

    /**
     * @return deltag
     */
    public String getDeltag() {
        return deltag;
    }

    /**
     * @param deltag
     */
    public void setDeltag(String deltag) {
        this.deltag = deltag;
    }

    /**
     * 获取单位
     *
     * @return station - 单位
     */
    public String getStation() {
        return station;
    }

    /**
     * 设置单位
     *
     * @param station 单位
     */
    public void setStation(String station) {
        this.station = station;
    }

    /**
     * 获取班车id
     *
     * @return shuttleid - 班车id
     */
    public Integer getShuttleid() {
        return shuttleid;
    }

    /**
     * 设置班车id
     *
     * @param shuttleid 班车id
     */
    public void setShuttleid(Integer shuttleid) {
        this.shuttleid = shuttleid;
    }

    /**
     * 获取收取标准id
     *
     * @return standardid - 收取标准id
     */
    public Integer getStandardid() {
        return standardid;
    }

    /**
     * 设置收取标准id
     *
     * @param standardid 收取标准id
     */
    public void setStandardid(Integer standardid) {
        this.standardid = standardid;
    }

    /**
     * @return basisid
     */
    public Integer getBasisid() {
        return basisid;
    }

    /**
     * @param basisid
     */
    public void setBasisid(Integer basisid) {
        this.basisid = basisid;
    }
}