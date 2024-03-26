package com.example.demo.service;


import com.example.demo.models.Transactions;
import com.example.demo.repository.TransactionsRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class TransactionModelService {


    private final TransactionsRepository transactionsRepository;

    public TransactionModelService(TransactionsRepository transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }

    /**
     * Returns the sum of the amounts of all transactions
     */
    public double getTotalTransactionAmount() {
        double sum = 0;
        try {
            sum = transactionsRepository.getTotalTransactionAmount();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sum;

    }

    /**
     * Returns the sum of the amounts of all transactions sent by the specified client
     */
    public Double getTotalTransactionAmountSentBy(String senderFullName) {
        Double sum = (double) 0;

        try {
            sum = transactionsRepository.getTotalTransactionAmountSentBy(senderFullName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    /**
     * Returns the highest transaction amount
     */
    public double getMaxTransactionAmount() {
        double highestAmountOfTransaction = 0;
        try {
            highestAmountOfTransaction = transactionsRepository.getMaxTransactionAmount();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return highestAmountOfTransaction;

    }

    /**
     * Counts the number of unique clients that sent or received a transaction
     */
    public long countUniqueClients() {

        long countUniqueClients = 0;
        try {
            countUniqueClients = transactionsRepository.countUniqueClients();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return countUniqueClients;

    }


    /**
     * Returns whether a client (sender or beneficiary) has at least one transaction with a compliance
     * issue that has not been solved
     */

    public boolean hasOpenComplianceIssues(@Param("clientFullName") String clientFullName) {
        boolean issueSolved = false;

        try {
            issueSolved = transactionsRepository.hasOpenComplianceIssues(clientFullName);
            if (issueSolved) {
                issueSolved = true;
            }
        } catch (Exception e) {

        }
        return issueSolved;
    }

    /**
     * Returns all transactions indexed by beneficiary name
     */
    public List<Transactions> getTransactionsByBeneficiaryName() {
        List<Transactions> transactionsDtos = null;
        try {

            transactionsDtos = transactionsRepository.getTransactionsByBeneficiaryName();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return transactionsDtos;
    }


    /**
     * Returns the identifiers of all open compliance issues
     */

    public Set<Integer> getUnsolvedIssueIds() {
        Set<Integer> set = null;
        try {
            set = transactionsRepository.getUnsolvedIssueIds();
        } catch (Exception e) {
            e.printStackTrace();
            ;
        }
        return set;
    }


    /**
     * Returns a list of all solved issue messages
     */
    public List<String> getAllSolvedIssueMessages() {
        List<String> list = null;
        try {
            list = transactionsRepository.getAllSolvedIssueMessages();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * Returns the 3 transactions with highest amount sorted by amount descending
     */
    public List<Transactions> getTop3TransactionsByAmount() {
        List<Transactions> list = null;

        try {

            list = transactionsRepository.getTop3TransactionsByAmount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Optional<Object> getTopSender() {
        Object o = null;
        try {
            o = transactionsRepository.getTopSender();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (Optional<Object>) o;
    }
}

