package com.example.bank.model;

public class CreateAccountRequest {
    private String username;
    private String name;
    private int initialAccountBalance;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInitialAccountBalance() {
        return initialAccountBalance;
    }

    public void setInitialAccountBalance(int initialAccountBalance) {
        this.initialAccountBalance = initialAccountBalance;
    }
}
