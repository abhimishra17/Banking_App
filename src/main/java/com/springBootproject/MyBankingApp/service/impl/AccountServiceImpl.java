package com.springBootproject.MyBankingApp.service.impl;

import com.springBootproject.MyBankingApp.dto.AccountDto;
import com.springBootproject.MyBankingApp.entity.Account;
import com.springBootproject.MyBankingApp.mapper.AccountMapper;
import com.springBootproject.MyBankingApp.repository.AccountRepository;
import com.springBootproject.MyBankingApp.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account= accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account doesnot exist"));
       double total=account.getBalance()+ amount;
       account.setBalance(total);
       Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account doesnot exist"));
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficent Balance");
        }
        double total = account.getBalance() + amount;
        account.setBalance(total);

        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account>accounts=accountRepository.findAll();
        return accounts.stream().map((account)->AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());

    }

}
