package com.bezkoder.spring.jdbc.mysql.service;

import com.bezkoder.spring.jdbc.mysql.entity.Transaction;
import com.bezkoder.spring.jdbc.mysql.model.Rewards;

public interface RewardsService {
    public Rewards getRewardsByCustomerId(Long customerId);

    public Long calculateRewards(Transaction transaction);
}
