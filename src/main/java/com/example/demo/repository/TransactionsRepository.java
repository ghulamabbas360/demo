package com.example.demo.repository;


import com.example.demo.models.Transactions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface TransactionsRepository extends CrudRepository<Transactions, Long> {

    /**
     * Returns the sum of the amounts of all transactions
     */

    @Query(value = "select sum(amount) from transactions t", nativeQuery = true)

    public double getTotalTransactionAmount();


    /**
     * Returns the sum of the amounts of all transactions sent by the specified client
     */

    @Query(value = "select sum(amount) as total from transactions t where t.sender_full_name= :name", nativeQuery = true)


    public Double getTotalTransactionAmountSentBy(@Param("name") String name);

    /**
     * Returns the highest transaction amount
     */
    @Query(value = "select max(amount) from transactions t;", nativeQuery = true)
    public float getMaxTransactionAmount();


    /**
     * Counts the number of unique clients that sent or received a transaction
     */
    @Query(value = "select distinct count(id) as total from transactions t where t.issue_solved='true';", nativeQuery = true)
    public long countUniqueClients();


    /**
     * Returns whether a client (sender or beneficiary) has at least one transaction with a compliance
     * issue that has not been solved
     */

    @Query(value = "select count(id) as TOTAL, sender_full_name,beneficiary_full_name from transactions t where t.issueSolved='false' and t.senderFullName= :clientFullName;", nativeQuery = true)
    public boolean hasOpenComplianceIssues(@Param("clientFullName") String clientFullName);


    /**
     * Returns all transactions indexed by beneficiary name
     */

    @Query(value = "select *from transactions t order by t.beneficiary_full_name;", nativeQuery = true)

    public List<Transactions> getTransactionsByBeneficiaryName();


    /**
     * Returns the identifiers of all open compliance issues
     */

    @Query(value = "select issue_Id from transactions t where t.issue_solved='false';", nativeQuery = true)
    public Set<Integer> getUnsolvedIssueIds();


    /**
     * Returns a list of all solved issue messages
     */
    @Query(value = "select issue_message from transactions t where t.issue_solved='true';", nativeQuery = true)
    public List<String> getAllSolvedIssueMessages();


    /**
     * Returns the 3 transactions with highest amount sorted by amount descending
     */
    @Query(value = "select *from transactions t order by t.amount desc limit 3;", nativeQuery = true)
    public List<Transactions> getTop3TransactionsByAmount();


    /**
     * Returns the sender with the most total sent amount
     */
    @Query(value = "select count(amount) as total,sender_full_name from transactions t where t.issue_solved='true' order by t.amount desc;", nativeQuery = true)
    public Optional<Object> getTopSender();
}
