package com.example.backoffice_java_project.transaction.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "MASTER_USER_COBA", schema = "BACKOFFICE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MASTER_USER_COBA_SEQ")
    @SequenceGenerator(name = "MASTER_USER_COBA_SEQ", initialValue = 1, allocationSize = 1, sequenceName = "MASTER_USER_COBA_SEQ", schema = "BACKOFFICE")
    private Long id;

    @Column(name = "FULL_NAME", nullable = false)
    private String fullName;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference 
    private List<Account> accounts;
}
