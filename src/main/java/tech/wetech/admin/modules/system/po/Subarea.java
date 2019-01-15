package tech.wetech.admin.modules.system.po;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * @author cjbi
 */
@Data
@Table(name = "subarea")
public class Subarea {

    @Id
    @Column(name = "id")
    @NotBlank(message = "分拣编号不能为空")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "fixedarea_id")
    private String fixedareaId;

    @Column(name = "pro")
    private String pro;

    private String city;

    @Column(name = "county")
    private String county;

    private String attribute;


    private String keyword;

    private String auxiliarykeywords;

    private Integer starnum;

    private Integer endnum;

    private String single;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return fixedarea_id
     */
    public String getFixedareaId() {
        return fixedareaId;
    }

    /**
     * @param fixedareaId
     */
    public void setFixedareaId(String fixedareaId) {
        this.fixedareaId = fixedareaId;
    }

    /**
     * @return pro
     */
    public String getPro() {
        return pro;
    }

    /**
     * @param pro
     */
    public void setPro(String pro) {
        this.pro = pro;
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
     * @return county
     */
    public String getCounty() {
        return county;
    }

    /**
     * @param county
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * @return attribute
     */
    public String getAttribute() {
        return attribute;
    }

    /**
     * @param attribute
     */
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    /**
     * @return keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * @param keyword
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * @return auxiliarykeywords
     */
    public String getAuxiliarykeywords() {
        return auxiliarykeywords;
    }

    /**
     * @param auxiliarykeywords
     */
    public void setAuxiliarykeywords(String auxiliarykeywords) {
        this.auxiliarykeywords = auxiliarykeywords;
    }

    /**
     * @return starnum
     */
    public Integer getStarnum() {
        return starnum;
    }

    /**
     * @param starnum
     */
    public void setStarnum(Integer starnum) {
        this.starnum = starnum;
    }

    /**
     * @return endnum
     */
    public Integer getEndnum() {
        return endnum;
    }

    /**
     * @param endnum
     */
    public void setEndnum(Integer endnum) {
        this.endnum = endnum;
    }

    /**
     * @return single
     */
    public String getSingle() {
        return single;
    }

    /**
     * @param single
     */
    public void setSingle(String single) {
        this.single = single;
    }
}