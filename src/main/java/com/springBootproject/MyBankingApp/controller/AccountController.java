package com.springBootproject.MyBankingApp.controller;

import com.springBootproject.MyBankingApp.dto.AccountDto;
import com.springBootproject.MyBankingApp.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;
    public AccountController(AccountService accountService){
        this.accountService=accountService;
    }

    //add account rest api
    @PostMapping
    public ResponseEntity<AccountDto>addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

   //Get Account REST API
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto>getAccountbyId(@PathVariable Long id){
        AccountDto accountDto=accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    //Deposit REST API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto>deposit(@PathVariable Long id,Map<String,Double>request){
        Double amount=request.get("amount");
        AccountDto accountDto=accountService.deposit(id,amount);
        return ResponseEntity.ok(accountDto);
    }
    //withdraw rest api
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto>withdraw(@PathVariable Long id,Map<String,Double>request){
        Double amount=request.get("amount");
        AccountDto accountDto=accountService.withdraw(id,amount);
        return ResponseEntity.ok(accountDto);
    }
    //get all account api
    @GetMapping()
    public ResponseEntity<List<AccountDto>>getAllAccount(){
       List<AccountDto>accounts= accountService.getAllAccounts();
       return ResponseEntity.ok(accounts);
    }

}

