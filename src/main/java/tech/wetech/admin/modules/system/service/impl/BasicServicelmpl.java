package tech.wetech.admin.modules.system.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.modules.system.mapper.BasicMapper;
import tech.wetech.admin.modules.system.po.Basic;
import tech.wetech.admin.modules.system.query.BasicQuery;
import tech.wetech.admin.modules.system.service.BasicService;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BasicServicelmpl implements BasicService {

    @Autowired
    @Resource
    private BasicMapper basicMapper;

    @Override
    public PageResultSet<Basic> findByPage(BasicQuery basicQuery) {

        if (!StringUtils.isEmpty(basicQuery.getOrderBy())) {
            PageHelper.orderBy(basicQuery.getOrderBy());
        }
        Weekend<Basic> weekend = Weekend.of(Basic.class);
        WeekendCriteria<Basic, Object> criteria = weekend.weekendCriteria();
        if (!StringUtils.isEmpty(basicQuery.getBasicno())) {
            criteria.andLike(Basic::getBasicno, "%" +basicQuery.getBasicno()+ "%");
        }

        PageResultSet<Basic> resultSet = new PageResultSet<>();
        Page page = PageHelper.offsetPage(basicQuery.getOffset(), basicQuery.getLimit()).doSelectPage(() -> basicMapper.selectByExample(weekend));
        resultSet.setRows(page);
        resultSet.setTotal(page.getTotal());
        return resultSet;
    }

    @Override
    public List<Basic> findAll() {
        return basicMapper.selectAll();
    }

    @Override
    public Basic findOne(int basicId) {
        return basicMapper.selectByPrimaryKey(basicId);
    }

    @Override
    public void createBasic(Basic basic) {
        basicMapper.insertSelective(basic);
    }

    @Override
    public void updateBasic(Basic basic) {
        basicMapper.updateByPrimaryKeySelective(basic);
    }

    @Override
    public void deleteBasic(int basicId) {
        basicMapper.deleteByPrimaryKey(basicId);
    }

}
