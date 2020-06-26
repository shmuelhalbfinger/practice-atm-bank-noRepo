package com.example.bank.model;

import java.util.Collection;

public class ViewAllAccountsResult {
    private Collection<Account> accounts;

    public Collection<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Collection<Account> accounts) {
        this.accounts = accounts;
    }
}
