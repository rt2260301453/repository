package tech.wetech.admin.modules.system.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.wetech.admin.core.exception.BizException;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.core.utils.ResultCodeEnum;
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
    public void updateBasic(Basic basic) {
        int cl = selectClass(basic);
        if(cl == 0){
            basicMapper.updateByPrimaryKeySelective(basic);
        }else{
            if(basic.getClassifying()==1){
                basicMapper.updateByPrimaryKeySelective(basic);
            }else{
                throw new BizException(ResultCodeEnum.FAILED_CLASSIFYING_ALREADY_EXIST);
            }
        }
    }

    @Override
    public void updateBasicremark(Basic basic) {
        basicMapper.updateByPrimaryKeySelective(basic);
    }

    @Override
    public void updateBasicreclassifying(Basic basic) {
        int cl = selectClass(basic);
        if(cl == 0){
            basicMapper.updateByPrimaryKeySelective(basic);
        }else{
            if(basic.getClassifying()==1){
                basicMapper.updateByPrimaryKeySelective(basic);
            }else{
                throw new BizException(ResultCodeEnum.FAILED_CLASSIFYING_ALREADY_EXIST);
            }
        }
    }

    @Override
    public void deleteBasic(String basicno) { basicMapper.deleteByPrimaryKey(basicno);}

    @Override
    public Basic findByBasicname(String basicname) {
        Basic basic = new Basic();
        basic.setBasicname(basicname);
        basicMapper.selectOne(basic);
        return basicMapper.selectOne(basic);
    }

    @Override
    public Basic findByBasicno(String basicno) {
        Basic basic = new Basic();
        basic.setBasicno(basicno);
        basicMapper.selectOne(basic);
        return basicMapper.selectOne(basic);
    }

    @Override
    public int selectClass(Basic basic) {
        return basicMapper.selectByClass(basic);
    }

    @Override
    @Transactional
    public void createBasic(Basic basic) {
        Basic b = findByBasicname(basic.getBasicname());
        if (b != null) {
            throw new BizException(ResultCodeEnum.FAILED_BASICNAME_ALREADY_EXIST);
        }
        Basic s = findByBasicno(basic.getBasicno());
        if (s != null) {
            throw new BizException(ResultCodeEnum.FAILED_BASICNO_ALREADY_EXIST);
        }
        basicMapper.insertSelective(basic);
    }

    @Override
    public int selectOneno(Basic basic) {
        return basicMapper.selectByNo(basic);
    }

    @Override
    public int selectOnename(Basic basic) {
        return basicMapper.selectByName(basic);
    }


}
