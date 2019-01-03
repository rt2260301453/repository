package tech.wetech.admin.modules.system.dto;


import lombok.Data;

@Data
public class StaffDto<getter> {
    private Integer id;
    private String staid;
    private String name;
    private String telephone;
    private String haspad;
    private String deltag;
    private String station;
    private Integer shuttleid;
    private Integer standardid;
    private Integer basisid;



}
