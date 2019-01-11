package tech.wetech.admin.modules.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.admin.modules.system.mapper.CustomerMapper;
import tech.wetech.admin.modules.system.po.Customer;
import tech.wetech.admin.modules.system.service.CustomerService;

import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public Customer findOne(String customerno) {
        return customerMapper.selectOneByNo(customerno);
    }

    @Override
    public List<Map<String, Object>> findByCondition(Customer customer) {
        System.out.println("cityname="+customer.getCustomeraddress());
        return customerMapper.findByCondition(customer);
    }
}
