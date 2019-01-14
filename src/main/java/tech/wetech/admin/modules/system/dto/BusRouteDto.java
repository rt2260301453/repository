package tech.wetech.admin.modules.system.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import tech.wetech.admin.modules.system.po.Busroute;

import javax.validation.constraints.NotBlank;
import java.util.Date;
public class BusRouteDto {
    private Integer busid;

    private Integer routeid;

    private String license;

    private String operators;

    private String model;

    private String driver;

    private Long phone;

    private Integer weight;

    private String style;

    private String namefrom;

    private String nameto;

    private String operator;

    private String company;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date date;

    private String remark;

    public BusRouteDto(Busroute u) {
    }

    @Override
    public String toString() {
        return "BusRouteDto{" +
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

    public BusRouteDto() {
    }

    public BusRouteDto(Integer busid, Integer routeid, String license, String operators, String model, String driver, Long phone, Integer weight, String style, String namefrom, String nameto, String operator, String company, Date date, String remark) {
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

    public Integer getBusid() {
        return busid;
    }

    public void setBusid(Integer busid) {
        this.busid = busid;
    }

    public Integer getRouteid() {
        return routeid;
    }

    public void setRouteid(Integer routeid) {
        this.routeid = routeid;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getOperators() {
        return operators;
    }

    public void setOperators(String operators) {
        this.operators = operators;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getNamefrom() {
        return namefrom;
    }

    public void setNamefrom(String namefrom) {
        this.namefrom = namefrom;
    }

    public String getNameto() {
        return nameto;
    }

    public void setNameto(String nameto) {
        this.nameto = nameto;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
