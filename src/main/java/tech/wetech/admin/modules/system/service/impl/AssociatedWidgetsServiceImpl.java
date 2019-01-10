package tech.wetech.admin.modules.system.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.modules.system.dto.AssociatedWidgetsDto;
import tech.wetech.admin.modules.system.mapper.AssociatedWidgetsMapper;
import tech.wetech.admin.modules.system.po.AssociatedWidgets;
import tech.wetech.admin.modules.system.query.AssociatedWidgetsQuery;
import tech.wetech.admin.modules.system.service.AssociatedWidgetsService;
import tech.wetech.admin.modules.system.service.PasswordHelper;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.ArrayList;
import java.util.List;
@Service
public class AssociatedWidgetsServiceImpl implements AssociatedWidgetsService {

    @Autowired
    AssociatedWidgetsMapper associatedWidgetsMapper;
    @Override
    public void insertOne(AssociatedWidgets associatedWidgets) {
        associatedWidgetsMapper.insert(associatedWidgets);
    }

    @Override
    public List<AssociatedWidgets> selectAll() {
        return associatedWidgetsMapper.selectAll();
    }

    @Override
    public PageResultSet<AssociatedWidgetsDto> findByPage(AssociatedWidgetsQuery associatedWidgetsQuery) {
        if(!StringUtils.isEmpty(associatedWidgetsQuery.getOrderBy())) {
            PageHelper.orderBy(associatedWidgetsQuery.getOrderBy());
            PageHelper.orderBy(associatedWidgetsQuery.getOrderBy());
        }

        Weekend<AssociatedWidgets> example = Weekend.of(AssociatedWidgets.class);
        WeekendCriteria<AssociatedWidgets, Object> criteria = example.weekendCriteria();

        if (!StringUtils.isEmpty(associatedWidgetsQuery.getFetchpeoplename())) {
            criteria.andLike(AssociatedWidgets::getFetchpeoplename, "%" + associatedWidgetsQuery.getFetchpeoplename() + "%");
        }

        List<AssociatedWidgetsDto> dtoList = new ArrayList<>();

        PageHelper.offsetPage(associatedWidgetsQuery.getOffset(), associatedWidgetsQuery.getLimit());
        associatedWidgetsMapper.selectByExample(example).forEach(assadd -> {
            AssociatedWidgetsDto dto = new AssociatedWidgetsDto(assadd);
            dtoList.add(dto);
        });

        long total = associatedWidgetsMapper.selectCountByExample(example);
        PageResultSet<AssociatedWidgetsDto> resultSet = new PageResultSet<>();
        resultSet.setRows(dtoList);
        resultSet.setTotal(total);
        return resultSet;
    }

    @Override
    public void updateOne(AssociatedWidgets associatedWidgets) {
        associatedWidgetsMapper.updateByPrimaryKey(associatedWidgets);
    }

    @Override
    public void deleteOne(Long id) {
        associatedWidgetsMapper.deleteByPrimaryKey(id);
    }
}
