package com.piggymetrics.accountv2.gson;

import com.google.gson.*;
import com.piggymetrics.accountv2.domain.Account;
import com.piggymetrics.accountv2.domain.Item;

import java.lang.reflect.Type;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class SerializeAccount implements JsonSerializer<Account> {

    @Override
    public JsonElement serialize(Account account, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject accountObject = new JsonObject();
        JsonObject expenseItem;
        JsonArray jsonExpensesArray = new JsonArray();
        JsonObject incomeItem;
        JsonArray jsonIncomesArray = new JsonArray();
        JsonObject saving = new JsonObject();

        Long stringToEpoch = ZonedDateTime.parse(
                account.getLastSeen().getDate().toString(),
                DateTimeFormatter.ofPattern ( "E MMM d HH:mm:ss z yyyy" )
        ).toInstant().toEpochMilli();

        accountObject.addProperty("_id", account.getName());
        accountObject.addProperty("lastSeen", stringToEpoch);
        accountObject.addProperty("note", account.getNote());

        for(Item expense : account.getExpenses()){
            expenseItem = new JsonObject();
            expenseItem.addProperty("amount", expense.getAmount());
            expenseItem.addProperty("currency", expense.getCurrency().toString());
            expenseItem.addProperty("icon", expense.getIcon());
            expenseItem.addProperty("period", expense.getPeriod().toString());
            expenseItem.addProperty("title", expense.getTitle());
            jsonExpensesArray.add(expenseItem);
        }
        accountObject.add("expenses", jsonExpensesArray);

        for(Item income : account.getExpenses()){
            incomeItem = new JsonObject();
            incomeItem.addProperty("amount", income.getAmount());
            incomeItem.addProperty("currency", income.getCurrency().toString());
            incomeItem.addProperty("icon", income.getIcon());
            incomeItem.addProperty("period", income.getPeriod().toString());
            incomeItem.addProperty("title", income.getTitle());
            jsonIncomesArray.add(incomeItem);
        }
        accountObject.add("incomes", jsonIncomesArray);

        saving.addProperty("amount", account.getSaving().getAmount());
        saving.addProperty("capitalization", account.getSaving().getCapitalization());
        saving.addProperty("currency", account.getSaving().getCurrency().toString());
        saving.addProperty("deposit", account.getSaving().getDeposit());
        saving.addProperty("interest", account.getSaving().getInterest());
        accountObject.add("saving", saving);

        return accountObject;
    }

}
