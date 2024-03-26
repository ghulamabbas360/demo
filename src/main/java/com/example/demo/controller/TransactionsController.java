package com.example.demo.controller;


import com.example.demo.models.Transactions;
import com.example.demo.service.TransactionModelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TransactionsController {

    private HashMap<Object, Object> map;
    private final TransactionModelService transactionModelService;

    public TransactionsController(TransactionModelService transactionModelService) {
        this.transactionModelService = transactionModelService;
    }

    @GetMapping("/get-All-transactions-sum")
    public Map<Object, Object> getAllTransactionsSum() {
        map = new HashMap<>();
        map.put("sum of transactions is", transactionModelService.getTotalTransactionAmount());
        return map;
    }


    @GetMapping("/get-All-transactions-sum-by-specified-client")
    public Map<Object, Object> getAllTransactionsSumBySpecifiedClient(@RequestParam("name") String name) {
        map = new HashMap<>();
        map.put("sum of transactions by specified Client", transactionModelService.getTotalTransactionAmountSentBy(name));
        return map;
    }


    @GetMapping("get-Max-Transaction-Amount")
    public Map<Object, Object> getMaxTransactionAmount() {
        map = new HashMap<>();
        map.put("Max Transaction Amount is", transactionModelService.getMaxTransactionAmount());
        return map;
    }


    @GetMapping("count-unique-clients")
    public Map<Object, Object> countUniqueClients() {
        map = new HashMap<>();
        map.put("Unique clients who has sent and recieve transaction", transactionModelService.countUniqueClients());
        return map;
    }


    @GetMapping("/has-open-Compliance-Issues")
    public Map<Object, Object> hasOpenComplianceIssues(@RequestParam("clientFullName") String clientFullName) {
        map = new HashMap<>();
        map.put("sender's name:", clientFullName);
        map.put("is issue solved", transactionModelService.hasOpenComplianceIssues(clientFullName));
        return map;
    }


    @GetMapping("/get-transactions-by-beneficiary-name")
    public Map<Object, Object> getTransactionsByBeneficiaryName() {
        map = new HashMap<>();
        map.put("transactions by beneficiary Names", transactionModelService.getTransactionsByBeneficiaryName());
        return map;
    }


    @GetMapping("/get-unsolved-issued_Ids")
    public Map<Object, Object> getUnsolvedIssueIds() {
        map = new HashMap<>();
        map.put("unsolved issue ids", transactionModelService.getUnsolvedIssueIds());
        return map;
    }

    @GetMapping("/get-all-solved-issue-messages")
    public Map<Object, Object> getAllSolvedIssueMessages() {
        map = new HashMap<>();
        map.put("all solved issues messages", transactionModelService.getAllSolvedIssueMessages());
        return map;
    }

    @GetMapping("/get-top3-transactions-by-amount")
    public Map<Object, Object> getTop3TransactionsByAmount() {
        map = new HashMap<>();
        map.put("top 3 transactions by amount ", transactionModelService.getTop3TransactionsByAmount());
        return map;
    }

    @GetMapping("/get-top-sender")
    public Map<Object, Object> getTopSender() {

        map = new HashMap<>();
        map.put("top sender", transactionModelService.getTopSender());
        return map;
    }
}
