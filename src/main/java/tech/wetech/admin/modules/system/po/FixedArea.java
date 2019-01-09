package tech.wetech.admin.modules.system.po;

import javax.persistence.*;
@Table(name="fixedarea")
public class FixedArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 定区编码
     */
    private String fixedareano;

    /**
     * 定区名称
     */
    private String fixedareaname;

    /**
     * 定区负责人
     */
    private String fixedareamanager;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 所属单位
     */
    private String institute;

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
     * 获取定区编码
     *
     * @return fixedareano - 定区编码
     */
    public String getFixedareano() {
        return fixedareano;
    }

    /**
     * 设置定区编码
     *
     * @param fixedareano 定区编码
     */
    public void setFixedareano(String fixedareano) {
        this.fixedareano = fixedareano;
    }

    /**
     * 获取定区名称
     *
     * @return fixedareaname - 定区名称
     */
    public String getFixedareaname() {
        return fixedareaname;
    }

    /**
     * 设置定区名称
     *
     * @param fixedareaname 定区名称
     */
    public void setFixedareaname(String fixedareaname) {
        this.fixedareaname = fixedareaname;
    }

    /**
     * 获取定区负责人
     *
     * @return fixedareamanager - 定区负责人
     */
    public String getFixedareamanager() {
        return fixedareamanager;
    }

    /**
     * 设置定区负责人
     *
     * @param fixedareamanager 定区负责人
     */
    public void setFixedareamanager(String fixedareamanager) {
        this.fixedareamanager = fixedareamanager;
    }

    /**
     * 获取联系电话
     *
     * @return phone - 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系电话
     *
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取所属单位
     *
     * @return institute - 所属单位
     */
    public String getInstitute() {
        return institute;
    }

    /**
     * 设置所属单位
     *
     * @param institute 所属单位
     */
    public void setInstitute(String institute) {
        this.institute = institute;
    }
}