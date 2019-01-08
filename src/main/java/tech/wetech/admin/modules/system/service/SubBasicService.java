package tech.wetech.admin.modules.system.service;

import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.modules.system.po.SubBasic;
import tech.wetech.admin.modules.system.query.SubBasicQuery;

import java.util.List;

/**
 * 组服务接口
 * @author cjbi
 */
public interface SubBasicService {

    /**
     * 分页查询用户组
     * @param subbasicQuery
     * @return
     */
    PageResultSet<SubBasic> findByPage(SubBasicQuery subbasicQuery);

    /**
     * 查询所有
     * @return
     */
    List<SubBasic> findAll();

    /**
     * 查询单个
     * @param subbasicId
     * @return
     */
    SubBasic findOne(int subbasicId);

    /**
     * 创建用户组
     * @param subbasic
     */
    void createsubBasic(SubBasic subbasic);

    /**
     * 更新用户组
     * @param subbasic
     */
    void updatesubBasic(SubBasic subbasic);

    /**
     * 删除用户组
     * @param subbasicId
     */
    void deletesubBasic(int subbasicId);

}
