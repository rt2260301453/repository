package tech.wetech.admin.modules.system.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.core.utils.ResultCodeEnum;
import tech.wetech.admin.core.exception.BizException;
import tech.wetech.admin.modules.system.dto.QuYuDto;
import tech.wetech.admin.modules.system.mapper.QuYuMapper;
import tech.wetech.admin.modules.system.po.*;
import tech.wetech.admin.modules.system.dto.UserDto;
import tech.wetech.admin.modules.system.query.QuYuQuery;
import tech.wetech.admin.modules.system.query.UserQuery;
import tech.wetech.admin.modules.system.service.*;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.*;

@Service
public  class QuYuServiceImpl implements QuYuService {

    @Autowired
    private QuYuMapper quyuMapper;

    @Autowired
    private RoleService roleService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private PasswordHelper passwordHelper;

    @Override
    public PageResultSet<QuYuDto> findByPage(QuYuQuery quyuQuery) {
        System.out.println("查询用户数据quyuServiceImpl:"+quyuQuery+"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++=+++++++++++++++++++++++++++++++++++++");
        System.out.println("查询用户数据");
        if(!StringUtils.isEmpty(quyuQuery.getOrderBy())) {
            PageHelper.orderBy(quyuQuery.getOrderBy());
        }

        Weekend<QuYu> example = Weekend.of(QuYu.class);
        WeekendCriteria<QuYu, Object> criteria = example.weekendCriteria();

    if (!StringUtils.isEmpty(quyuQuery.getProvince())) {
         criteria.andLike(QuYu::getProvince, "%" + quyuQuery.getProvince() + "%");

     }
     if (!StringUtils.isEmpty(quyuQuery.getCity())) {
            criteria.andLike(QuYu::getCity, "%" + quyuQuery.getCity() + "%");

        }if (!StringUtils.isEmpty(quyuQuery.getQu())) {
            criteria.andLike(QuYu::getQu, "%" + quyuQuery.getQu() + "%");

        }


        List<QuYuDto> dtoList = new ArrayList<>();

      PageHelper.offsetPage(quyuQuery.getOffset(), quyuQuery.getLimit());
       quyuMapper.selectByExample(example).forEach(u -> {
           System.out.println("查询到页面的u"+u);
            QuYuDto dto = new QuYuDto(u);
           dtoList.add(dto);
        });

        long total = quyuMapper.selectCountByExample(example);
        PageResultSet<QuYuDto> resultSet = new PageResultSet<>();
        resultSet.setRows(dtoList);
        resultSet.setTotal(total);
        return resultSet;
    }

    @Override
    public QuYu findOne(Integer id) {
        return null;
    }

    @Override
    public List<QuYu> findAll() {
        return quyuMapper.selectAll();
    }

  /*  @Override
    public QuYu findByProvince(String province) {
        QuYu quyu = new QuYu();
        quyu.setProvince(province);
        quyuMapper.selectOne(province);
        return quyuMapper.selectOne(province);
    }*/

    private String getGroupNames(Collection<Long> groupIds) {
        if (CollectionUtils.isEmpty(groupIds)) {
            return "";
        }

        StringBuilder s = new StringBuilder();
        for (Long groupId : groupIds) {
            Group role = groupService.findOne(groupId);
            if (role != null) {
                s.append(role.getName());
                s.append(",");
            }
        }

        if (s.length() > 0) {
            s.deleteCharAt(s.length() - 1);
        }

        return s.toString();
    }


    private String getRoleNames(Collection<Long> groupIds) {
        if (CollectionUtils.isEmpty(groupIds)) {
            return "";
        }

        StringBuilder s = new StringBuilder();
        for (Long roleId : groupIds) {
            Role role = roleService.findOne(roleId);
            if (role != null) {
                s.append(role.getDescription());
                s.append(",");
            }
        }

        if (s.length() > 0) {
            s.deleteCharAt(s.length() - 1);
        }

        return s.toString();
    }

    private String getOrganizationName(Long organizationId) {
        Organization organization = organizationService.findOne(organizationId);
        if (organization == null) {
            return "";
        }
        return organization.getName();
    }

    @Override

    public void createQuYu(QuYu quyu) {
      /*  User u = findByUsername(user.getUsername());
        if (u != null) {
            throw new BizException(ResultCodeEnum.FAILED_USER_ALREADY_EXIST);
        }*/

        quyuMapper.insertSelective(quyu);
    }

   @Override
   @Transactional
    public void updateQuYu(QuYu quyu) {
        System.out.println("到达修改页面，，++++++++"+quyu);
       quyuMapper.updateByPrimaryKeySelective(quyu);
    }

  @Override

    public void deleteQuYu(Integer quyuId) {
        quyuMapper.deleteByPrimaryKey(quyuId);
    }

    @Override
    public List<QuYu> selectAllCity() {
        return quyuMapper.selectAllCity();
    }
    @Override
    public List<QuYu> selectAllProvince() {
        return quyuMapper.selectAllProvince();
    }
    @Override
    public List<QuYu> selectAllQu() {
        return quyuMapper.selectAllQu();
    }


   /*    @Override
    @Transactional
    public void changePassword(Long userId, String newPassword) {
        User user = userMapper.selectByPrimaryKey(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public User findOne(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    @Override
    public User findByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        userMapper.selectOne(user);
        return userMapper.selectOne(user);
    }

    @Override
    public Set<String> findRoles(String username) {
        User user = findByUsername(username);
        if (user == null) {
            return Collections.EMPTY_SET;
        }
        return roleService.findRoles(user.getRoleIdList().toArray(new Long[0]));
    }

    @Override
    public Set<String> findPermissions(String username) {
        User user = findByUsername(username);
        if (user == null) {
            return Collections.EMPTY_SET;
        }
        return roleService.findPermissions(user.getRoleIdList().toArray(new Long[0]));


    }*/
}

