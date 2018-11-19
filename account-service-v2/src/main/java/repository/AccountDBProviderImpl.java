package repository;



import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import domain.Account;
import org.bson.Document;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Set;

import static com.mongodb.client.model.Filters.eq;

@ApplicationScoped
public class AccountDBProviderImpl implements AccountDBProvider{

    @Inject
    private MongoClientProvider mongoClientProvider;

    private MongoDatabase database = mongoClientProvider.getMongoClient().getDatabase("piggymetrics");
    private MongoCollection<Document> collection = database.getCollection("accounts");
    private Gson gson = new Gson();

    @Override
    public Account findByName(String name) {
        Document serializedAccount = collection.find(eq("_id", name)).first();

        Account deserializedAccount = gson.fromJson(serializedAccount.toJson(), Account.class);

        return deserializedAccount;
    }
}