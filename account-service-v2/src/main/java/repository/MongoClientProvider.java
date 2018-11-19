package repository;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.Synchronized;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Singleton;

@Singleton
public class MongoClientProvider {

    private MongoClient mongoClient;

    @PostConstruct
    public void init() {
        mongoClient = MongoClients.create("mongodb://user:sd@account-mongodb/piggymetrics");
    }

    public MongoClient getMongoClient(){
        return this.mongoClient;
    }

}

