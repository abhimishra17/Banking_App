package com.springBootproject.MyBankingApp.service;

import com.springBootproject.MyBankingApp.dto.AccountDto;

import java.util.List;

public interface AccountService {
   AccountDto createAccount(AccountDto accountDto);
   AccountDto getAccountById(Long id);
   AccountDto deposit(Long id,double amount);
   AccountDto withdraw(Long id,double amount);
   List<AccountDto>getAllAccounts();
}