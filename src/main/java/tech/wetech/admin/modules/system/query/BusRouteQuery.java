package tech.wetech.admin.modules.system.query;

import lombok.Data;
import tech.wetech.admin.core.utils.BaseQuery;
import tech.wetech.admin.modules.system.po.Busroute;

import javax.persistence.Id;
import java.util.Date;
@Data
public class BusRouteQuery extends BaseQuery<Busroute> {
    private String style;
    private String namefrom;
    private String nameto;
    private String license;
    private String operators;
    private String driver;

    public BusRouteQuery() {
    }

    @Override
    public String toString() {
        return "BusRouteQuery{" +
                "style='" + style + '\'' +
                ", namefrom='" + namefrom + '\'' +
                ", nameto='" + nameto + '\'' +
                ", license='" + license + '\'' +
                ", operators='" + operators + '\'' +
                ", driver='" + driver + '\'' +
                '}';
    }

    public BusRouteQuery(String style, String namefrom, String nameto, String license, String operators, String driver) {
        this.style = style;
        this.namefrom = namefrom;
        this.nameto = nameto;
        this.license = license;
        this.operators = operators;
        this.driver = driver;
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

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

}
