package com.piggymetrics.accountv2.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.piggymetrics.accountv2.domain.Account;
import com.piggymetrics.accountv2.gson.CustomGson;
import com.piggymetrics.accountv2.gson.CustomGsonImpl;
import com.piggymetrics.accountv2.repository.AccountDBProvider;
import org.bson.Document;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.mockito.Mockito.when;

public class AccountServiceImplTest {

    @InjectMocks
    AccountService accountService = new AccountServiceImpl();

    @Mock
    AccountDBProvider repository;

    @Mock
    CustomGson gson;

    private String jsonData = "{\"_id\":\"demo\",\"lastSeen\":{\"$date\":1542648276849},\"note\":\"demo note\",\"expenses\":[{\"amount\":1300,\"currency\":\"USD\",\"icon\":\"home\",\"period\":\"MONTH\",\"title\":\"Rent\"},{\"amount\":120,\"currency\":\"USD\",\"icon\":\"utilities\",\"period\":\"MONTH\",\"title\":\"Utilities\"}],\"incomes\":[{\"amount\":42000,\"currency\":\"USD\",\"icon\":\"wallet\",\"period\":\"YEAR\",\"title\":\"Salary\"},{\"amount\":500,\"currency\":\"USD\",\"icon\":\"edu\",\"period\":\"MONTH\",\"title\":\"Scholarship\"}],\"saving\":{\"amount\":5900,\"capitalization\":false,\"currency\":\"USD\",\"deposit\":true,\"interest\":3.32}}";

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        Document demo = Document.parse(jsonData);
        when(repository.findByName("demo")).thenReturn(demo);
    }

    @Test
    public void findByNameNotNullTest() {
        System.out.println(accountService.findByName("demo"));
        //Assert.assertNotNull(accountService.findByName("demo"));
    }

    @Test
    public void verifyDeserializedObjectSameAsSerializedObject(){
//        String json = gson.accountSerializer().toJson(accountService.findByName("demo"));
//        System.out.println(json);
//        System.out.println("done");
//        System.out.println(gson.accountDeserializer().fromJson(json, Account.class));
    }

    @Test
    public void test(){
//        Document demo = Document.parse(jsonData);
//
//        GsonBuilder gsonBuilder = new GsonBuilder();
//
//        // Adapted from:
//        // https://stackoverflow.com/questions/6873020/gson-date-format
//        // https://google.github.io/gson/apidocs/com/google/gson/GsonBuilder.html#registerTypeAdapter-java.lang.reflect.Type-java.lang.Object-
//        gsonBuilder.registerTypeAdapter(Date.class,
//                (JsonDeserializer<Date>) (jsonElement, type, jsonDeserializationContext)
//                        -> new Date(jsonElement.getAsJsonPrimitive().getAsLong()));
//
//        Gson gson1 = gsonBuilder.create();
//
//
//        Account a = gson1.fromJson(demo.toJson(), Account.class);
//
//        System.out.println(ZonedDateTime.parse(
//                a.getLastSeen().getDate().toString(),
//                DateTimeFormatter.ofPattern ( "E MMM d HH:mm:ss z yyyy" )
//        ).toInstant().toEpochMilli());
//
//
//        System.out.println(gson1.toJson(a));
//        System.out.println(gson.accountSerializer().toJson(a));
    }
}