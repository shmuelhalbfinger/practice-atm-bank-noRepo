package com.example.bank.controller;

import com.example.bank.model.*;
import com.example.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    @Autowired
    private AccountService service = new AccountService();

    @RequestMapping(value = "/createAccount", method = RequestMethod.POST)
    public CreateAccountResult createAccount(@RequestHeader String username, @RequestHeader String name, @RequestHeader int initialAccountBalance) {
        return service.createAccount(username, name, initialAccountBalance);
    }

    @RequestMapping(value = "/editAccount", method = RequestMethod.POST)
    public EditAccountResult editAccount(@RequestHeader String username, @RequestHeader String editName) {
        return service.editAccount(username, editName);
    }

    @RequestMapping(value = "/viewAccount", method = RequestMethod.POST)
    public ViewAccountResult viewAccount(@RequestHeader String username) {
        return service.viewAccount(username);
    }


    @RequestMapping(value = "/addFunds/{username}/{depositAmount}", method = RequestMethod.GET)
    public AddFundsResult addFunds(@PathVariable("username") String username, @PathVariable("depositAmount") int depositAmount) {
        return service.addFunds(username, depositAmount);
    }

    @RequestMapping(value = "/subtractFunds", method = RequestMethod.POST)
    public SubtractFundsResult subtractFunds(@RequestHeader String username, @RequestHeader int withdrawalAmount) {
        return service.subtractFunds(username, withdrawalAmount);
    }
    @RequestMapping(value = "/viewAllAccounts", method = RequestMethod.POST)
    public ViewAllAccountsResult viewAllAccounts() {
        return service.viewAllAccounts();
    }

    @RequestMapping(value = "/deleteAccount", method = RequestMethod.POST)
    public DeleteAccountResult deleteAccount(@RequestHeader String username) {
        return service.deleteAccount(username);
    }

    @RequestMapping(value = "/sayHello", method = RequestMethod.POST)
    public String sayHello(@RequestHeader String name) {
        return "Hello " + name;
    }
}
