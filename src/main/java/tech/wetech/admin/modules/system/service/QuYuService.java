package tech.wetech.admin.modules.system.service;

import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.core.exception.BizException;
import tech.wetech.admin.modules.system.dto.QuYuDto;
import tech.wetech.admin.modules.system.po.QuYu;
import tech.wetech.admin.modules.system.po.User;
import tech.wetech.admin.modules.system.dto.UserDto;
import tech.wetech.admin.modules.system.query.QuYuQuery;
import tech.wetech.admin.modules.system.query.UserQuery;

import java.util.List;
import java.util.Set;

public interface QuYuService<p, pa> {

    PageResultSet<QuYuDto> findByPage(QuYuQuery quyuQuery);

    /**
     * 创建用户
     * @param quyu
     */
   void createQuYu(QuYu quyu) throws BizException;

   void updateQuYu(QuYu quyu);

   void deleteQuYu(Integer quyuId);


    /*    void changePassword(Long userId, String newPassword);
*/

    QuYu findOne(Integer id);

    List<QuYu> findAll();

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     *//*
    public User findByUsername(String username);

    */

 /*   public QuYu findByProvince(String province);*/
    /**
     * 根据用户名查找其角色
     * @param username
     * @return
     *//*
    Set<String> findRoles(String username);

    *//**
     * 根据用户名查找其权限
     * @param username
     * @return
     *//*
    Set<String> findPermissions(String username);*/

    List<QuYu> selectAllCity();
    List<QuYu> selectAllProvince();
    List<QuYu> selectAllQu();

}
