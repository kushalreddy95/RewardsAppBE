package com.bezkoder.spring.jdbc.mysql.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class CustomerTests {

    @Test
    public void customerNameTest(){
        String name = "TestName";
        Customer customer = new Customer();
        customer.setCustomerName(name);

        assertEquals(name, customer.getCustomerName());
    }
}
