package tech.wetech.admin.modules.system.service;

import tech.wetech.admin.core.exception.BizException;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.modules.system.po.Basic;
import tech.wetech.admin.modules.system.query.BasicQuery;

import java.util.List;

/**
 * 组服务接口
 * @author cjbi
 */
public interface BasicService {

    /**
     * 分页查询用户组
     * @param basicQuery
     * @return
     */
    PageResultSet<Basic> findByPage(BasicQuery basicQuery);

    /**
     * 查询所有
     * @return
     */
    List<Basic> findAll();

    /**
     * 根据basicname查找basicname
     * 校验重复
     * @param basicname
     * @return
     */
    public Basic findByBasicname(String basicname);

    /**
     * 根据basicno查找basicno
     * 校验重复
     * @param basicno
     * @return
     */
    public Basic findByBasicno(String basicno);

    /**
     * 创建基本档案
     * @param basic
     */
    void createBasic(Basic basic) throws BizException;


    /**
     * 校验基本档案编号
     * 1
     * @param basic
     * @return
     */
    int selectOneno(Basic basic);

    /**
     * 校验基本档案名称
     * 1
     * @param basic
     * @return
     */
    int selectOnename(Basic basic);

    /**
     * 校验基本档案名称
     * 1
     * @param basic
     * @return
     */
    int selectClass(Basic basic);


    /**
     * 更新基本档案
     * @param basic
     */
    void updateBasic(Basic basic);

    /**
     * 更新基本档案
     * @param basic
     */
    void updateBasicremark(Basic basic);

    /**
     * 更新基本档案
     * @param basic
     */
    void updateBasicreclassifying(Basic basic);

    /**
     * 删除基本档案
     * @param basicno
     */
    void deleteBasic(String basicno);

}
