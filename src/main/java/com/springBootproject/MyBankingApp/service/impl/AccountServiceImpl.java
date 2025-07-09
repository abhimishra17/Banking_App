package com.springBootproject.MyBankingApp.service.impl;

import com.springBootproject.MyBankingApp.dto.AccountDto;
import com.springBootproject.MyBankingApp.entity.Account;
import com.springBootproject.MyBankingApp.mapper.AccountMapper;
import com.springBootproject.MyBankingApp.repository.AccountRepository;
import com.springBootproject.MyBankingApp.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account= AccountMapper.mapToAccount(accountDto);
        Account savedAccount =accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);

    }

    @Override
    public AccountDto getAccountById(Long id) {
       Account account= accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account doesnot exist"));
        return AccountMapper.mapToAccountDto(account);
    }


}
