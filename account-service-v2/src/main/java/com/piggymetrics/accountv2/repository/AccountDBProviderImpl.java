package com.piggymetrics.accountv2.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.piggymetrics.accountv2.domain.Account;
import com.piggymetrics.accountv2.domain.User;
import org.bson.Document;

import javax.enterprise.context.ApplicationScoped;

import java.math.BigDecimal;
import java.util.Date;

import static com.mongodb.client.model.Filters.eq;

@ApplicationScoped
public class AccountDBProviderImpl implements AccountDBProvider {

    private MongoClient mongoClient = MongoClientProvider.getInstance().getMongoClient();
    private MongoDatabase database = mongoClient.getDatabase("piggymetrics");
    private MongoCollection<Document> collection = database.getCollection("accounts");
    private Gson gson = new Gson();

    @Override
    public Account findByName(String name) {
        try {
            Document serializedAccount = collection.find(eq("_id", name)).first();
            return getCustomGsonBuilder().fromJson(serializedAccount.toJson(), Account.class);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage() + " caused by " + e.getCause());
            return null;
        }
    }

    @Override
    public void insertOne(Account newAccount) {
        try {
            collection.insertOne(new Document().parse(getCustomGsonBuilder().toJson(newAccount)));
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage() + " caused by " + e.getCause());
        }
    }

    @Override
    public void updateOne(Account updatedAccount) {

    }

    private Gson getCustomGsonBuilder(){
        GsonBuilder gsonBuilder = new GsonBuilder();

        // Adapted from:
        // https://stackoverflow.com/questions/6873020/gson-date-format
        // https://google.github.io/gson/apidocs/com/google/gson/GsonBuilder.html#registerTypeAdapter-java.lang.reflect.Type-java.lang.Object-
        gsonBuilder.registerTypeAdapter(Date.class,
                (JsonDeserializer<Date>) (jsonElement, type, jsonDeserializationContext)
                        -> new Date(jsonElement.getAsJsonPrimitive().getAsLong()));

        Gson gson = gsonBuilder.create();

        return gson;
    }
}