package com.example.bank.controller;

import com.example.bank.model.*;
import com.example.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired
    private AccountService service = new AccountService();

    @RequestMapping(value = "/createAccount/{username}/{name}/{initialAccountBalance}", method = RequestMethod.GET)
    public CreateAccountResult createAccount(@PathVariable("username") String username, @PathVariable("name") String name, @PathVariable("initialAccountBalance") int initialAccountBalance) {
        return service.createAccount(username, name, initialAccountBalance);
    }

    @RequestMapping(value = "/editAccount/{username}/{editName}", method = RequestMethod.GET)
    public EditAccountResult editAccount(@PathVariable("username") String username, @PathVariable("editName") String editName) {
        return service.editAccount(username, editName);
    }

    @RequestMapping(value = "/viewAccount/{username}", method = RequestMethod.GET)
    public ViewAccountResult viewAccount(@PathVariable("username") String username) {
        return service.viewAccount(username);
    }


    @RequestMapping(value = "/addFunds/{username}/{depositAmount}", method = RequestMethod.GET)
    public AddFundsResult addFunds(@PathVariable("username") String username, @PathVariable("depositAmount") int depositAmount) {
        return service.addFunds(username, depositAmount);
    }

    @RequestMapping(value = "/subtractFunds/{username}/{withdrawalAmount}", method = RequestMethod.GET)
    public SubtractFundsResult subtractFunds(@PathVariable("username") String username, @PathVariable("withdrawalAmount") int withdrawalAmount) {
        return service.subtractFunds(username, withdrawalAmount);
    }
    @RequestMapping(value = "/viewAllAccounts", method = RequestMethod.GET)
    public ViewAllAccountsResult viewAllAccounts() {
        return service.viewAllAccounts();
    }
    @RequestMapping(value = "/deleteAccount/{username}", method = RequestMethod.GET)
    public DeleteAccountResult deleteAccount(@PathVariable("username") String username) {
        return service.deleteAccount(username);
    }
}
