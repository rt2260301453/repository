package tech.wetech.admin.modules.system.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class Bus {
    private Integer busid;

    private Integer routeid;

    private String license;

    private String operators;

    private String model;

    private String driver;

    private Long phone;

    private Integer weight;

    private String operater;

    private String company;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date date;
    private Route route;

    public Bus(Integer busid, Integer routeid, String license, String operators, String model, String driver, Long phone, Integer weight, String operater, String company, Date date, Route route) {
        this.busid = busid;
        this.routeid = routeid;
        this.license = license;
        this.operators = operators;
        this.model = model;
        this.driver = driver;
        this.phone = phone;
        this.weight = weight;
        this.operater = operater;
        this.company = company;
        this.date = date;
        this.route = route;
    }


    public Bus() {
    }

    @Override
    public String toString() {
        return "Bus{" +
                "busid=" + busid +
                ", routeid=" + routeid +
                ", license='" + license + '\'' +
                ", operators='" + operators + '\'' +
                ", model='" + model + '\'' +
                ", driver='" + driver + '\'' +
                ", phone=" + phone +
                ", weight=" + weight +
                ", operater='" + operater + '\'' +
                ", company='" + company + '\'' +
                ", date=" + date +
                ", route=" + route +
                '}';
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
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
     * @return routeid
     */
    public Integer getRouteid() {
        return routeid;
    }

    /**
     * @param routeid
     */
    public void setRouteid(Integer routeid) {
        this.routeid = routeid;
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
     * @return operater
     */
    public String getOperater() {
        return operater;
    }

    /**
     * @param operater
     */
    public void setOperater(String operater) {
        this.operater = operater;
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
}