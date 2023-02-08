package com.bezkoder.spring.jdbc.mysql.controller;

import java.util.List;
import com.bezkoder.spring.jdbc.mysql.entity.Customer;
import com.bezkoder.spring.jdbc.mysql.model.Rewards;
import com.bezkoder.spring.jdbc.mysql.model.Transactions;
import com.bezkoder.spring.jdbc.mysql.service.RewardsService;
import com.bezkoder.spring.jdbc.mysql.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bezkoder.spring.jdbc.mysql.repository.CustomerRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class TutorialController {


  @Autowired
  RewardsService rewardsService;

  @Autowired
  TransactionService transactionService;

  @Autowired
  CustomerRepository customerRepository;

  @GetMapping(value = "/{customerId}/rewards",produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Rewards> getRewardsByCustomerId(@PathVariable("customerId") Long customerId){
    Customer customer = customerRepository.findByCustomerId(customerId);
    if(customer == null)
    {
      throw new RuntimeException("Invalid / Missing customer Id ");
    }
    Rewards customerRewards = rewardsService.getRewardsByCustomerId(customerId);
    customerRewards.setCustomerName(customer.getCustomerName());
    return new ResponseEntity<>(customerRewards,HttpStatus.OK);
  }

  @GetMapping(value = "/{customerId}/transactions",produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Transactions>> getTransactionsByCustomerId(@PathVariable("customerId") Long customerId){
    Customer customer = customerRepository.findByCustomerId(customerId);
    if(customer == null)
    {
      throw new RuntimeException("Invalid / Missing customer Id ");
    }

    List<Transactions> customerTransactions = transactionService.getTransactionsByCustomerId(customerId);

    return new ResponseEntity<>(customerTransactions,HttpStatus.OK);
  }
}
