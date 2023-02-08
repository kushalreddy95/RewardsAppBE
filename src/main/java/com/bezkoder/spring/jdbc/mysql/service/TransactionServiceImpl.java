package com.bezkoder.spring.jdbc.mysql.service;

import com.bezkoder.spring.jdbc.mysql.constants.Constants;
import com.bezkoder.spring.jdbc.mysql.entity.Transaction;
import com.bezkoder.spring.jdbc.mysql.model.Transactions;
import com.bezkoder.spring.jdbc.mysql.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    RewardsService rewardsService;

    public List<Transactions> getTransactionsByCustomerId(Long customerId) {
        Timestamp lastThirdMonthTimestamp = getDateBasedOnOffSetDays(3*Constants.daysInMonths);
        Timestamp lastNowTimestamp = getDateBasedOnOffSetDays(0);

        List<Transaction> lastThreeMonthTransactions = transactionRepository
                .findAllByCustomerIdAndTransactionDateBetween(customerId, lastThirdMonthTimestamp,
                        lastNowTimestamp);

        List<Transactions> customerTransactions = new ArrayList<Transactions>();

        for(Transaction transaction : lastThreeMonthTransactions){
            Long reward = rewardsService.calculateRewards(transaction);

            Transactions transactionInfo = new Transactions();
            transactionInfo.setTransaction(transaction);
            transactionInfo.setRewards(reward);
            customerTransactions.add(transactionInfo);
        }

        return customerTransactions;
    }

    public Timestamp getDateBasedOnOffSetDays(int days) {

        return Timestamp.valueOf(LocalDateTime.of(2022,12,31,23,59).minusDays(days));
    }
}
