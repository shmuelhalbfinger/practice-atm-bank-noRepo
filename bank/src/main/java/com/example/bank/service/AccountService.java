package com.example.bank.service;

import com.example.bank.exceptionhandler.AccountNotFoundException;
import com.example.bank.exceptionhandler.DuplicateAccountException;
import com.example.bank.exceptionhandler.ImproperBalanceException;
import com.example.bank.model.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AccountService {
    private final HashMap<String, Account> accounts = new HashMap<>();

    public CreateAccountResult createAccount(CreateAccountRequest request) throws DuplicateAccountException {
        if (accounts.containsKey(request.getUsername()))
            throw new DuplicateAccountException("Account with this username already exists");
        Account account = new Account();
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

    public EditAccountResult editAccount(EditAccountRequest request) throws AccountNotFoundException {
        if (!accounts.containsKey(request.getUsername()))
            throw new AccountNotFoundException("Account with this username doesn't exist");
        accounts.get(request.getUsername()).setName(request.getEditName());
        EditAccountResult result = new EditAccountResult();
        result.setEditName(accounts.get(request.getUsername()).getName());
        return result;
    }

    public ViewAccountResult viewAccount(ViewAccountRequest request) throws AccountNotFoundException {
        if (!accounts.containsKey(request.getUsername()))
            throw new AccountNotFoundException("Account with this username doesn't exist");
        ViewAccountResult result = new ViewAccountResult();
        result.setUsername(accounts.get(request.getUsername()).getUsername());
        result.setName(accounts.get(request.getUsername()).getName());
        result.setAccountBalance(accounts.get(request.getUsername()).getAccountBalance());
        return result;
    }

    public AddFundsResult addFunds(AddFundsRequest request) throws AccountNotFoundException {
        if (!accounts.containsKey(request.getUsername()))
            throw new AccountNotFoundException("Account with this username doesn't exist");
        accounts.get(request.getUsername()).setAccountBalance(accounts.get(request.getUsername()).getAccountBalance() + request.getDepositAmount());
        AddFundsResult result = new AddFundsResult();
        result.setResultBalance(accounts.get(request.getUsername()).getAccountBalance());
        return result;
    }

    public SubtractFundsResult subtractFunds(SubtractFundsRequest request) throws AccountNotFoundException, ImproperBalanceException {
        if (!accounts.containsKey(request.getUsername()))
            throw new AccountNotFoundException("Account with this username doesn't exist");
        if (accounts.get(request.getUsername()).getAccountBalance() - request.getWithdrawalAmount() < 0)
            throw new ImproperBalanceException("Withdrawal Amount exceeds current balance of " + accounts.get(request.getUsername()).getAccountBalance() + ". Please add more funds to withdraw this amount");
        accounts.get(request.getUsername()).setAccountBalance(accounts.get(request.getUsername()).getAccountBalance() - request.getWithdrawalAmount());
        SubtractFundsResult result = new SubtractFundsResult();
        result.setResultBalance(accounts.get(request.getUsername()).getAccountBalance());
        return result;
    }

    public ViewAllAccountsResult viewAllAccounts() {
        ViewAllAccountsResult result = new ViewAllAccountsResult();
        result.setAccounts(accounts.values());
        return result;
    }

    public DeleteAccountResult deleteAccount(DeleteAccountRequest request) throws AccountNotFoundException {
        if (!accounts.containsKey(request.getDeleteUsername()))
            throw new AccountNotFoundException("Account with this username doesn't exist");
        DeleteAccountResult result = new DeleteAccountResult();
        result.setDeletedAccountUsername(accounts.get(request.getDeleteUsername()).getUsername());
        accounts.remove(request.getDeleteUsername());
        return result;
    }
}
