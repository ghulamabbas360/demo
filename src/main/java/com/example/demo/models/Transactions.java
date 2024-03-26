package com.example.demo.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "transactions")
@Data
public class Transactions implements Serializable {
    @Column(name = "mtn")
    private Long mtn;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "sender_full_name")
    private String senderFullName;

    @Column(name = "sender_age")
    private Integer senderAge;

    @Column(name = "beneficiary_full_name")
    private String beneficiaryFullName;

    @Column(name = "beneficiary_age")
    private Integer beneficiaryAge;

    @Column(name = "issue_Id")
    private Integer issueId;

    @Column(name = "issue_solved")
    private Boolean issueSolved;

    @Column(name = "issue_message")
    private String issueMessage;
    @Id
    private Long id;


}
