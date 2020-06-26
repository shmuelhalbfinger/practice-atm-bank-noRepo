package com.example.bank.service;

import com.example.bank.model.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class AccountService {
    private HashMap<String,Account> accounts = new HashMap<>();

    private RestTemplate restTemplate = new RestTemplate();

    public CreateAccountResult createAccount(String username, String name, int initialAccountBalance) {
        Account account = new Account();
        CreateAccountRequest request = new CreateAccountRequest();
        request.setUsername(username);
        request.setName(name);
        request.setInitialAccountBalance(initialAccountBalance);
        account.setUsername(request.getUsername());
        account.setName(request.getName());
        account.setAccountBalance(request.getInitialAccountBalance());
        CreateAccountResult result = new CreateAccountResult();
        result.setUsername(account.getUsername());
        result.setName(account.getName());
        result.setAccountBalance(account.getAccountBalance());
        accounts.put(account.getUsername(), account);
        return result;
    }

    public EditAccountResult editAccount(String username, String editName) {
        EditAccountRequest request = new EditAccountRequest();
        request.setEditName(editName);
        accounts.get(username).setName(editName);
        EditAccountResult result = new EditAccountResult();
        result.setEditName(accounts.get(username).getName());
        return result;
    }

    public ViewAccountResult viewAccount(String username) {
        ViewAccountRequest request = new ViewAccountRequest();
        request.setUsername(accounts.get(username).getUsername());
        request.setName(accounts.get(username).getName());
        request.setAccountBalance(accounts.get(username).getAccountBalance());
        ViewAccountResult result = new ViewAccountResult();
        result.setUsername(request.getUsername());
        result.setName(request.getName());
        result.setAccountBalance(request.getAccountBalance());
        return result;
    }

    public AddFundsResult addFunds(String username, int depositAmount) {
        AddFundsRequest request = new AddFundsRequest();
        request.setDepositAmount(depositAmount);
        accounts.get(username).setAccountBalance(accounts.get(username).getAccountBalance()-request.getDepositAmount());
        AddFundsResult result = new AddFundsResult();
        result.setResultBalance(accounts.get(username).getAccountBalance());
        return result;
    }

    public SubtractFundsResult subtractFunds(String username, int withdrawalAmount) {
        SubtractFundsRequest request = new SubtractFundsRequest();
        request.setWithdrawalAmount(withdrawalAmount);
        accounts.get(username).setAccountBalance(accounts.get(username).getAccountBalance()-request.getWithdrawalAmount());
        SubtractFundsResult result = new SubtractFundsResult();
        result.setResultBalance(accounts.get(username).getAccountBalance());
        return result;
    }

    public ViewAllAccountsResult viewAllAccounts() {
        ViewAllAccountsResult result = new ViewAllAccountsResult();
        result.setAccounts(accounts.values());
        return result;
    }
}
