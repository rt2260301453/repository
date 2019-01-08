package tech.wetech.admin.modules.system.service.impl;


import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tech.wetech.admin.core.exception.BizException;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.modules.system.dto.SubareaDto;
import tech.wetech.admin.modules.system.mapper.SubareaMapper;
import tech.wetech.admin.modules.system.po.Subarea;
import tech.wetech.admin.modules.system.query.SubareaQuery;
import tech.wetech.admin.modules.system.service.*;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.*;

@Service
public class SubareaServiceImpl implements SubareaService {
    @Autowired
    private SubareaMapper subareaMapper;

    @Override
    public void createUser(Subarea subarea) throws BizException {

    }

    @Override
    public void updateUser(Subarea subarea) {

    }

    @Override
    public void deleteUser(String subareaId) {

    }


    @Override
    public List<Subarea> findAll() {
        return subareaMapper.selectAll();
    }


    @Override
    public PageResultSet<SubareaDto> findByPage(SubareaQuery subareaQuery) {
        System.out.println("查询分区数据SubareaServiceImpl:"+subareaQuery);
        System.out.println("查询分区数据SubareaServiceImpl");
        if(!StringUtils.isEmpty(subareaQuery.getOrderBy())) {
            PageHelper.orderBy(subareaQuery.getOrderBy());
        }
        Weekend<Subarea> example = Weekend.of(Subarea.class);
        WeekendCriteria<Subarea, Object> criteria = example.weekendCriteria();
        if (!StringUtils.isEmpty(subareaQuery.getId())) {
            criteria.andLike(Subarea::getId, "%" + subareaQuery.getId() + "%");
        }
        List<SubareaDto> dtoList = new ArrayList<>();

        PageHelper.offsetPage(subareaQuery.getOffset(), subareaQuery.getLimit());


        subareaMapper.selectByExample(example).forEach(u -> {
            SubareaDto dto = new SubareaDto(u);
            dto.setId(dto.getId());
            dtoList.add(dto);
        });
        long total = subareaMapper.selectCountByExample(example);
        System.out.println("SubareaServiceImpl+++total："+total);
        System.out.println("SubareaServiceImpl+++dtoList："+dtoList);
        System.out.println("SubareaServiceImpl+++dtoList："+dtoList);


        PageResultSet<SubareaDto> resultSet = new PageResultSet<>();
        resultSet.setRows(dtoList);
        resultSet.setTotal(total);

        System.out.println("SubareaServiceImpl+++resultSet"+resultSet);
        return resultSet;
    }

    @Override
    public List<SubareaDto> findByAddr(SubareaQuery subareaQuery) {
        System.out.println("查询分区数据SubareaServiceImpl:"+subareaQuery);
        System.out.println("查询分区数据SubareaServiceImpl");
        if(!StringUtils.isEmpty(subareaQuery.getOrderBy())) {
            PageHelper.orderBy(subareaQuery.getOrderBy());
        }
        Weekend<Subarea> example = Weekend.of(Subarea.class);
        WeekendCriteria<Subarea, Object> criteria = example.weekendCriteria();
        if (!StringUtils.isEmpty(subareaQuery.getId())) {
            criteria.andLike(Subarea::getId, "%" + subareaQuery.getId() + "%");
        }
        List<SubareaDto> dtoList = new ArrayList<>();

        return dtoList;
    }


}
