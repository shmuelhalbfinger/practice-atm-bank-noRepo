package com.example.atm.controller;

import com.example.atm.model.GetAccountResult;
import com.example.atm.model.TransactionResult;
import com.example.atm.service.AtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AtmController {
    @Autowired
    private AtmService service;

    //service will do everything from controller, but without specified parameters
    //for docker- google search

    @RequestMapping(value = "/getAccount", method = RequestMethod.GET)
    public GetAccountResult getAccount() {
        return service.getAccount();
    }

    @RequestMapping(value = "/withdraw/{withdrawalAmount}", method = RequestMethod.GET)
    public TransactionResult withdraw(@PathVariable("withdrawalAmount") int withdrawalAmount) {
        return service.withdraw(withdrawalAmount);
    }

    @RequestMapping(value = "/deposit/{depositAmount}", method = RequestMethod.GET)
    public TransactionResult deposit(@PathVariable("depositAmount") int depositAmount) {
        return service.deposit(depositAmount);
    }
    @RequestMapping(value="/sendUpdate", method = RequestMethod.GET)
    public TransactionResult sendUpdate() {
        return service.sendUpdate();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String sayHello() {
        return service.sayHello();
    }
}
