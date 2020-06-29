package com.example.bank.exceptionhandler;

public class ImproperBalanceException extends Exception {
    public ImproperBalanceException(String s) {
        super(s);
    }
}
