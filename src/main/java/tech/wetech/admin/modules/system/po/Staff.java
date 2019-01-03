package tech.wetech.admin.modules.system.po;

import javax.persistence.*;

@Table(name = "staff")
public class Staff {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Ա�����
     */
    private String staid;

    /**
     * Ա������
     */
    private String name;

    /**
     * �绰
     */
    private String telephone;

    /**
     * �ƶ��豸
     */
    private String haspad;

    private String deltag;

    /**
     * ��λ
     */
    private String station;

    /**
     * �೵id
     */
    private Integer shuttleid;

    /**
     * ��ȡ��׼id
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
     * ��ȡԱ�����
     *
     * @return staid - Ա�����
     */
    public String getStaid() {
        return staid;
    }

    /**
     * ����Ա�����
     *
     * @param staid Ա�����
     */
    public void setStaid(String staid) {
        this.staid = staid;
    }

    /**
     * ��ȡԱ������
     *
     * @return name - Ա������
     */
    public String getName() {
        return name;
    }

    /**
     * ����Ա������
     *
     * @param name Ա������
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ��ȡ�绰
     *
     * @return telephone - �绰
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * ���õ绰
     *
     * @param telephone �绰
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * ��ȡ�ƶ��豸
     *
     * @return haspad - �ƶ��豸
     */
    public String getHaspad() {
        return haspad;
    }

    /**
     * �����ƶ��豸
     *
     * @param haspad �ƶ��豸
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
     * ��ȡ��λ
     *
     * @return station - ��λ
     */
    public String getStation() {
        return station;
    }

    /**
     * ���õ�λ
     *
     * @param station ��λ
     */
    public void setStation(String station) {
        this.station = station;
    }

    /**
     * ��ȡ�೵id
     *
     * @return shuttleid - �೵id
     */
    public Integer getShuttleid() {
        return shuttleid;
    }

    /**
     * ���ð೵id
     *
     * @param shuttleid �೵id
     */
    public void setShuttleid(Integer shuttleid) {
        this.shuttleid = shuttleid;
    }

    /**
     * ��ȡ��ȡ��׼id
     *
     * @return standardid - ��ȡ��׼id
     */
    public Integer getStandardid() {
        return standardid;
    }

    /**
     * ������ȡ��׼id
     *
     * @param standardid ��ȡ��׼id
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