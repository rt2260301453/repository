package tech.wetech.admin.modules.system.po;

import javax.persistence.*;
@Table(name="associatedwidgets")
public class AssociatedWidgets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 定区编号
     */
    private String fixedareano;

    /**
     * 取派人工号
     */
    private String fetchpeopleno;

    /**
     * 取派人姓名
     */
    private String fetchpeoplename;

    /**
     * 收派标准
     */
    private String collectionstandard;

    /**
     * 收派时间
     */
    private String collectiontime;

    /**
     * 所属单位
     */
    private String institute;

    /**
     * 类型
     */
    private String type;

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
     * 获取取派人工号
     *
     * @return fetchpeopleno - 取派人工号
     */
    public String getFetchpeopleno() {
        return fetchpeopleno;
    }

    /**
     * 设置取派人工号
     *
     * @param fetchpeopleno 取派人工号
     */
    public void setFetchpeopleno(String fetchpeopleno) {
        this.fetchpeopleno = fetchpeopleno;
    }

    /**
     * 获取取派人姓名
     *
     * @return fetchpeoplename - 取派人姓名
     */
    public String getFetchpeoplename() {
        return fetchpeoplename;
    }

    /**
     * 设置取派人姓名
     *
     * @param fetchpeoplename 取派人姓名
     */
    public void setFetchpeoplename(String fetchpeoplename) {
        this.fetchpeoplename = fetchpeoplename;
    }

    /**
     * 获取收派标准
     *
     * @return collectionstandard - 收派标准
     */
    public String getCollectionstandard() {
        return collectionstandard;
    }

    /**
     * 设置收派标准
     *
     * @param collectionstandard 收派标准
     */
    public void setCollectionstandard(String collectionstandard) {
        this.collectionstandard = collectionstandard;
    }

    /**
     * 获取收派时间
     *
     * @return collectiontime - 收派时间
     */
    public String getCollectiontime() {
        return collectiontime;
    }

    /**
     * 设置收派时间
     *
     * @param collectiontime 收派时间
     */
    public void setCollectiontime(String collectiontime) {
        this.collectiontime = collectiontime;
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

    /**
     * 获取类型
     *
     * @return type - 类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置类型
     *
     * @param type 类型
     */
    public void setType(String type) {
        this.type = type;
    }
}