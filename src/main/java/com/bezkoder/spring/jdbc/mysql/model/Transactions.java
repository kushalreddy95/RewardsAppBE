package com.bezkoder.spring.jdbc.mysql.model;

import com.bezkoder.spring.jdbc.mysql.entity.Transaction;

import java.sql.Timestamp;
import java.util.List;

public class Transactions {

    private Transaction transaction;
    private Long reward;

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Long getReward() {
        return reward;
    }

    public void setRewards(Long reward) {
        this.reward = reward;
    }


}
