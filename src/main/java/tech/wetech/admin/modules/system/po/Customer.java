package tech.wetech.admin.modules.system.po;

import javax.persistence.*;
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 客户编号
     */
    private String customerno;

    /**
     * 客户姓名
     */
    private String customername;

    /**
     * 客户密码
     */
    private String pwd;

    /**
     * 客户地址
     */
    private String customeraddress;

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
     * 获取客户编号
     *
     * @return customerno - 客户编号
     */
    public String getCustomerno() {
        return customerno;
    }

    /**
     * 设置客户编号
     *
     * @param customerno 客户编号
     */
    public void setCustomerno(String customerno) {
        this.customerno = customerno;
    }

    /**
     * 获取客户姓名
     *
     * @return customername - 客户姓名
     */
    public String getCustomername() {
        return customername;
    }

    /**
     * 设置客户姓名
     *
     * @param customername 客户姓名
     */
    public void setCustomername(String customername) {
        this.customername = customername;
    }

    /**
     * 获取客户密码
     *
     * @return pwd - 客户密码
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 设置客户密码
     *
     * @param pwd 客户密码
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * 获取客户地址
     *
     * @return customeraddress - 客户地址
     */
    public String getCustomeraddress() {
        return customeraddress;
    }

    /**
     * 设置客户地址
     *
     * @param customeraddress 客户地址
     */
    public void setCustomeraddress(String customeraddress) {
        this.customeraddress = customeraddress;
    }
}