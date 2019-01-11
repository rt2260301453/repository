package tech.wetech.admin.modules.system.mapper;

import org.apache.ibatis.annotations.Select;
import tech.wetech.admin.core.utils.MyMapper;
import tech.wetech.admin.modules.system.po.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerMapper extends MyMapper<Customer> {

    @Select(value = "select * from customer where customerno=#{customerno}")
    Customer selectOneByNo(String customerno);

    @Select(value = "select customerno as \"id\",customeraddress as \"text\" " +
            "from customer where customeraddress like '%${customeraddress}%'")
    List<Map<String, Object>> findByCondition(Customer customer);
}