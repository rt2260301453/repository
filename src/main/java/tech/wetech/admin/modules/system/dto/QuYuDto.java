package tech.wetech.admin.modules.system.dto;

import lombok.*;
import tech.wetech.admin.modules.system.po.QuYu;

import javax.persistence.Column;

@Data
@Setter

@Generated
@Getter
public class QuYuDto {
    private Integer id;

    private String province;

    private String city;

    private String qu;

    private String yzbm;

    private String jm;

    private String csbm;

    private String cgdw;

    private String jgdw;
    private String kfwqy;

    private String bkfwqy;

    private String tsqy;

    private Boolean sfkcz;

    @Column(name = "sfkczCOD")
    private Boolean sfkczcod;

    private Boolean sfww;

    private Boolean sfjqx;

    private String xz;

    private String ssqy;

    private Integer pycsjb;

    private String sjzxjgczfwq;

    private String kouan;



    public QuYuDto(QuYu u) {
        this.id=u.getId();
        this.province = u.getProvince();
        this.city = u.getCity();
        this.qu = u.getQu();
        this.yzbm = u.getYzbm();
        this.jm =   u.getJm();
        this.csbm = u.getCsbm();
        this.cgdw = u.getCgdw();
        this.jgdw = u.getJgdw();
        this.kfwqy = u.getKfwqy();
        this.bkfwqy = u.getBkfwqy();
        this.tsqy = u.getTsqy();
        this.sfkcz = u.getSfkcz();
        this.sfkczcod = u.getSfkczcod();
        this.sfww = u.getSfww();
        this.sfjqx = u.getSfjqx();
        this.xz = u.getXz();
        this.ssqy = u.getSsqy();
        this.pycsjb = u.getPycsjb();
        this.sjzxjgczfwq = u.getSjzxjgczfwq();
        this.kouan = u.getKouan();
    }


}
