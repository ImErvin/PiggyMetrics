package com.piggymetrics.accountv2.gson;

import com.piggymetrics.accountv2.domain.*;
import org.bson.Document;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class CustomGsonImplTest {

    private CustomGson gson = new CustomGsonImpl();
    private String jsonData = "{\"_id\":\"demo\",\"lastSeen\":{\"$date\":1542648276849},\"note\":\"demo note\",\"expenses\":[{\"amount\":1300,\"currency\":\"USD\",\"icon\":\"home\",\"period\":\"MONTH\",\"title\":\"Rent\"},{\"amount\":120,\"currency\":\"USD\",\"icon\":\"utilities\",\"period\":\"MONTH\",\"title\":\"Utilities\"}],\"incomes\":[{\"amount\":42000,\"currency\":\"USD\",\"icon\":\"wallet\",\"period\":\"YEAR\",\"title\":\"Salary\"},{\"amount\":500,\"currency\":\"USD\",\"icon\":\"edu\",\"period\":\"MONTH\",\"title\":\"Scholarship\"}],\"saving\":{\"amount\":5900,\"capitalization\":false,\"currency\":\"USD\",\"deposit\":true,\"interest\":3.32}}";
    private Document demo;

    @Before
    public void init() {
        demo = Document.parse(jsonData);
    }

    @Test
    public void verifyAccountDeserialized() {
        Assert.assertNotNull(gson.accountDeserializer().fromJson(demo.toJson(), Account.class));
        Assert.assertTrue(gson.accountDeserializer().fromJson(demo.toJson(), Account.class) instanceof Account);
    }

    @Test
    public void verifyAccountFieldsDeserialized() {
        Account deserializedAccount = gson.accountDeserializer().fromJson(demo.toJson(), Account.class);

        Assert.assertTrue(deserializedAccount.getName() instanceof String);
        Assert.assertTrue(deserializedAccount.getLastSeen() instanceof LastSeen);
        Assert.assertTrue(deserializedAccount.getNote() instanceof String);

        for (Object expense : deserializedAccount.getExpenses()) {
            Assert.assertTrue(expense instanceof Item);
        }

        for (Object income : deserializedAccount.getIncomes()) {
            Assert.assertTrue(income instanceof Item);
        }

        Assert.assertTrue(deserializedAccount.getSaving() instanceof Saving);
    }

    @Test
    public void verifyItemFieldsDeserialzed() {
        Account deserializedAccount = gson.accountDeserializer().fromJson(demo.toJson(), Account.class);

        for (Item expense : deserializedAccount.getExpenses()) {
            Assert.assertTrue(expense.getAmount() instanceof BigDecimal);
            Assert.assertTrue(expense.getCurrency() instanceof Currency);
            Assert.assertTrue(expense.getIcon() instanceof String);
            Assert.assertTrue(expense.getPeriod() instanceof TimePeriod);
            Assert.assertTrue(expense.getTitle() instanceof String);
        }

        for (Item income : deserializedAccount.getIncomes()) {
            Assert.assertTrue(income.getAmount() instanceof BigDecimal);
            Assert.assertTrue(income.getCurrency() instanceof Currency);
            Assert.assertTrue(income.getIcon() instanceof String);
            Assert.assertTrue(income.getPeriod() instanceof TimePeriod);
            Assert.assertTrue(income.getTitle() instanceof String);
        }
    }

    @Test
    public void verifySavingFieldsDeserialised() {
        Account deserializedAccount = gson.accountDeserializer().fromJson(demo.toJson(), Account.class);

        Assert.assertTrue(deserializedAccount.getSaving().getAmount() instanceof BigDecimal);
        Assert.assertTrue(deserializedAccount.getSaving().getCapitalization() instanceof Boolean);
        Assert.assertTrue(deserializedAccount.getSaving().getCurrency() instanceof Currency);
        Assert.assertTrue(deserializedAccount.getSaving().getDeposit() instanceof Boolean);
        Assert.assertTrue(deserializedAccount.getSaving().getInterest() instanceof BigDecimal);
    }

    @Test
    public void verifyLastSeenDeserialzed() {
        Account deserializedAccount = gson.accountDeserializer().fromJson(demo.toJson(), Account.class);

        Assert.assertTrue(deserializedAccount.getLastSeen().getDate() instanceof Date);
    }
}