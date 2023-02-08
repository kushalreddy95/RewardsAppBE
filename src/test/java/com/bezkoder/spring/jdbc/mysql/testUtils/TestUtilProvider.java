package com.bezkoder.spring.jdbc.mysql.testUtils;

import com.bezkoder.spring.jdbc.mysql.entity.Customer;
import com.bezkoder.spring.jdbc.mysql.model.Rewards;
import com.bezkoder.spring.jdbc.mysql.model.Transactions;
import com.bezkoder.spring.jdbc.mysql.entity.Transaction;

public class TestUtilProvider {

    Customer customer;
    Rewards rewards;
    Transaction transaction;
    Transactions transactions;

    public Customer getCustomer(){
        customer = new Customer();
        customer.setCustomerName("TestName");
        return customer;
    }

    public Rewards getRewards(){
        rewards = new Rewards();
        rewards.setTotalRewards(1000L);
        rewards.setLastThirdMonthRewardPoints(500L);
        rewards.setLastSecondMonthRewardPoints(300L);
        rewards.setLastMonthRewardPoints(200L);
        rewards.setCustomerId(1002L);
        rewards.setCustomerName("TestName");
        return rewards;
    }

    public Transaction getTransaction() {
        transaction = new Transaction();
        transaction.setTransactionId(1000L);
        transaction.setTransactionAmount(500L);
        transaction.setCustomerId(1002L);
        return transaction;
    }

    public Transactions getTransactions(){
        transactions = new Transactions();
        transactions.setRewards(500L);
        transactions.setTransaction(transaction);
        return transactions;
    }



}
