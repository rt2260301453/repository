package tech.wetech.admin.modules.system.service;

import tech.wetech.admin.core.utils.PageResultSet;
import tech.wetech.admin.modules.system.dto.AssociatedAddressDto;
import tech.wetech.admin.modules.system.po.AssociatedAddress;
import tech.wetech.admin.modules.system.query.AssociatedAddressQuery;

import java.util.List;

/**
 * @author  rt
 */
public interface AssociatedAddressService {
    /**
     * 新增
     * @param associatedAddress
     */
    void insertOne(AssociatedAddress associatedAddress);

    /**
     *
     * @return
     */
    List<AssociatedAddress> selectAll();

    List<AssociatedAddress> selectByCondition(AssociatedAddress associatedAddress);

    PageResultSet<AssociatedAddressDto> findByPage(AssociatedAddressQuery associatedAddressQuery);

    /**
     * 修改
     * @param associatedAddress
     */
    void updateOne(AssociatedAddress associatedAddress);

    /**
     * 删除
     * @param id
     */
    void deleteOne(Long id);
}
