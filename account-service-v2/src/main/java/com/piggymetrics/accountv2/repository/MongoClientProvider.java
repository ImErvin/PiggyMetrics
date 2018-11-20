package com.piggymetrics.accountv2.repository;


import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.Synchronized;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MongoClientProvider {

    private static MongoClientProvider instance = null;
    private MongoClient mongoClient;

    private MongoClientProvider(){
        mongoClient = MongoClients.create( new ConnectionString("mongodb://user:sd@account-mongodb/piggymetrics"));
    }

    // Synchronized singleton pattern implementation
    @Synchronized
    public static MongoClientProvider getInstance(){
        if(instance == null){
            instance = new MongoClientProvider();
        }
        return instance;
    }

    public MongoClient getMongoClient(){
        return this.mongoClient;
    }

}

