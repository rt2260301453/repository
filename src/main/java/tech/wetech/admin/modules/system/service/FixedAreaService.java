package tech.wetech.admin.modules.system.service;

import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.modules.system.dto.FixedAreaDto;
import tech.wetech.admin.modules.system.po.FixedArea;
import tech.wetech.admin.modules.system.query.FixedAreaQuery;

import java.util.List;

/**
 * @author  rt
 */
public interface FixedAreaService {
    /**
     * 新增
     * @param fixedArea
     */
    void insertOne(FixedArea fixedArea);

    /**
     *
     * @return
     */
    List<FixedArea> selectAll();

    PageResultSet<FixedAreaDto> findByPage(FixedAreaQuery fixedAreaQuery);

    /**
     * 1
     * @param fixedArea
     * @return
     */
    int selectOne(FixedArea fixedArea);

    /**
     * 修改
     * @param fixedArea
     */
    void updateOne(FixedArea fixedArea);

    /**
     * 删除
     * @param id
     */
    void deleteOne(Long id);
}
