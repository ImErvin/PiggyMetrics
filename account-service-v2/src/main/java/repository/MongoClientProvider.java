package repository;


import com.mongodb.MongoClient;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MongoClientProvider {

    private MongoClient mongoClient;

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    @PostConstruct
    public void init() {
        String mongoIpAddress = "localhost";
        Integer mongoPort = 27017;
        mongoClient = new MongoClient(mongoIpAddress, mongoPort);
    }

}

