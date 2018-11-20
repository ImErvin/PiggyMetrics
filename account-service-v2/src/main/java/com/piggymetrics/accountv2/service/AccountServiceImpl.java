
package com.piggymetrics.accountv2.service;


import com.piggymetrics.accountv2.domain.Account;
import com.piggymetrics.accountv2.domain.User;
import com.piggymetrics.accountv2.repository.AccountDBProviderImpl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AccountServiceImpl implements AccountService {

	@Inject
	private AccountDBProviderImpl repository;


/**
	 * {@inheritDoc}
	 */

	@Override
	public String findByName(String accountName) {
		//Gson gson = new Gson();

		return repository.findByName(accountName);
	}


/**
	 * {@inheritDoc}
	 */

	@Override
	public Account create(User user) {

		//String existing = repository.getByName();
		//Assert.isNull(existing, "account already exists: " + user.getUsername());

		//authClient.createUser(user);

//		Saving saving = new Saving();
//		saving.setAmount(new BigDecimal(0));
//		saving.setCurrency(Currency.getDefault());
//		saving.setInterest(new BigDecimal(0));
//		saving.setDeposit(false);
//		saving.setCapitalization(false);
//
//		Account account = new Account();
//		account.setName(user.getUsername());
//		account.setLastSeen(new Date());
//		account.setSaving(saving);

		//repository.save(account);

		//log.info("new account has been created: " + account.getName());

		return null;
	}

	@Override
	public void saveChanges(String name, Account update) {

	}


/**
	 * {@inheritDoc}
	 */
/*
	@Override
	public void saveChanges(String name, Account update) {

		Account account = repository.findByName(name);
		Assert.notNull(account, "can't find account with name " + name);

		account.setIncomes(update.getIncomes());
		account.setExpenses(update.getExpenses());
		account.setSaving(update.getSaving());
		account.setNote(update.getNote());
		account.setLastSeen(new Date());
		repository.save(account);

		log.debug("account {} changes has been saved", name);

		//statisticsClient.updateStatistics(name, account);
	}*/
}

