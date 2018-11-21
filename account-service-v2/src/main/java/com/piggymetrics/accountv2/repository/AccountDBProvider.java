package com.piggymetrics.accountv2.repository;

import com.piggymetrics.accountv2.domain.Account;

public interface AccountDBProvider {

    Account findByName(String name);

    void insertOne(Account newAccount);

    void updateOne(Account updatedAccount);
}
