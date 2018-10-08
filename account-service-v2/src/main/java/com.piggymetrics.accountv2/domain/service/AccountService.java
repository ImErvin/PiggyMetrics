package com.piggymetrics.accountv2.domain.service;

import com.piggymetrics.accountv2.domain.model.Account;
import com.piggymetrics.accountv2.domain.model.User;

public interface AccountService {

        Account findByName(String accountName);

        Account create(User user);

        void saveChanges(String name, Account update);
}
