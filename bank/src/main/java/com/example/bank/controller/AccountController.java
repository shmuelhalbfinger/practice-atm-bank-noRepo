package com.example.bank.controller;

import com.example.bank.model.CreateAccountResult;
import com.example.bank.model.EditAccountResult;
import com.example.bank.model.UpdateAccountResult;
import com.example.bank.model.ViewAccountResult;
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

    @RequestMapping(value = "/createAccount/{name}/{initialAccountBalance}", method = RequestMethod.GET)
    public CreateAccountResult createAccount(@PathVariable("name") String name, @PathVariable("initialAccountBalance") int initialAccountBalance) {
        return service.createAccount(name, initialAccountBalance);
    }

    @RequestMapping(value = "/editAccount/{editName}", method = RequestMethod.GET)
    public EditAccountResult editAccount(@PathVariable("editName") String editName) {
        return service.editAccount(editName);
    }

    @RequestMapping(value = "/viewAccount", method = RequestMethod.GET)
    public ViewAccountResult viewAccount() {
        return service.viewAccount();
    }

    @RequestMapping(value = "/updateAccount", method = RequestMethod.GET)
    public UpdateAccountResult updateAccount() {
        return service.updateAccount();
    }
}
