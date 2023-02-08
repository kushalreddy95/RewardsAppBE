package com.bezkoder.spring.jdbc.mysql.entity;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private Long customerId;
    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName (String customerName){ this.customerName = customerName; }

}
