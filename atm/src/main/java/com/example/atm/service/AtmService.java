package com.example.atm.service;

import com.example.atm.model.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;

@Service
public class AtmService {

    private RestTemplate restTemplate = new RestTemplate();

    public TransactionResult withdraw(int withdrawalAmount) {
        WithdrawRequest request = new WithdrawRequest();
        request.setWithdrawal(withdrawalAmount);
        String url = "http://localhost:8082/subtractFunds/" + request.getWithdrawal();
        TransactionResult result = restTemplate.getForObject(url, TransactionResult.class);
        return result;
    }

    public TransactionResult deposit(int depositAmount) {
        DepositRequest request = new DepositRequest();
        request.setDeposit(depositAmount);
        String url = "http://localhost:8082/addFunds/" + request.getDeposit();
        TransactionResult result = restTemplate.getForObject(url, TransactionResult.class);
        return result;
    }
}
