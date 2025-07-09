package com.springBootproject.MyBankingApp.repository;

import com.springBootproject.MyBankingApp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {

}
