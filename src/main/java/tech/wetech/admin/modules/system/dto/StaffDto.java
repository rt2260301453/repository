package tech.wetech.admin.modules.system.dto;


import lombok.Data;
import tech.wetech.admin.modules.system.po.Staff;

@Data
public class StaffDto<getter> {
    private long id;
    private String staid;
    private String name;
    private String telephone;
    private String haspad;
    private String deltag;
    private String station;
    private String shuttleid;
    private String standardid;
    private String basisid;

    public StaffDto(Staff staff){
        this.id = staff.getId();
        this.staid = staff.getStaid();
        this.name = staff.getName();
        this.telephone = staff.getTelephone();
        this.haspad = staff.getHaspad();
        this.deltag = staff.getDeltag();
        this.station = staff.getStation();
        this.shuttleid = staff.getShuttleid();
        this.standardid = staff.getStandardid();
        this.basisid = staff.getBasisid();

    }

}
