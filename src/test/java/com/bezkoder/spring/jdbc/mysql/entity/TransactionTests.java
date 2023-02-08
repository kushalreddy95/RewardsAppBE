package com.bezkoder.spring.jdbc.mysql.entity;

import com.bezkoder.spring.jdbc.mysql.model.Transactions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class TransactionTests {

    @Test
    public void transactionTest(){
        Transaction transaction = new Transaction();
        transaction.setTransactionId(20L);
        transaction.setTransactionAmount(500L);
        transaction.setCustomerId(1002L);

        assertEquals(20L, transaction.getTransactionId());
        assertEquals(500L, transaction.getTransactionAmount());
        assertEquals(1002L, transaction.getCustomerId());
    }
}
