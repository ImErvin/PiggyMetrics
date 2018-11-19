
package com.piggymetrics.service;

import com.piggymetrics.domain.Account;
import com.piggymetrics.domain.User;

public interface AccountService {

	String findByName(String accountName);

	Account create(User user);

	void saveChanges(String name, Account update);
}

