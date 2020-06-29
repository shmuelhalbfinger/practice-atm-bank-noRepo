package com.example.bank.controller;

import com.example.bank.exceptionhandler.AccountNotFoundException;
import com.example.bank.exceptionhandler.DuplicateAccountException;
import com.example.bank.exceptionhandler.ImproperBalanceException;
import com.example.bank.model.*;
import com.example.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired
    private final AccountService service = new AccountService();

    @RequestMapping(value = "/createAccount", method = RequestMethod.POST)
    public CreateAccountResult createAccount(@RequestHeader String username, @RequestHeader String name, @RequestHeader int initialAccountBalance) throws DuplicateAccountException {
        return service.createAccount(username, name, initialAccountBalance);
    }

    @RequestMapping(value = "/editAccount", method = RequestMethod.POST)
    public EditAccountResult editAccount(@RequestHeader String username, @RequestHeader String editName) throws AccountNotFoundException {
        return service.editAccount(username, editName);
    }

    @RequestMapping(value = "/viewAccount", method = RequestMethod.POST)
    public ViewAccountResult viewAccount(@RequestHeader String username) throws AccountNotFoundException {
        return service.viewAccount(username);
    }

    @RequestMapping(value = "/addFunds", method = RequestMethod.POST)
    public AddFundsResult addFunds(@RequestHeader String username, @RequestHeader int depositAmount) throws AccountNotFoundException {
        return service.addFunds(username, depositAmount);
    }

    @RequestMapping(value = "/subtractFunds", method = RequestMethod.POST)
    public SubtractFundsResult subtractFunds(@RequestHeader String username, @RequestHeader int withdrawalAmount) throws AccountNotFoundException, ImproperBalanceException {
        return service.subtractFunds(username, withdrawalAmount);
    }

    @RequestMapping(value = "/viewAllAccounts", method = RequestMethod.POST)
    public ViewAllAccountsResult viewAllAccounts() {
        return service.viewAllAccounts();
    }

    @RequestMapping(value = "/deleteAccount", method = RequestMethod.POST)
    public DeleteAccountResult deleteAccount(@RequestHeader String username) throws AccountNotFoundException {
        return service.deleteAccount(username);
    }
}
