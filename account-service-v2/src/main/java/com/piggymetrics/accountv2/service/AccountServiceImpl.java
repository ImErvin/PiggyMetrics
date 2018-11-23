
package com.piggymetrics.accountv2.service;

import com.piggymetrics.accountv2.domain.*;
import com.piggymetrics.accountv2.gson.CustomGson;
import com.piggymetrics.accountv2.gson.CustomGsonImpl;
import com.piggymetrics.accountv2.repository.AccountDBProvider;
import org.bson.Document;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AccountServiceImpl implements AccountService {

	@Inject
	private AccountDBProvider repository;

	private CustomGson customGson = new CustomGsonImpl();

	@Override
	public String findByName(String accountName) {
		Document bsonAccount = repository.findByName(accountName);
		Account deserializedAccount = customGson.accountDeserializer().fromJson(bsonAccount.toJson(), Account.class);
		String serializedAccount = customGson.accountSerializer().toJson(deserializedAccount);

		return serializedAccount;
	}

	@Override
	public Account create(User user) {
//        Saving saving = new Saving();
//        saving.setAmount(new BigDecimal(0));
//        saving.setCurrency(Currency.getDefault());
//        saving.setInterest(new BigDecimal(0));
//        saving.setDeposit(false);
//        saving.setCapitalization(false);
//
//        Account account = new Account();
//        account.setName(user.getUsername());
//
//        LastSeen lastSeen = new LastSeen();
//        lastSeen.setDate(new Date());
//
//        account.setLastSeen(lastSeen);
////		account.setLastSeen(new Date());
//        account.setSaving(saving);
//
//        repository.insertOne(account);

		return null;
	}

	@Override
	public void saveChanges(String name, Account update) {

	}


}

