package com.example.atm.controller;

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

    @RequestMapping(value = "/withdraw/{username}/{withdrawalAmount}", method = RequestMethod.GET)
    public TransactionResult withdraw(@PathVariable("username") String username, @PathVariable("withdrawalAmount") int withdrawalAmount) {
        return service.withdraw(username, withdrawalAmount);
    }

    @RequestMapping(value = "/deposit/{username}/{depositAmount}", method = RequestMethod.GET)
    public TransactionResult deposit(@PathVariable("username") String username, @PathVariable("depositAmount") int depositAmount) {
        return service.deposit(username, depositAmount);
    }
}
