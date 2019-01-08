package tech.wetech.admin.modules.system.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.modules.system.dto.AssociatedAddressDto;
import tech.wetech.admin.modules.system.mapper.AssociatedAddressMapper;
import tech.wetech.admin.modules.system.po.AssociatedAddress;
import tech.wetech.admin.modules.system.query.AssociatedAddressQuery;
import tech.wetech.admin.modules.system.service.AssociatedAddressService;
import tech.wetech.admin.modules.system.service.PasswordHelper;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssociatedAddressServiceImpl implements AssociatedAddressService {
    @Autowired
    AssociatedAddressMapper associatedAddressMapper;

    @Override
    public void insertOne(AssociatedAddress associatedAddress) {
        associatedAddressMapper.insert(associatedAddress);
    }

    @Override
    public PageResultSet<AssociatedAddressDto> findByPage(AssociatedAddressQuery associatedAddressQuery) {
        if(!StringUtils.isEmpty(associatedAddressQuery.getOrderBy())) {
            PageHelper.orderBy(associatedAddressQuery.getOrderBy());
            PageHelper.orderBy(associatedAddressQuery.getOrderBy());
        }

        Weekend<AssociatedAddress> example = Weekend.of(AssociatedAddress.class);
        WeekendCriteria<AssociatedAddress, Object> criteria = example.weekendCriteria();

        if (!StringUtils.isEmpty(associatedAddressQuery.getCityname())) {
            criteria.andLike(AssociatedAddress::getCityname, "%" + associatedAddressQuery.getCityname() + "%");
        }

        List<AssociatedAddressDto> dtoList = new ArrayList<>();

        PageHelper.offsetPage(associatedAddressQuery.getOffset(), associatedAddressQuery.getLimit());
        associatedAddressMapper.selectByExample(example).forEach(assadd -> {
            AssociatedAddressDto dto = new AssociatedAddressDto(assadd);
            dtoList.add(dto);
        });

        long total = associatedAddressMapper.selectCountByExample(example);
        PageResultSet<AssociatedAddressDto> resultSet = new PageResultSet<>();
        resultSet.setRows(dtoList);
        resultSet.setTotal(total);
        return resultSet;
    }

    @Override
    public List<AssociatedAddress> selectAll() {
        return associatedAddressMapper.selectAll();
    }

    @Override
    public void updateOne(AssociatedAddress associatedAddress) {
        associatedAddressMapper.updateByPrimaryKey(associatedAddress);
    }

    @Override
    public void deleteOne(Long id) {
        associatedAddressMapper.deleteByPrimaryKey(id);
    }
}
