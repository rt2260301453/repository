package tech.wetech.admin.modules.system.service.impl;


import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.modules.system.dto.ReplayDto;
import tech.wetech.admin.modules.system.mapper.ReplayMapper;
import tech.wetech.admin.modules.system.mapper.StaffMapper;
import tech.wetech.admin.modules.system.po.Replay;
import tech.wetech.admin.modules.system.po.Staff;
import tech.wetech.admin.modules.system.query.ReplayQuery;
import tech.wetech.admin.modules.system.service.ReplayService;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReplayServiceImpl implements ReplayService {
    @Resource
    private ReplayMapper replayMapper;

    @Resource
    private StaffMapper staffMapper;


    @Override
    public PageResultSet<ReplayDto> findByPage(ReplayQuery replayQuery) {
        System.out.println(replayQuery);
        if(!StringUtils.isEmpty(replayQuery.getOrderBy())) {
            PageHelper.orderBy(replayQuery.getOrderBy());
        }

        Weekend<Replay> example = Weekend.of(Replay.class);
        WeekendCriteria<Replay, Object> criteria = example.weekendCriteria();

        if (!StringUtils.isEmpty(replayQuery.getReplayid())) {
            criteria.andLike(Replay::getReplayid, "%" + replayQuery.getReplayid() + "%");
        }

        if (!StringUtils.isEmpty(replayQuery.getName())) {
            criteria.andLike(Replay::getName, "%" + replayQuery.getName() + "%");
        }
        if (!StringUtils.isEmpty(replayQuery.getReplayofid())) {
            criteria.andLike(Replay::getReplayofid, "%" + replayQuery.getReplayofid() + "%");
        }

        if (!StringUtils.isEmpty(replayQuery.getNameof())) {
            criteria.andLike(Replay::getNameof, "%" + replayQuery.getNameof() + "%");
        }

        List<ReplayDto> dtoList = new ArrayList<>();

        PageHelper.offsetPage(replayQuery.getOffset(), replayQuery.getLimit());
        System.out.println(example);
        replayMapper.selectByExample(example).forEach(u -> {
            ReplayDto dto = new ReplayDto(u);
            dtoList.add(dto);
        });

        long total = replayMapper.selectCountByExample(example);
        PageResultSet<ReplayDto> resultSet = new PageResultSet<>();
        resultSet.setRows(dtoList);
        resultSet.setTotal(total);
        return resultSet;
    }

    @Override
    @Transactional
    public void createStaff(Replay replay) {
        replayMapper.insertSelective(replay);
    }

    @Override
    @Transactional
    public void updatestaff(Replay replay) {
        replayMapper.updateByPrimaryKeySelective(replay);
    }

    @Override
    public Staff queryAllForFormSelect(String replayid) {
        return staffMapper.queryAllRouteForSelect(replayid);
    }

//    @Override
//    public String queryAllForForminput(String replayid) {
//        return staffMapper.querystation(replayid);
//    }

    @Override
    @Transactional
    public void deletereplay(Long id) {
        replayMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int checktime(Replay replay) {
       return replayMapper.checktimeBypid(replay);
    }
}
