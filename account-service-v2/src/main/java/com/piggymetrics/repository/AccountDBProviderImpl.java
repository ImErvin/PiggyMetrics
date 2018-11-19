package com.piggymetrics.repository;



import com.google.gson.Gson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.piggymetrics.domain.Account;
import org.bson.Document;

import javax.enterprise.context.ApplicationScoped;

import static com.mongodb.client.model.Filters.eq;

@ApplicationScoped
public class AccountDBProviderImpl implements AccountDBProvider{

    private MongoClient mongoClient = MongoClientProvider.getInstance().getMongoClient();
    private MongoDatabase database = mongoClient.getDatabase("piggymetrics");
    private MongoCollection<Document> collection = database.getCollection("accounts");
    private Gson gson = new Gson();

    @Override
    public String findByName(String name) {
        Document serializedAccount = collection.find(eq("_id", name)).first();

        Account deserializedAccount = gson.fromJson(serializedAccount.toJson(), Account.class);

        return serializedAccount.toJson();
    }
}