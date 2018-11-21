package com.piggymetrics.accountv2.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.piggymetrics.accountv2.domain.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

public class VerifyGsonToPojoObjectTypesTest {
    private String jsonData = "{\"_id\":\"demo\",\"lastSeen\":{\"$date\":1542648276849},\"note\":\"demo note\",\"expenses\":[{\"amount\":1300,\"currency\":\"USD\",\"icon\":\"home\",\"period\":\"MONTH\",\"title\":\"Rent\"},{\"amount\":120,\"currency\":\"USD\",\"icon\":\"utilities\",\"period\":\"MONTH\",\"title\":\"Utilities\"}],\"incomes\":[{\"amount\":42000,\"currency\":\"USD\",\"icon\":\"wallet\",\"period\":\"YEAR\",\"title\":\"Salary\"},{\"amount\":500,\"currency\":\"USD\",\"icon\":\"edu\",\"period\":\"MONTH\",\"title\":\"Scholarship\"}],\"saving\":{\"amount\":5900,\"capitalization\":false,\"currency\":\"USD\",\"deposit\":true,\"interest\":3.32}}";
    private Account testAccount = gsonToPojoAccountData();

    @Test
    public void verifyGsonToPojoAccount() {
        assert this.testAccount.getName() instanceof String;
        assert this.testAccount.getLastSeen() instanceof LastSeen;
        assert this.testAccount.getNote() instanceof String;

        for (Object expense : this.testAccount.getExpenses()) {
            assert expense instanceof Item;
        }

        for (Object income : this.testAccount.getIncomes()) {
            assert income instanceof Item;
        }

        assert this.testAccount.getSaving() instanceof Saving;
    }

    @Test
    public void verifyGsonToPojoItem() {
        for (Item expense : this.testAccount.getExpenses()) {
            assert expense.getAmount() instanceof BigDecimal;
            assert expense.getCurrency() instanceof Currency;
            assert expense.getIcon() instanceof String;
            assert expense.getPeriod() instanceof TimePeriod;
            assert expense.getTitle() instanceof String;
        }

        for (Item income : this.testAccount.getIncomes()) {
            assert income.getAmount() instanceof BigDecimal;
            assert income.getCurrency() instanceof Currency;
            assert income.getIcon() instanceof String;
            assert income.getPeriod() instanceof TimePeriod;
            assert income.getTitle() instanceof String;
        }
    }

    @Test
    public void verifyGsonToPojoSaving() {
        assert this.testAccount.getSaving().getAmount() instanceof BigDecimal;
        assert this.testAccount.getSaving().getCapitalization() instanceof Boolean;
        assert this.testAccount.getSaving().getCurrency() instanceof Currency;
        assert this.testAccount.getSaving().getDeposit() instanceof Boolean;
        assert this.testAccount.getSaving().getInterest() instanceof BigDecimal;
    }

    @Test
    public void verifyGsonToPojoLastSeen() {
        assert this.testAccount.getLastSeen().getDate() instanceof Date;
    }

    public Account gsonToPojoAccountData() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        // Adapted from:
        // https://stackoverflow.com/questions/6873020/gson-date-format
        // https://google.github.io/gson/apidocs/com/google/gson/GsonBuilder.html#registerTypeAdapter-java.lang.reflect.Type-java.lang.Object-
        gsonBuilder.registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (jsonElement, type, jsonDeserializationContext) -> new Date(jsonElement.getAsJsonPrimitive().getAsLong()));

        Gson gson = gsonBuilder.create();

        Account account = gson.fromJson(this.jsonData, Account.class);

        return account;
    }

//    public Account manualAccountData() {
//        Account account = new Account();
//
//        account.setName("demo");
//
//        LastSeen lastSeen = new LastSeen();
//        lastSeen.setDate(new Date(1542648276849L));
//        account.setLastSeen(lastSeen);
//
//        account.setNote("demo note");
//
//        List<Item> expenses = new ArrayList<>();
//        expenses.add(new Item(new BigDecimal(1300.0), Currency.USD, "home", TimePeriod.MONTH, "Rent"));
//        expenses.add(new Item(new BigDecimal(120.0), Currency.USD, "utilities", TimePeriod.MONTH, "Utilities"));
//        account.setExpenses(expenses);
//
//        List<Item> incomes = new ArrayList<>();
//        incomes.add(new Item(new BigDecimal(42000.0), Currency.USD, "wallet", TimePeriod.YEAR, "Salary"));
//        incomes.add(new Item(new BigDecimal(500.0), Currency.USD, "edu", TimePeriod.MONTH, "Scholarship"));
//        account.setIncomes(incomes);
//
//        Saving saving = new Saving(new BigDecimal(5900.0), false, Currency.USD, true, new BigDecimal(3.32));
//        account.setSaving(saving);
//
//        return account;
//    }
}