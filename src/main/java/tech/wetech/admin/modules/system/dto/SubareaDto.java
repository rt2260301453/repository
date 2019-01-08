package tech.wetech.admin.modules.system.dto;

import lombok.Data;
import tech.wetech.admin.modules.system.po.Subarea;

@Data
public class SubareaDto {

    private  String id;

    private String fixedareaId;

    private String pro;

    private String city;

    private String county;

    private String attribute;

    private String keyword;

    private String auxiliarykeywords;

    private Integer starnum;

    private Integer endnum;

    private String single;

    public SubareaDto() {

    }

    public SubareaDto(Subarea subarea) {
        this.id = subarea.getId();
        this.fixedareaId = subarea.getFixedareaId();
        this.pro = subarea.getPro();
        this.city = subarea.getCity();
        this.county = subarea.getCounty();
        this.attribute = subarea.getAttribute();
        this.keyword = subarea.getKeyword();
        this.auxiliarykeywords = subarea.getAuxiliarykeywords();
        this.starnum = subarea.getStarnum();
        this.endnum = subarea.getEndnum();
        this.single = subarea.getSingle();
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFixedareaId() {
        return fixedareaId;
    }
    public void setFixedareaId(String fixedareaId) {
        this.fixedareaId = fixedareaId;
    }
    public String getPro() {
        return pro;
    }
    public void setPro(String pro) {
        this.pro = pro;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCounty() {
        return county;
    }
    public void setCounty(String county) {
        this.county = county;
    }
    public String getAttribute() {
        return attribute;
    }
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
    public String getKeyword() {
        return keyword;
    }
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    public String getAuxiliarykeywords() {
        return auxiliarykeywords;
    }
    public void setAuxiliarykeywords(String auxiliarykeywords) {
        this.auxiliarykeywords = auxiliarykeywords;
    }
    public Integer getStarnum() {
        return starnum;
    }
    public void setStarnum(Integer starnum) {
        this.starnum = starnum;
    }
    public Integer getEndnum() {
        return endnum;
    }
    public void setEndnum(Integer endnum) {
        this.endnum = endnum;
    }
    public String getSingle() {
        return single;
    }
    public void setSingle(String single) {
        this.single = single;
    }


}
