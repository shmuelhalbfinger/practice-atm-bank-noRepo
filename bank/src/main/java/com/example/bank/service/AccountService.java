package com.example.bank.service;

import com.example.bank.model.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
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

    public UpdateAccountResult updateAccount() {
        String updateAccountUrl = "http://127.0.0.1:8080/sendUpdate";

        UpdateAccountRequest request = restTemplate.getForObject(updateAccountUrl, UpdateAccountRequest.class);

        account.setAccountBalance(request.getResultBalance());

        UpdateAccountResult result = new UpdateAccountResult();
        result.setResultBalance(account.getAccountBalance());
        return result;
    }
}
