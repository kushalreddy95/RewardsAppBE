package com.bezkoder.spring.jdbc.mysql.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class RewardsTests {

    @Test
    public void rewardsTest(){
        Rewards rewards = new Rewards();
        rewards.setCustomerName("TestName");
        rewards.setTotalRewards(500L);

        assertEquals("TestName", rewards.getCustomerName());
        assertEquals(500L, rewards.getTotalRewards());
    }
}
