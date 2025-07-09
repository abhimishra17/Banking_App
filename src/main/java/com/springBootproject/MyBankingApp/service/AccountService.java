package com.springBootproject.MyBankingApp.service;

import com.springBootproject.MyBankingApp.dto.AccountDto;

public interface AccountService {
   AccountDto createAccount(AccountDto accountDto);
   AccountDto getAccountById(Long id);
}