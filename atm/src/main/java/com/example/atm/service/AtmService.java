package com.example.atm.service;

import com.example.atm.model.DepositRequest;
import com.example.atm.model.TransactionResult;
import com.example.atm.model.WithdrawRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AtmService {

    private RestTemplate restTemplate = new RestTemplate();

    public TransactionResult withdraw(String username, int withdrawalAmount) {
        WithdrawRequest request = new WithdrawRequest();
        request.setUsername(username);
        request.setWithdrawal(withdrawalAmount);
        String url = "http://172.21.0.2:8082/subtractFunds/" + request.getUsername() + "/" + request.getWithdrawal();
        TransactionResult result = restTemplate.getForObject(url, TransactionResult.class);
        return result;
    }

    public TransactionResult deposit(String username, int depositAmount) {
        DepositRequest request = new DepositRequest();
        request.setUsername(username);
        request.setDeposit(depositAmount);
        String url = "http://172.21.0.2:8082/addFunds/" + request.getUsername() + "/" + request.getDeposit();
        TransactionResult result = restTemplate.getForObject(url, TransactionResult.class);
        return result;
    }
}
