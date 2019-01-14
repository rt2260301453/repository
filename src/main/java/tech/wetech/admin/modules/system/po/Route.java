package tech.wetech.admin.modules.system.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Route {
    private Integer routeid;

    private String style;

    private String namefrom;

    private String nameto;

    private String operator;

    private String company;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date date;

    private String remark;

    @Override
    public String toString() {
        return "Route{" +
                "routeid=" + routeid +
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