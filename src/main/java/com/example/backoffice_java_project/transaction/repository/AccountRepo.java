package com.example.backoffice_java_project.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backoffice_java_project.transaction.entity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
}
