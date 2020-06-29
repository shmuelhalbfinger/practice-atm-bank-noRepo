package com.example.atm.controller;

import com.example.atm.model.TransactionResult;
import com.example.atm.service.AtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AtmController {
    @Autowired
    private AtmService service;

    //service will do everything from controller, but without specified parameters
    //for docker- google search

    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
    public TransactionResult withdraw(@RequestHeader String username, @RequestHeader int withdrawalAmount) {
        return service.withdraw(username, withdrawalAmount);
    }

    @RequestMapping(value = "/deposit", method = RequestMethod.POST)
    public TransactionResult deposit(@RequestHeader String username, @RequestHeader int depositAmount) {
        return service.deposit(username, depositAmount);
    }
}
