package tech.wetech.admin.modules.system.po;

import lombok.Data;

import javax.persistence.*;
@Data
@Table(name = "staff")
public class Staff {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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
    private String shuttleid;

    /**
     * 收取标准id
     */
    private String standardid;

    private String basisid;




}