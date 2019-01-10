package tech.wetech.admin.modules.system.query;

import tech.wetech.admin.core.utils.BaseQuery;
import tech.wetech.admin.modules.system.po.Basic;

/**
 * @author cjbi
 */
public class BasicQuery extends BaseQuery<Basic> {
    /**
     * 基本档案编号
     */
    private String basicno;

    private Boolean locked;


    public String getBasicno() {
        return basicno;
    }

    public void setBasicno(String basicno) {
        this.basicno = basicno;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }
}
