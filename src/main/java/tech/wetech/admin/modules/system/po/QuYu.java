package tech.wetech.admin.modules.system.po;

import lombok.*;

import javax.persistence.*;

@Table(name = "xzqyinfo")
@Data
@Setter

@Generated
@Getter
public class QuYu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public QuYu() {
    }

    public QuYu(Integer id, String province, String city, String qu, String yzbm, String jm, String csbm, String cgdw, String jgdw, String kfwqy, String bkfwqy, String tsqy, Boolean sfkcz, Boolean sfkczcod, Boolean sfww, Boolean sfjqx, String xz, String ssqy, Integer pycsjb, String sjzxjgczfwq, String kouan) {
       this.id=id;
        this.province = province;
        this.city = city;
        this.qu = qu;
        this.yzbm = yzbm;
        this.jm = jm;
        this.csbm = csbm;
        this.cgdw = cgdw;
        this.jgdw = jgdw;
        this.kfwqy = kfwqy;
        this.bkfwqy = bkfwqy;
        this.tsqy = tsqy;
        this.sfkcz = sfkcz;
        this.sfkczcod = sfkczcod;
        this.sfww = sfww;
        this.sfjqx = sfjqx;
        this.xz = xz;
        this.ssqy = ssqy;
        this.pycsjb = pycsjb;
        this.sjzxjgczfwq = sjzxjgczfwq;
        this.kouan = kouan;
    }

    public QuYu(String province, String city, String qu, String yzbm, String jm, String csbm, String cgdw, String jgdw) {
        this.province = province;
        this.city = city;
        this.qu = qu;
        this.yzbm = yzbm;
        this.jm = jm;
        this.csbm = csbm;
        this.cgdw = cgdw;
        this.jgdw = jgdw;
    }

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
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return qu
     */
    public String getQu() {
        return qu;
    }

    /**
     * @param qu
     */
    public void setQu(String qu) {
        this.qu = qu;
    }

    /**
     * @return yzbm
     */
    public String getYzbm() {
        return yzbm;
    }

    /**
     * @param yzbm
     */
    public void setYzbm(String yzbm) {
        this.yzbm = yzbm;
    }

    /**
     * @return jm
     */
    public String getJm() {
        return jm;
    }

    /**
     * @param jm
     */
    public void setJm(String jm) {
        this.jm = jm;
    }

    /**
     * @return csbm
     */
    public String getCsbm() {
        return csbm;
    }

    /**
     * @param csbm
     */
    public void setCsbm(String csbm) {
        this.csbm = csbm;
    }

    /**
     * @return cgdw
     */
    public String getCgdw() {
        return cgdw;
    }

    /**
     * @param cgdw
     */
    public void setCgdw(String cgdw) {
        this.cgdw = cgdw;
    }

    /**
     * @return jgdw
     */
    public String getJgdw() {
        return jgdw;
    }

    /**
     * @param jgdw
     */
    public void setJgdw(String jgdw) {
        this.jgdw = jgdw;
    }

    /**
     * @return kfwqy
     */
    public String getKfwqy() {
        return kfwqy;
    }

    /**
     * @param kfwqy
     */
    public void setKfwqy(String kfwqy) {
        this.kfwqy = kfwqy;
    }

    /**
     * @return bkfwqy
     */
    public String getBkfwqy() {
        return bkfwqy;
    }

    /**
     * @param bkfwqy
     */
    public void setBkfwqy(String bkfwqy) {
        this.bkfwqy = bkfwqy;
    }

    /**
     * @return tsqy
     */
    public String getTsqy() {
        return tsqy;
    }

    /**
     * @param tsqy
     */
    public void setTsqy(String tsqy) {
        this.tsqy = tsqy;
    }

    /**
     * @return sfkcz
     */
    public Boolean getSfkcz() {
        return sfkcz;
    }

    /**
     * @param sfkcz
     */
    public void setSfkcz(Boolean sfkcz) {
        this.sfkcz = sfkcz;
    }

    /**
     * @return sfkczCOD
     */
    public Boolean getSfkczcod() {
        return sfkczcod;
    }

    /**
     * @param sfkczcod
     */
    public void setSfkczcod(Boolean sfkczcod) {
        this.sfkczcod = sfkczcod;
    }

    /**
     * @return sfww
     */
    public Boolean getSfww() {
        return sfww;
    }

    /**
     * @param sfww
     */
    public void setSfww(Boolean sfww) {
        this.sfww = sfww;
    }

    /**
     * @return sfjqx
     */
    public Boolean getSfjqx() {
        return sfjqx;
    }

    /**
     * @param sfjqx
     */
    public void setSfjqx(Boolean sfjqx) {
        this.sfjqx = sfjqx;
    }

    /**
     * @return xz
     */
    public String getXz() {
        return xz;
    }

    /**
     * @param xz
     */
    public void setXz(String xz) {
        this.xz = xz;
    }

    /**
     * @return ssqy
     */
    public String getSsqy() {
        return ssqy;
    }

    /**
     * @param ssqy
     */
    public void setSsqy(String ssqy) {
        this.ssqy = ssqy;
    }

    /**
     * @return pycsjb
     */
    public Integer getPycsjb() {
        return pycsjb;
    }

    /**
     * @param pycsjb
     */
    public void setPycsjb(Integer pycsjb) {
        this.pycsjb = pycsjb;
    }

    /**
     * @return sjzxjgczfwq
     */
    public String getSjzxjgczfwq() {
        return sjzxjgczfwq;
    }


    /**
     * @param sjzxjgczfwq
     */
    public void setSjzxjgczfwq(String sjzxjgczfwq) {
        this.sjzxjgczfwq = sjzxjgczfwq;
    }

    /**
     * @return kouan
     */
    public String getKouan() {
        return kouan;
    }

    /**
     * @param kouan
     */
    public void setKouan(String kouan) {
        this.kouan = kouan;
    }
}