package com.bezkoder.spring.jdbc.mysql.service;

import com.bezkoder.spring.jdbc.mysql.constants.Constants;
import com.bezkoder.spring.jdbc.mysql.entity.Transaction;
import com.bezkoder.spring.jdbc.mysql.model.Transactions;
import com.bezkoder.spring.jdbc.mysql.repository.TransactionRepository;
import com.bezkoder.spring.jdbc.mysql.testUtils.TestUtilProvider;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceImplTests {

    @InjectMocks
    TransactionServiceImpl transactionServiceImpl = new TransactionServiceImpl();
    @Mock
    TransactionRepository transactionRepository;
    @Mock
    RewardsService rewardsService;

    @Test
    public void transactionServiceImplTests(){
        MockitoAnnotations.openMocks(this);
        TestUtilProvider testUtilProvider = new TestUtilProvider();

        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(testUtilProvider.getTransaction());

        Timestamp lastThirdMonthTimestamp = transactionServiceImpl.getDateBasedOnOffSetDays(3* Constants.daysInMonths);
        Timestamp lastNowTimestamp = transactionServiceImpl.getDateBasedOnOffSetDays(0);

        when(transactionRepository
                .findAllByCustomerIdAndTransactionDateBetween(1002L, lastThirdMonthTimestamp,
                        lastNowTimestamp)).thenReturn(transactionList);
        when(rewardsService.calculateRewards(testUtilProvider.getTransaction())).thenReturn(500L);

        List<Transactions> transactionsList = transactionServiceImpl.getTransactionsByCustomerId(1002L);

        assertEquals(transactionsList.get(0).getTransaction().getTransactionId(), testUtilProvider.getTransaction().getTransactionId());


    }
}
