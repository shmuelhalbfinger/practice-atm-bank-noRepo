package com.example.bank.service;

import com.example.bank.model.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AccountService {
    private Account account;

    private RestTemplate restTemplate = new RestTemplate();

    public CreateAccountResult createAccount(String name, int initialAccountBalance) {
        account = new Account();
        CreateAccountRequest request = new CreateAccountRequest();
        request.setName(name);
        request.setInitialAccountBalance(initialAccountBalance);
        account.setName(request.getName());
        account.setAccountBalance(request.getInitialAccountBalance());
        CreateAccountResult result = new CreateAccountResult();
        result.setName(account.getName());
        result.setAccountBalance(account.getAccountBalance());
        return result;
    }

    public EditAccountResult editAccount(String editName) {
        EditAccountRequest request = new EditAccountRequest();
        request.setEditName(editName);
        account.setName(request.getEditName());
        EditAccountResult result = new EditAccountResult();
        result.setEditName(account.getName());
        return result;
    }

    public ViewAccountResult viewAccount() {
        ViewAccountRequest request = new ViewAccountRequest();
        request.setName(account.getName());
        request.setAccountBalance(account.getAccountBalance());

        ViewAccountResult result = new ViewAccountResult();
        result.setName(request.getName());
        result.setAccountBalance(request.getAccountBalance());
        return result;
    }

    public AddFundsResult addFunds(int depositAmount) {
        AddFundsRequest request = new AddFundsRequest();
        request.setDepositAmount(depositAmount);
        account.setAccountBalance(account.getAccountBalance()-request.getDepositAmount());
        AddFundsResult result = new AddFundsResult();
        result.setResultBalance(account.getAccountBalance());
        return result;
    }

    public SubtractFundsResult subtractFunds(int withdrawalAmount) {
        SubtractFundsRequest request = new SubtractFundsRequest();
        request.setWithdrawalAmount(withdrawalAmount);
        account.setAccountBalance(account.getAccountBalance()-request.getWithdrawalAmount());
        SubtractFundsResult result = new SubtractFundsResult();
        result.setResultBalance(account.getAccountBalance());
        return result;
    }
}
