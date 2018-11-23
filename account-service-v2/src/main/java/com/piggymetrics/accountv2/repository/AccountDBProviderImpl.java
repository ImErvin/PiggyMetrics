package com.piggymetrics.accountv2.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.enterprise.context.ApplicationScoped;

import static com.mongodb.client.model.Filters.eq;

@ApplicationScoped
public class AccountDBProviderImpl implements AccountDBProvider {

    private MongoClient mongoClient = MongoClientProvider.getInstance().getMongoClient();
    private MongoDatabase database = mongoClient.getDatabase("piggymetrics");
    private MongoCollection<Document> collection = database.getCollection("accounts");

    @Override
    public Document findByName(String name) {
        return collection.find(eq("_id", name)).first();
    }

    @Override
    public void insertOne(Document newAccount) {
        collection.insertOne(newAccount);
    }

    @Override
    public void updateOne(Document updatedAccount) { }
}