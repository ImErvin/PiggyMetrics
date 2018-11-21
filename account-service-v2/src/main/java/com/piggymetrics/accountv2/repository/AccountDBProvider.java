package com.piggymetrics.accountv2.repository;

import com.piggymetrics.accountv2.domain.Account;
import com.piggymetrics.accountv2.domain.User;

public interface AccountDBProvider {

    Account findByName(String name);

    Account insertOne(Account newAccount);

    void updateOne(String name, Account updatedAccount);
}
