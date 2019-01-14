package tech.wetech.admin.modules.system.service;

import org.apache.ibatis.annotations.Select;
import tech.wetech.admin.modules.system.po.AssociatedAddress;
import tech.wetech.admin.modules.system.po.Customer;

import java.util.List;
import java.util.Map;

/**
 * @author cjbi
 */
public interface CustomerService {

    Customer findOne(String customerno);

    List<Map<String, Object>> findByCondition(Customer customer);
}
