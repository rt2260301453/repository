package tech.wetech.admin.modules.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tech.wetech.admin.core.exception.BizException;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.core.utils.ResultCodeEnum;
import tech.wetech.admin.modules.system.mapper.SpDateMapper;
import tech.wetech.admin.modules.system.po.SpDate;
import tech.wetech.admin.modules.system.query.SpDateQuery;
import tech.wetech.admin.modules.system.service.SpDateService;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpDateServicelmpl  implements SpDateService {
    @Autowired
    @Resource
    private SpDateMapper spDateMapper;

    @Override
    public PageResultSet<SpDate> findByPage(SpDateQuery spDateQuery) {

        if (!StringUtils.isEmpty(spDateQuery.getOrderBy())) {
            PageHelper.orderBy(spDateQuery.getOrderBy());
        }
        Weekend<SpDate> weekend = Weekend.of(SpDate.class);
        WeekendCriteria<SpDate, Object> criteria = weekend.weekendCriteria();
        if (!StringUtils.isEmpty(spDateQuery.getDateName())) {
            criteria.andLike(SpDate::getDatename, spDateQuery.getDateName());
        }

        PageResultSet<SpDate> resultSet = new PageResultSet<>();
        Page page = PageHelper.offsetPage(spDateQuery.getOffset(), spDateQuery.getLimit()).doSelectPage(() -> spDateMapper.selectByExample(weekend));
        resultSet.setRows(page);
        resultSet.setTotal(page.getTotal());
        return resultSet;
    }

    @Override
    public List<SpDate> findAll() {
        return spDateMapper.selectAll();
    }

    @Override
    public SpDate findOne(String  searchName){
        return spDateMapper.selectByPrimaryKey(searchName);
    }

    @Override
    public void createSpDate(SpDate spDate) {
        spDateMapper.insertSelective(spDate);
    }

    @Override
    public void updateSpDate(SpDate spDate) {
        spDateMapper.updateByPrimaryKeySelective(spDate);
    }

    @Override
    public void deleteSpDate(Long id) {
        spDateMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int selectOnename(SpDate spDate){
        return spDateMapper.selectByName(spDate);
    }

  /*  @Override
    @Transactional
    public void createBasic(SpDate basic) {
        SpDate b = findByBasicname(basic.getDatename());
        if (b != null) {
            throw new BizException(ResultCodeEnum.FAILED_BASICNAME_ALREADY_EXIST);
        }
        SpDate s = findByBasicno(basic.getBasicno());
        if (s != null) {
            throw new BizException(ResultCodeEnum.FAILED_BASICNO_ALREADY_EXIST);
        }
        basicMapper.insertSelective(basic);
    }*/

}
