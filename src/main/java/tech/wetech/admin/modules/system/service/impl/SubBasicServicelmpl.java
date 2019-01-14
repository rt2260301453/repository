package tech.wetech.admin.modules.system.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.modules.system.mapper.SubBasicMapper;
import tech.wetech.admin.modules.system.po.SubBasic;
import tech.wetech.admin.modules.system.query.SubBasicQuery;
import tech.wetech.admin.modules.system.service.SubBasicService;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SubBasicServicelmpl implements SubBasicService {

    @Autowired
    @Resource
    private SubBasicMapper subbasicMapper;

    @Override
    public PageResultSet<SubBasic> findByPage(SubBasicQuery subbasicQuery) {

        if (!StringUtils.isEmpty(subbasicQuery.getOrderBy())) {
            PageHelper.orderBy(subbasicQuery.getOrderBy());
        }
        Weekend<SubBasic> weekend = Weekend.of(SubBasic.class);
        WeekendCriteria<SubBasic, Object> criteria = weekend.weekendCriteria();
        System.out.println("wwwww="+subbasicQuery.getSubbasicno());
        if (!StringUtils.isEmpty(subbasicQuery.getSubbasicno())) {
            criteria.andLike(SubBasic::getSubbasicno, "%" +subbasicQuery.getSubbasicno()+ "%");
        }

        PageResultSet<SubBasic> resultSet = new PageResultSet<>();
        Page page = PageHelper.offsetPage(subbasicQuery.getOffset(), subbasicQuery.getLimit()).doSelectPage(() -> subbasicMapper.selectByExample(weekend));
        resultSet.setRows(page);
        resultSet.setTotal(page.getTotal());
        return resultSet;
    }

    @Override
    public List<SubBasic> findAll() {
        return subbasicMapper.selectAll();
    }

    @Override
    public void createsubBasic(SubBasic subbasic) {
        subbasicMapper.insertSelective(subbasic);
    }

    @Override
    public void updatesubBasic(SubBasic subbasic) { subbasicMapper.updateByPrimaryKeySelective(subbasic); }

    @Override
    public void deletesubBasic(String subbasicno) { subbasicMapper.deleteByPrimaryKey(subbasicno); }

    @Override
    public int selectOneno(SubBasic subbasic) {
        return subbasicMapper.selectByNo(subbasic);
    }

    @Override
    public int selectOnename(SubBasic subbasic) {
        return subbasicMapper.selectByName(subbasic);
    }

    @Override
    public SubBasic findBySubBasicname(String subbasicname) {
        SubBasic subbasic = new SubBasic();
        subbasic.setSubbasicname(subbasicname);
        subbasicMapper.selectOne(subbasic);
        return subbasicMapper.selectOne(subbasic);
    }

    @Override
    public SubBasic findBySubBasicno(String subbasicno) {
        SubBasic subbasic = new SubBasic();
        subbasic.setSubbasicno(subbasicno);
        subbasicMapper.selectOne(subbasic);
        return subbasicMapper.selectOne(subbasic);
    }


}
