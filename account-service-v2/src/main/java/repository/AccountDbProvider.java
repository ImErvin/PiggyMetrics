package repository;

import com.google.inject.Inject;
import com.mongodb.DB;
import com.mongodb.MongoClient;

import javax.ejb.Stateless;
import java.util.Set;

@Stateless
public class AccountDbProvider {

    @Inject
    MongoClientProvider mongoClientProvider;

    public Set<String> getCollectionNames() {

        MongoClient mongoClient = mongoClientProvider.getMongoClient();

        DB db = (DB) mongoClient.getDatabase("piggymetrics");
        Set<String> colls = db.getCollectionNames();

        for (String s : colls) {
            System.out.println(s);
        }

        return colls;
    }

    public String getByName() {
        MongoClient mongoClient = mongoClientProvider.getMongoClient();

        DB db = (DB) mongoClient.getDatabase("piggymetrics");

        System.out.println("Name of Database: " + db.getName());
        return "Name of Database: " + db;
    }
}