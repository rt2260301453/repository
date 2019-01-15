package tech.wetech.admin.modules.system.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.modules.system.dto.FixedAreaDto;
import tech.wetech.admin.modules.system.mapper.FixedAreaMapper;
import tech.wetech.admin.modules.system.po.FixedArea;
import tech.wetech.admin.modules.system.query.FixedAreaQuery;
import tech.wetech.admin.modules.system.service.FixedAreaService;
import tech.wetech.admin.modules.system.service.PasswordHelper;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class FixedAreaServiceImpl implements FixedAreaService {
    @Autowired
    FixedAreaMapper fixedAreaMapper;

    @Override
    public void insertOne(FixedArea fixedArea) {
        fixedAreaMapper.insert(fixedArea);
    }

    @Override
    public PageResultSet<FixedAreaDto> findByPage(FixedAreaQuery fixedAreaQuery) {
        if(!StringUtils.isEmpty(fixedAreaQuery.getOrderBy())) {
            PageHelper.orderBy(fixedAreaQuery.getOrderBy());
            PageHelper.orderBy(fixedAreaQuery.getOrderBy());
        }

        Weekend<FixedArea> example = Weekend.of(FixedArea.class);
        WeekendCriteria<FixedArea, Object> criteria = example.weekendCriteria();

        if (!StringUtils.isEmpty(fixedAreaQuery.getFixedareaname())) {
            criteria.andLike(FixedArea::getFixedareaname, "%" + fixedAreaQuery.getFixedareaname() + "%");
        }
        if(!StringUtils.isEmpty(fixedAreaQuery.getFixedareamanager())) {
            criteria.andLike(FixedArea::getFixedareamanager, "%" + fixedAreaQuery.getFixedareamanager() + "%");
        }

        List<FixedAreaDto> dtoList = new ArrayList<>();

        PageHelper.offsetPage(fixedAreaQuery.getOffset(), fixedAreaQuery.getLimit());
        fixedAreaMapper.selectByExample(example).forEach(fix -> {
            FixedAreaDto dto = new FixedAreaDto(fix);
            dtoList.add(dto);
        });

        long total = fixedAreaMapper.selectCountByExample(example);
        PageResultSet<FixedAreaDto> resultSet = new PageResultSet<>();
        resultSet.setRows(dtoList);
        resultSet.setTotal(total);
        return resultSet;
    }

    @Override
    public List<FixedArea> selectAll() {
        return fixedAreaMapper.selectAll();
    }

    @Override
    public int selectOne(FixedArea fixedArea) {
        return fixedAreaMapper.selectByNo(fixedArea);
    }

    @Override
    public void updateOne(FixedArea fixedArea) {
        fixedAreaMapper.updateByPrimaryKey(fixedArea);
    }

    @Override
    public void deleteOne(Long id) {
        fixedAreaMapper.deleteByPrimaryKey(id);
    }
}
