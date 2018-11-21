
package com.piggymetrics.accountv2.service;

import com.piggymetrics.accountv2.domain.*;
import com.piggymetrics.accountv2.repository.AccountDBProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Date;

@ApplicationScoped
public class AccountServiceImpl implements AccountService {

	@Inject
	private AccountDBProvider repository;

	@Override
	public Account findByName(String accountName) {
		return repository.findByName(accountName);
	}

	@Override
	public Account create(User user) {
        Saving saving = new Saving();
        saving.setAmount(new BigDecimal(0));
        saving.setCurrency(Currency.getDefault());
        saving.setInterest(new BigDecimal(0));
        saving.setDeposit(false);
        saving.setCapitalization(false);

        LastSeen lastSeen = new LastSeen();
        lastSeen.setDate(new Date());

        Account account = new Account();
        account.setName(user.getUsername());
        account.setLastSeen(lastSeen);
        account.setSaving(saving);

        repository.insertOne(account);

		return account;
	}

	@Override
	public void saveChanges(String name, Account update) {

	}
}

