package tech.wetech.admin.modules.system.service;

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
     * 查询单个
     * @param basicId
     * @return
     */
    Basic findOne(int basicId);

    /**
     * 创建用户组
     * @param basic
     */
    void createBasic(Basic basic);

    /**
     * 更新用户组
     * @param basic
     */
    void updateBasic(Basic basic);

    /**
     * 删除用户组
     * @param basicId
     */
    void deleteBasic(int basicId);

}
