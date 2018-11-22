package com.piggymetrics.accountv2.repository;

import org.bson.Document;

public interface AccountDBProvider {

    Document findByName(String name);

    void insertOne(Document newAccount);

    void updateOne(Document updatedAccount);
}
