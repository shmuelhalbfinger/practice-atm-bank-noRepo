package com.example.atm.service;

import com.example.atm.model.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;

@Service
public class AtmService {
    private Account account;
    private Scanner scan = new Scanner(System.in);

    private RestTemplate restTemplate = new RestTemplate();


    public GetAccountResult getAccount() {

        String getAccountUrl= "http://127.0.0.1:8082/viewAccount";

        account = restTemplate.getForObject(getAccountUrl, Account.class);

        GetAccountResult result = new GetAccountResult();

        result.setName(account.getName());
        result.setAccountBalance(account.getAccountBalance());
        return result;
    }

    public TransactionResult withdraw(int withdrawalAmount) {
        WithdrawRequest request = new WithdrawRequest();
        request.setWithdrawal(withdrawalAmount);
        account.setAccountBalance(account.getAccountBalance()-request.getWithdrawal());
        TransactionResult result = new TransactionResult();
        result.setResultBalance(account.getAccountBalance());
        return result;
    }

    public TransactionResult deposit(int depositAmount) {
        DepositRequest request = new DepositRequest();
        request.setDeposit(depositAmount);
        account.setAccountBalance(account.getAccountBalance() + request.getDeposit());
        TransactionResult result = new TransactionResult();
        result.setResultBalance(account.getAccountBalance());
        return result;
    }

    public TransactionResult sendUpdate() {
        TransactionResult result = new TransactionResult();
        result.setResultBalance(account.getAccountBalance());
        return result;
    }

    public String sayHello() {
        return "Hi!";
    }
}
