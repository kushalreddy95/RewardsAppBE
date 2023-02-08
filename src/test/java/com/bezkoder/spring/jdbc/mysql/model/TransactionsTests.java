package com.bezkoder.spring.jdbc.mysql.model;

import com.bezkoder.spring.jdbc.mysql.entity.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class TransactionsTests {

    @Test
    public void transactionsTests(){
        Transaction transaction = new Transaction();
        transaction.setTransactionId(20L);

        Transactions transactions = new Transactions();
        transactions.setTransaction(transaction);
        transactions.setRewards(90L);

        assertEquals(20L, transactions.getTransaction().getTransactionId());
        assertEquals(90L, transactions.getReward());
    }
}
