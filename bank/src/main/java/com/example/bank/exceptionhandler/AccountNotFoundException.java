package com.example.bank.exceptionhandler;

public class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String s) {
        super(s);
    }
}
