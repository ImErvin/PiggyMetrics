package com.piggymetrics.accountv2.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonObject;
import com.piggymetrics.accountv2.domain.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;


public class AccountDBProviderImplTest {
    private String jsonData = "{ \"_id\" : \"demo\", \"lastSeen\" : { \"$date\" : 1542648276849 }, \"note\" : \"demo note\", \"expenses\" : [{ \"amount\" : 1300.0, \"currency\" : \"USD\", \"icon\" : \"home\", \"period\" : \"MONTH\", \"title\" : \"Rent\" }, { \"amount\" : 120.0, \"currency\" : \"USD\", \"icon\" : \"utilities\", \"period\" : \"MONTH\", \"title\" : \"Utilities\" }, { \"amount\" : 20.0, \"currency\" : \"USD\", \"icon\" : \"meal\", \"period\" : \"DAY\", \"title\" : \"Meal\" }, { \"amount\" : 240.0, \"currency\" : \"USD\", \"icon\" : \"gas\", \"period\" : \"MONTH\", \"title\" : \"Gas\" }, { \"amount\" : 3500.0, \"currency\" : \"EUR\", \"icon\" : \"island\", \"period\" : \"YEAR\", \"title\" : \"Vacation\" }, { \"amount\" : 30.0, \"currency\" : \"EUR\", \"icon\" : \"phone\", \"period\" : \"MONTH\", \"title\" : \"Phone\" }, { \"amount\" : 700.0, \"currency\" : \"USD\", \"icon\" : \"sport\", \"period\" : \"YEAR\", \"title\" : \"Gym\" }], \"incomes\" : [{ \"amount\" : 42000.0, \"currency\" : \"USD\", \"icon\" : \"wallet\", \"period\" : \"YEAR\", \"title\" : \"Salary\" }, { \"amount\" : 500.0, \"currency\" : \"USD\", \"icon\" : \"edu\", \"period\" : \"MONTH\", \"title\" : \"Scholarship\" }], \"saving\" : { \"amount\" : 5900.0, \"capitalization\" : false, \"currency\" : \"USD\", \"deposit\" : true, \"interest\" : 3.32 } }";

    @Test
    public void verifyAccountGsonToPojo() {
        Account account = jsonToPojo();

        assert account.getName() instanceof String;
        assert account.getLastSeen() instanceof LastSeen;
        assert account.getNote() instanceof String;

        for(Object expense : account.getExpenses()){
            assert expense instanceof Item;
        }

        for(Object income : account.getIncomes()){
            assert income instanceof Item;
        }

        assert account.getSaving() instanceof Saving;
    }

    @Test
    public void verifyItemGsonToPojo(){
        Account account = jsonToPojo();

        for(Item expense : account.getExpenses()){
            assert expense.getAmount() instanceof BigDecimal;
            assert expense.getCurrency() instanceof String;
            assert expense.getIcon() instanceof String;
            assert expense.getPeriod() instanceof TimePeriod;
            assert expense.getTitle() instanceof String;
        }

        for(Item income : account.getIncomes()){
            assert income.getAmount() instanceof BigDecimal;
            assert income.getCurrency() instanceof String;
            assert income.getIcon() instanceof String;
            assert income.getPeriod() instanceof TimePeriod;
            assert income.getTitle() instanceof String;
        }
    }

    @Test
    public void gsonToPojoCorrectLastSeenTest() {

        Account account = jsonToPojo();

        assert account.getLastSeen() instanceof LastSeen;
        assert account.getLastSeen().getDate() instanceof Date;
        assert account.getLastSeen().getDate().equals(new Date(1542648276849L));

    }

    public Account jsonToPojo(){
        GsonBuilder gsonBuilder = new GsonBuilder();

        // Adapted from:
        // https://stackoverflow.com/questions/6873020/gson-date-format
        // https://google.github.io/gson/apidocs/com/google/gson/GsonBuilder.html#registerTypeAdapter-java.lang.reflect.Type-java.lang.Object-
        gsonBuilder.registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (jsonElement, type, jsonDeserializationContext) -> new Date(jsonElement.getAsJsonPrimitive().getAsLong()));

        Gson gson = gsonBuilder.create();

        Account account = gson.fromJson(this.jsonData, Account.class);

        return account;
    }
}