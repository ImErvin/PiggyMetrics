
package com.piggymetrics.accountv2.service;

import com.piggymetrics.accountv2.domain.Account;
import com.piggymetrics.accountv2.domain.User;

public interface AccountService {

	Account findByName(String accountName);

	Account create(User user);

	void saveChanges(String name, Account update);
}

