package com.example.backoffice_java_project.transaction.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "MASTER_ACCOUNT_COBA", schema = "BACKOFFICE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MASTER_ACCOUNT_COBA_SEQ")
    @SequenceGenerator(name = "MASTER_ACCOUNT_COBA_SEQ", initialValue = 1, allocationSize = 1, sequenceName = "MASTER_ACCOUNT_COBA_SEQ", schema = "BACKOFFICE")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    @JsonBackReference
    private User user;

    @Column(name = "BALANCE", nullable = false)
    private Double balance;

    @Column(name = "ACCOUNT_TYPE")
    private String accountType;
}
