package tech.wetech.admin.modules.system.service;

import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.modules.system.dto.AssociatedWidgetsDto;
import tech.wetech.admin.modules.system.dto.SpDateDto;
import tech.wetech.admin.modules.system.po.AssociatedWidgets;
import tech.wetech.admin.modules.system.po.SpDate;
import tech.wetech.admin.modules.system.po.Staff;
import tech.wetech.admin.modules.system.query.AssociatedWidgetsQuery;
import tech.wetech.admin.modules.system.query.SpDateQuery;

import java.util.List;

/**
 * @author  rt
 */
public interface AssociatedWidgetsService {
    /**
     * 新增
     * @param associatedWidgets
     */
    void insertOne(AssociatedWidgets associatedWidgets);

    /**
     *
     * @return
     */
    List<AssociatedWidgets> selectAll();

    PageResultSet<AssociatedWidgetsDto> findByPage(AssociatedWidgetsQuery associatedWidgetsQuery);

    PageResultSet<SpDateDto> findSpDateByPage(SpDateQuery spDateQuery);

    /**
     * 修改
     * @param associatedWidgets
     */
    void updateOne(AssociatedWidgets associatedWidgets);

    /**
     * 删除
     * @param id
     */
    void deleteOne(Long id);

    List<Staff> selectAllStafff();

    Staff selectOneStaff(Staff staff);

    List<SpDate> selectAllSpDate();
}
