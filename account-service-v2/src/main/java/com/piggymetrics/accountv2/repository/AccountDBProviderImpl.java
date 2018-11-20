package com.piggymetrics.accountv2.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.piggymetrics.accountv2.domain.Account;
import org.bson.Document;

import javax.enterprise.context.ApplicationScoped;

import java.util.Date;

import static com.mongodb.client.model.Filters.eq;

@ApplicationScoped
public class AccountDBProviderImpl implements AccountDBProvider{

    private MongoClient mongoClient = MongoClientProvider.getInstance().getMongoClient();
    private MongoDatabase database = mongoClient.getDatabase("piggymetrics");
    private MongoCollection<Document> collection = database.getCollection("accounts");
    private Gson gson = new Gson();

    @Override
    public Account findByName(String name) {
        Document serializedAccount = collection.find(eq("_id", name)).first();
        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (jsonElement, type, jsonDeserializationContext) -> {
//            Gson gson = new Gson();
//            JsonObject lastSeenInMilli = (JsonObject) jsonElement.getAsJsonObject().get("lastSeen");
//            Long lastSeen = gson.fromJson(lastSeenInMilli.get("$date"), Long.class);
//            Account account = gson.fromJson(jsonElement, Account.class);
//            account.setLastSeen(new Date(lastSeen));
            return new Date(jsonElement.getAsJsonPrimitive().getAsLong());
        });

        Gson gson = gsonBuilder.create();

        //Account account = gson.fromJson(serializedAccount.toJson(), Account.class);
        return gson.fromJson(serializedAccount.toJson(), Account.class);
    }
}