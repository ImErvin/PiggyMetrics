package com.piggymetrics.accountv2.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonObject;
import com.piggymetrics.accountv2.domain.Account;
import com.piggymetrics.accountv2.domain.Item;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;


public class AccountDBProviderImplTest {

    @Test
    public void gsonToPojoTest() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.registerTypeAdapter(Account.class, (JsonDeserializer<Account>) (jsonElement, type, jsonDeserializationContext) -> {
            Gson gson = new Gson();
            JsonObject lastSeenInMilli = (JsonObject) jsonElement.getAsJsonObject().get("lastSeen");
            Long lastSeen = gson.fromJson(lastSeenInMilli.get("$date"), Long.class);
            Account a = gson.fromJson(jsonElement, Account.class);
            a.setLastSeen(new Date(lastSeen));
            return a;
        });

        Gson gson = gsonBuilder.create();

        String json = "{ \"_id\" : \"demo\", \"lastSeen\" : { \"$date\" : 1542648276849 }, \"note\" : \"demo note\", \"expenses\" : [{ \"amount\" : 1300.0, \"currency\" : \"USD\", \"icon\" : \"home\", \"period\" : \"MONTH\", \"title\" : \"Rent\" }, { \"amount\" : 120.0, \"currency\" : \"USD\", \"icon\" : \"utilities\", \"period\" : \"MONTH\", \"title\" : \"Utilities\" }, { \"amount\" : 20.0, \"currency\" : \"USD\", \"icon\" : \"meal\", \"period\" : \"DAY\", \"title\" : \"Meal\" }, { \"amount\" : 240.0, \"currency\" : \"USD\", \"icon\" : \"gas\", \"period\" : \"MONTH\", \"title\" : \"Gas\" }, { \"amount\" : 3500.0, \"currency\" : \"EUR\", \"icon\" : \"island\", \"period\" : \"YEAR\", \"title\" : \"Vacation\" }, { \"amount\" : 30.0, \"currency\" : \"EUR\", \"icon\" : \"phone\", \"period\" : \"MONTH\", \"title\" : \"Phone\" }, { \"amount\" : 700.0, \"currency\" : \"USD\", \"icon\" : \"sport\", \"period\" : \"YEAR\", \"title\" : \"Gym\" }], \"incomes\" : [{ \"amount\" : 42000.0, \"currency\" : \"USD\", \"icon\" : \"wallet\", \"period\" : \"YEAR\", \"title\" : \"Salary\" }, { \"amount\" : 500.0, \"currency\" : \"USD\", \"icon\" : \"edu\", \"period\" : \"MONTH\", \"title\" : \"Scholarship\" }], \"saving\" : { \"amount\" : 5900.0, \"capitalization\" : false, \"currency\" : \"USD\", \"deposit\" : true, \"interest\" : 3.32 } }";

        Account account = gson.fromJson(json, Account.class);

        System.out.println(account.getName());
        for(Item expense : account.getExpenses()){
            System.out.println(expense.getTitle().toString());
        }
        for(Item income : account.getIncomes()){
            System.out.println(income.getTitle().toString());
        }
        System.out.println(account.getLastSeen());
    }
}