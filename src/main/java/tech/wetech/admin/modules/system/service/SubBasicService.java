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
     * 分页查询档案信息
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
     * 根据subbasicname查找subbasicname
     * 校验重复
     * @param subbasicname
     * @return
     */
    public SubBasic findBySubBasicname(String subbasicname);

    /**
     * 根据subbasicname查找subbasicname
     * 校验重复
     * @param subbasicname
     * @return
     */
    public SubBasic findBySubBasicname1(String subbasicname);


    /**
     * 根据subbasicno查找subbasicno
     * 校验重复
     * @param subbasicno
     * @return
     */
    public SubBasic findBySubBasicno(String subbasicno);

    /**
     * 校验基本档案编号
     * 1
     * @param subbasic
     * @return
     */
    int selectOneno(SubBasic subbasic);

    /**
     * 校验基本档案名称
     * 1
     * @param subbasic
     * @return
     */
    int selectOnename(SubBasic subbasic);
    /**
     * 校验基本档案名称
     * 1
     * @param subbasic
     * @return
     */
    public SubBasic selectOnename1(SubBasic subbasic);

    /**
     * 创建档案信息
     * @param subbasic
     */
    void createsubBasic(SubBasic subbasic);

    /**
     * 更新档案信息
     * @param subbasic
     */
    void updatesubBasic(SubBasic subbasic);

    /**
     * 删除档案信息
     * @param subbasicno
     */
    void deletesubBasic(String subbasicno);



}
