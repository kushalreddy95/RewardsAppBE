package com.bezkoder.spring.jdbc.mysql.service;

import com.bezkoder.spring.jdbc.mysql.constants.Constants;
import com.bezkoder.spring.jdbc.mysql.entity.Transaction;
import com.bezkoder.spring.jdbc.mysql.model.Rewards;
import com.bezkoder.spring.jdbc.mysql.repository.CustomerRepository;
import com.bezkoder.spring.jdbc.mysql.repository.TransactionRepository;
import com.bezkoder.spring.jdbc.mysql.testUtils.TestUtilProvider;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class RewardServiceImplTests {

    @InjectMocks
    RewardsServiceImpl rewardsServiceImpl = new RewardsServiceImpl();

    @Mock
    TransactionRepository transactionRepository;

    @Mock
    CustomerRepository customerRepository;


    @Test
    public void rewardServiceImplTests(){
        MockitoAnnotations.openMocks(this);
        TestUtilProvider testUtilProvider = new TestUtilProvider();

        List<Transaction> transactionsList = new ArrayList<>();
        transactionsList.add(testUtilProvider.getTransaction());

        Timestamp lastMonthTimestamp = rewardsServiceImpl.getDateBasedOnOffSetDays(Constants.daysInMonths);
        Timestamp lastSecondMonthTimestamp = rewardsServiceImpl.getDateBasedOnOffSetDays(2*Constants.daysInMonths);
        Timestamp lastThirdMonthTimestamp = rewardsServiceImpl.getDateBasedOnOffSetDays(3*Constants.daysInMonths);

        when(customerRepository.findByCustomerId(1002L)).thenReturn(testUtilProvider.getCustomer());
        when(transactionRepository.findAllByCustomerIdAndTransactionDateBetween(1002L, lastMonthTimestamp,Timestamp.valueOf(LocalDateTime.of(2022,12,31,23,59)))).thenReturn(transactionsList);
        when(transactionRepository.findAllByCustomerIdAndTransactionDateBetween(1002L, lastSecondMonthTimestamp, lastMonthTimestamp)).thenReturn(transactionsList);
        when(transactionRepository.findAllByCustomerIdAndTransactionDateBetween(1002L, lastThirdMonthTimestamp, lastSecondMonthTimestamp)).thenReturn(transactionsList);

        Rewards  rewardsResponse = rewardsServiceImpl.getRewardsByCustomerId(1002L);

        assertEquals(rewardsResponse.getCustomerId(), 1002L);
        assertEquals(rewardsResponse.getTotalRewards(), 2550L);
    }
}
