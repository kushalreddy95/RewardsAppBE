package com.bezkoder.spring.jdbc.mysql.service;

import com.bezkoder.spring.jdbc.mysql.model.Transactions;

import java.util.List;

public interface TransactionService {

    public List<Transactions> getTransactionsByCustomerId(Long customerId);
}
