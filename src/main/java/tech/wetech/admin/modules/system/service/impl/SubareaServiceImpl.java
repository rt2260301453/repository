package tech.wetech.admin.modules.system.service.impl;


import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tech.wetech.admin.core.exception.BizException;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.modules.system.dto.QuYuDto;
import tech.wetech.admin.modules.system.dto.SubareaDto;
import tech.wetech.admin.modules.system.mapper.QuYuMapper;
import tech.wetech.admin.modules.system.mapper.SubareaMapper;
import tech.wetech.admin.modules.system.po.Addr;
import tech.wetech.admin.modules.system.po.QuYu;
import tech.wetech.admin.modules.system.po.Subarea;
import tech.wetech.admin.modules.system.po.User;
import tech.wetech.admin.modules.system.query.QuYuQuery;
import tech.wetech.admin.modules.system.query.SubareaQuery;
import tech.wetech.admin.modules.system.service.*;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.*;

@Service
public class SubareaServiceImpl implements SubareaService {
    @Autowired
    private SubareaMapper subareaMapper;

    @Autowired
    private QuYuMapper quYuMapper;

    @Override
    public void createUser(Subarea subarea) throws BizException {
        subareaMapper.insertSelective(subarea);
    }

    @Override
    public void updateUser(Subarea subarea) {
        subareaMapper.updateByPrimaryKeySelective(subarea);
    }


    @Override
    public int selectOneno(Subarea subarea) {
        return subareaMapper.selectByNo(subarea);
    }

    @Override
    public void deleteId(String subareaId) {
      subareaMapper.deleteByPrimaryKey(subareaId);
    }

    @Override
    public List<Addr> findPro() {
        List<Addr> pro = subareaMapper.selectByPro();
        return pro;
    }

    @Override
    public List<QuYu> findQuYuAll() {
        List<QuYu> pro = quYuMapper. selectAllProvince();
        return pro;
    }

    @Override
    public List<Addr> findEdit() {
        List pro = new ArrayList<> ();

        subareaMapper.selectAll().forEach(u -> {
            Addr addr = new Addr();
            SubareaDto dto = new SubareaDto(u);
            addr.setPro(dto.getPro());
            addr.setCity(dto.getCity());
            addr.setCounty(dto.getCounty());
            pro.add(addr);
        });
        System.out.println("pro"+pro);
        Set set = new HashSet();
        List listNew=new ArrayList<>();
        set.addAll(pro);
        listNew.addAll(set);
        return listNew;
    }



    @Override
    public List<Addr> findCity(SubareaQuery subareaQuery){
        Weekend<Subarea> example = Weekend.of(Subarea.class);
        WeekendCriteria<Subarea, Object> criteria = example.weekendCriteria();
        if (!StringUtils.isEmpty(subareaQuery.getPro())) {
            criteria.andLike(Subarea::getPro, "%" + subareaQuery.getPro() + "%");
        }
        List pro = new ArrayList<> ();
        subareaMapper.selectByExample(example).forEach(u -> {
            Addr addr = new Addr();
            SubareaDto dto = new SubareaDto(u);
            addr.setCity(dto.getCity());
            pro.add(addr.getCity());
        });
        Set set = new HashSet();
        List listNew=new ArrayList<>();
        set.addAll(pro);
        listNew.addAll(set);
        listNew.add(0,"请选择");
        return listNew;
    };

    @Override
    public List<Addr> findQuYuCity(QuYuQuery quYuQuery){
        Weekend<QuYu> example = Weekend.of(QuYu.class);
        WeekendCriteria<QuYu, Object> criteria = example.weekendCriteria();
        if (!StringUtils.isEmpty(quYuQuery.getProvince())) {
            criteria.andLike(QuYu::getProvince, "%" + quYuQuery.getProvince() + "%");
        }
        List pro = new ArrayList<> ();
       quYuMapper.selectByExample(example).forEach(u -> {
            Addr addr = new Addr();
            QuYuDto dto = new QuYuDto(u);
            addr.setCity(dto.getCity());
            pro.add(addr.getCity());
        });
        Set set = new HashSet();
        List listNew=new ArrayList<>();
        set.addAll(pro);
        listNew.addAll(set);
        listNew.add(0,"请选择");
        return listNew;
    };

    @Override
    public List<Addr> findQuYuCounty(QuYuQuery quYuQuery){
        Weekend<QuYu> example = Weekend.of(QuYu.class);
        WeekendCriteria<QuYu, Object> criteria = example.weekendCriteria();
        if (!StringUtils.isEmpty(quYuQuery.getCity())) {
            criteria.andLike(QuYu::getCity, "%" + quYuQuery.getCity() + "%");
        }
        List pro = new ArrayList<> ();
        quYuMapper.selectByExample(example).forEach(u -> {
            QuYuDto dto = new QuYuDto(u);
            pro.add(dto.getQu());
        });
        Set set = new HashSet();
        List listNew=new ArrayList<>();
        set.addAll(pro);
        listNew.addAll(set);
        listNew.add(0,"请选择");
        return listNew;
    };


    @Override
    public List<Addr> findCounty(SubareaQuery subareaQuery){
        Weekend<Subarea> example = Weekend.of(Subarea.class);
        WeekendCriteria<Subarea, Object> criteria = example.weekendCriteria();

        if (!StringUtils.isEmpty(subareaQuery.getCity())) {
            criteria.andLike(Subarea::getCity, "%" + subareaQuery.getCity() + "%");
        }
        List pro = new ArrayList<> ();
        subareaMapper.selectByExample(example).forEach(u -> {
            Addr addr = new Addr();
            SubareaDto dto = new SubareaDto(u);
            addr.setCounty(dto.getCounty());
            pro.add(addr.getCounty());
        });
        Set set = new HashSet();
        List listNew=new ArrayList<>();
        set.addAll(pro);
        listNew.addAll(set);
        listNew.add(0,"请选择");
        return listNew;
    };



    @Override
    public PageResultSet<SubareaDto> findByPage(SubareaQuery subareaQuery) {
        if(!StringUtils.isEmpty(subareaQuery.getOrderBy())) {
            PageHelper.orderBy(subareaQuery.getOrderBy());
        }
        Weekend<Subarea> example = Weekend.of(Subarea.class);
        WeekendCriteria<Subarea, Object> criteria = example.weekendCriteria();
        if (!StringUtils.isEmpty(subareaQuery.getId())) {
            criteria.andLike(Subarea::getId, "%" + subareaQuery.getId() + "%");
        }
        if (!StringUtils.isEmpty(subareaQuery.getPro())) {
            criteria.andLike(Subarea::getPro, "%" + subareaQuery.getPro() + "%");
        }
        if (!StringUtils.isEmpty(subareaQuery.getCity())) {
            criteria.andLike(Subarea::getCity, "%" + subareaQuery.getCity() + "%");
        }
        if (!StringUtils.isEmpty(subareaQuery.getCounty())) {
            criteria.andLike(Subarea::getCounty, "%" + subareaQuery.getCounty() + "%");
        }
        if (!StringUtils.isEmpty(subareaQuery.getKeyword())) {
            criteria.andLike(Subarea::getKeyword, "%" + subareaQuery.getKeyword() + "%");
        }
        if (!StringUtils.isEmpty(subareaQuery.getAuxiliarykeywords())) {
            criteria.andLike(Subarea::getAuxiliarykeywords, "%" + subareaQuery.getAuxiliarykeywords() + "%");
        }
        List<SubareaDto> dtoList = new ArrayList<>();
        PageHelper.offsetPage(subareaQuery.getOffset(), subareaQuery.getLimit());
        subareaMapper.selectByExample(example).forEach(u -> {
            SubareaDto dto = new SubareaDto(u);
            dtoList.add(dto);
        });
        long total = subareaMapper.selectCountByExample(example);
        PageResultSet<SubareaDto> resultSet = new PageResultSet<>();
        resultSet.setRows(dtoList);
        resultSet.setTotal(total);
        return resultSet;
    }

    @Override
    public List<Addr> selectCity(Addr addr){
        return subareaMapper.selectCity(addr);
    }

    @Override
    public List<Addr> selectCou(Addr addr){
        return  subareaMapper.selectCou(addr);
    }

    @Override
    public List<Subarea> findAll(){
        return  subareaMapper.selectAll();
    }
}
