package tech.wetech.admin.modules.system.po;

import javax.persistence.*;
@Table(name="associatedaddress")
public class AssociatedAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 定区编号
     */
    private String fixedareano;

    /**
     * 城市名
     */
    private String cityname;

    /**
     * 客户地址
     */
    private String customerno;

    /**
     * 分区编号
     */
    private String partitionno;

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
     * 获取定区编号
     *
     * @return fixedareano - 定区编号
     */
    public String getFixedareano() {
        return fixedareano;
    }

    /**
     * 设置定区编号
     *
     * @param fixedareano 定区编号
     */
    public void setFixedareano(String fixedareano) {
        this.fixedareano = fixedareano;
    }

    /**
     * 获取城市名
     *
     * @return cityname - 城市名
     */
    public String getCityname() {
        return cityname;
    }

    /**
     * 设置城市名
     *
     * @param cityname 城市名
     */
    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    /**
     * 获取客户地址
     *
     * @return customerno - 客户地址
     */
    public String getCustomerno() {
        return customerno;
    }

    /**
     * 设置客户地址
     *
     * @param customerno 客户地址
     */
    public void setCustomerno(String customerno) {
        this.customerno = customerno;
    }

    /**
     * 获取分区编号
     *
     * @return partitionno - 分区编号
     */
    public String getPartitionno() {
        return partitionno;
    }

    /**
     * 设置分区编号
     *
     * @param partitionno 分区编号
     */
    public void setPartitionno(String partitionno) {
        this.partitionno = partitionno;
    }
}