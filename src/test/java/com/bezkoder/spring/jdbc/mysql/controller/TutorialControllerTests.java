package com.bezkoder.spring.jdbc.mysql.controller;

import com.bezkoder.spring.jdbc.mysql.testUtils.TestUtilProvider;
import com.bezkoder.spring.jdbc.mysql.model.Rewards;
import com.bezkoder.spring.jdbc.mysql.model.Transactions;
import com.bezkoder.spring.jdbc.mysql.repository.CustomerRepository;
import com.bezkoder.spring.jdbc.mysql.service.RewardsService;
import com.bezkoder.spring.jdbc.mysql.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class TutorialControllerTests {

    @InjectMocks
    TutorialController tutorialController = new TutorialController();
    @Mock
    CustomerRepository customerRepository;
    @Mock
    RewardsService rewardsService;

    @Mock
    TransactionService transactionService;

    @Test
    void getCustomerRewardsTest() {
        MockitoAnnotations.openMocks(this);
        TestUtilProvider testUtilProvider = new TestUtilProvider();

        when(customerRepository.findByCustomerId(1002L)).thenReturn(testUtilProvider.getCustomer());
        when(rewardsService.getRewardsByCustomerId(1002L)).thenReturn(testUtilProvider.getRewards());

        ResponseEntity<Rewards> rewardResponse = tutorialController.getRewardsByCustomerId(1002L);

        assertNotNull(rewardResponse.getBody());
        assertEquals(rewardResponse.getBody().getCustomerId(), testUtilProvider.getRewards().getCustomerId());
    }

    @Test
    void getCustomerTransactionsTest() {
        MockitoAnnotations.openMocks(this);
        TestUtilProvider testUtilProvider = new TestUtilProvider();

        List<Transactions> transactionsList = new ArrayList<>();
        transactionsList.add(testUtilProvider.getTransactions());

        when(customerRepository.findByCustomerId(1002L)).thenReturn(testUtilProvider.getCustomer());
        when(transactionService.getTransactionsByCustomerId(1002L)).thenReturn(transactionsList);

        ResponseEntity<List<Transactions>> responseEntityList = tutorialController.getTransactionsByCustomerId(1002L);

        assertNotNull(responseEntityList.getBody());
        assertEquals(transactionsList.get(0).getReward(), responseEntityList.getBody().get(0).getReward());
    }
}
