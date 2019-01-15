package tech.wetech.admin.modules.system.service;

import tech.wetech.admin.core.exception.BizException;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.modules.system.po.Route;
import tech.wetech.admin.modules.system.po.SpDate;
import tech.wetech.admin.modules.system.po.User;
import tech.wetech.admin.modules.system.query.SpDateQuery;

import java.util.List;

public interface SpDateService {

    /**
     * 分页查询用户组
     * @param spDateQuery
     * @return
     */
    PageResultSet<SpDate> findByPage(SpDateQuery spDateQuery);

    public SpDate findByUsername(String username);

    /**
     * 查询所有
     * @return
     */
    List<SpDate> findAll();

    int findBySpDate(Route route);
    /**
     * 查询单个
     * @param searchName
     * @return
     */
    SpDate findOne(String searchName);

    /**
     * 创建用户组
     * @param spDate
     */
    void createSpDate(SpDate spDate);

    /**
     * 更新用户组
     * @param spDate
     */
    void updateSpDate(SpDate spDate);

    /**
     * 删除用户组
     * @param id
     */
    void deleteSpDate(Long id);

    /**
     * 校验基本档案名称no
     * 1
     * @param spDate
     * @return
     */
    int selectOnename(SpDate spDate);
}
