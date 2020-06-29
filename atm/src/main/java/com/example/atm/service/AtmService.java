package com.example.atm.service;

import com.example.atm.model.DepositRequest;
import com.example.atm.model.TransactionResult;
import com.example.atm.model.WithdrawRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AtmService {

    private final RestTemplate restTemplate = new RestTemplate();

    public TransactionResult withdraw(String username, int withdrawalAmount) {
        WithdrawRequest request = new WithdrawRequest();
        request.setUsername(username);
        request.setWithdrawal(withdrawalAmount);
        HttpHeaders headers = new HttpHeaders();
        headers.set("username", username);
        headers.set("withdrawalAmount", String.valueOf(withdrawalAmount));
        HttpEntity<String> entityRequest = new HttpEntity<>(headers);
        String url = "http://172.21.0.2:8082/subtractFunds";
        TransactionResult result = restTemplate.postForObject(url, entityRequest, TransactionResult.class);
        return result;
    }

    public TransactionResult deposit(String username, int depositAmount) {
        DepositRequest request = new DepositRequest();
        request.setUsername(username);
        request.setDeposit(depositAmount);
        HttpHeaders headers = new HttpHeaders();
        headers.set("username", username);
        headers.set("withdrawalAmount", String.valueOf(depositAmount));
        HttpEntity<String> entityRequest = new HttpEntity<>(headers);
        String url = "http://172.21.0.2:8082/addFunds";
        TransactionResult result = restTemplate.postForObject(url, entityRequest, TransactionResult.class);
        return result;
    }
}
