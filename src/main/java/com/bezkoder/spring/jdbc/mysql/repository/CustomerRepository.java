package com.bezkoder.spring.jdbc.mysql.repository;

import com.bezkoder.spring.jdbc.mysql.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
    public Customer findByCustomerId(Long customerId);
}
