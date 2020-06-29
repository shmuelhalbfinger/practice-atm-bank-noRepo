package com.example.bank.exceptionhandler;

public class DuplicateAccountException extends Exception {
    public DuplicateAccountException(String s) {
        super(s);
    }
}
