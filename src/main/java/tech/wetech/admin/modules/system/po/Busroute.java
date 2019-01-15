package tech.wetech.admin.modules.system.po;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Table(name = "busroute")
public class Busroute {
    @Id
    private Integer busid;

private int routeid;

    public Busroute() {
    }

    public int getRouteid() {
        return routeid;
    }

    public void setRouteid(int routeid) {
        this.routeid = routeid;
    }

    private String license;

    public Busroute(Integer busid, int routeid, String license, String operators, String model, String driver, @NotBlank(message = "电话不能为空") @Length(min = 11, max = 11, message = "电话必须是11位的数字") Long phone, Integer weight, String style, String namefrom, String nameto, String operator, String company, Date date, String remark) {
        this.busid = busid;
        this.routeid = routeid;
        this.license = license;
        this.operators = operators;
        this.model = model;
        this.driver = driver;
        this.phone = phone;
        this.weight = weight;
        this.style = style;
        this.namefrom = namefrom;
        this.nameto = nameto;
        this.operator = operator;
        this.company = company;
        this.date = date;
        this.remark = remark;
    }

    private String operators;

    private String model;

    private String driver;

    @NotBlank(message = "电话不能为空")
    @Length(min= 11,max=11,message = "电话必须是11位的数字")
    private Long phone;

    private Integer weight;

    private String style;

    private String namefrom;

    private String nameto;

    private String operator;

    private String company;

    private Date date;

    private String remark;

    @Override
    public String toString() {
        return "Busroute{" +
                "busid=" + busid +
                ", routeid=" + routeid +
                ", license='" + license + '\'' +
                ", operators='" + operators + '\'' +
                ", model='" + model + '\'' +
                ", driver='" + driver + '\'' +
                ", phone=" + phone +
                ", weight=" + weight +
                ", style='" + style + '\'' +
                ", namefrom='" + namefrom + '\'' +
                ", nameto='" + nameto + '\'' +
                ", operator='" + operator + '\'' +
                ", company='" + company + '\'' +
                ", date=" + date +
                ", remark='" + remark + '\'' +
                '}';
    }

    /**
     * @return busid
     */
    public Integer getBusid() {
        return busid;
    }

    /**
     * @param busid
     */
    public void setBusid(Integer busid) {
        this.busid = busid;
    }

    /**
     * @return license
     */
    public String getLicense() {
        return license;
    }

    /**
     * @param license
     */
    public void setLicense(String license) {
        this.license = license;
    }

    /**
     * @return operators
     */
    public String getOperators() {
        return operators;
    }

    /**
     * @param operators
     */
    public void setOperators(String operators) {
        this.operators = operators;
    }

    /**
     * @return model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     * @param driver
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * @return phone
     */
    public Long getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(Long phone) {
        this.phone = phone;
    }

    /**
     * @return weight
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * @param weight
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * @return style
     */
    public String getStyle() {
        return style;
    }

    /**
     * @param style
     */
    public void setStyle(String style) {
        this.style = style;
    }

    /**
     * @return namefrom
     */
    public String getNamefrom() {
        return namefrom;
    }

    /**
     * @param namefrom
     */
    public void setNamefrom(String namefrom) {
        this.namefrom = namefrom;
    }

    /**
     * @return nameto
     */
    public String getNameto() {
        return nameto;
    }

    /**
     * @param nameto
     */
    public void setNameto(String nameto) {
        this.nameto = nameto;
    }

    /**
     * @return operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     * @param operator
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * @return company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}