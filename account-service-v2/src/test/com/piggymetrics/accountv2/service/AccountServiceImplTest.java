package com.piggymetrics.accountv2.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.piggymetrics.accountv2.domain.Account;
import com.piggymetrics.accountv2.repository.AccountDBProvider;
import org.bson.Document;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class AccountServiceImplTest {
    @InjectMocks
    AccountService accountService;

    @Mock
    AccountDBProvider repository;

    @Before
    public void init() throws FileNotFoundException {
        MockitoAnnotations.initMocks(this);
        Document demo = Document.parse(new FileReader("resource/demoaccount.json").toString());
        Account account = getCustomGsonBuilder().fromJson(getCustomGsonBuilder().toJson(demo), Account.class);

        when(accountService.findByName("demo")).thenReturn(account);
    }

    @Test
    void findByName() {
        Account a = accountService.findByName("demo");
        System.out.println(a.getName());
    }

    @Test
    void create() {
    }

    private Gson getCustomGsonBuilder(){
        GsonBuilder gsonBuilder = new GsonBuilder();

        // Adapted from:
        // https://stackoverflow.com/questions/6873020/gson-date-format
        // https://google.github.io/gson/apidocs/com/google/gson/GsonBuilder.html#registerTypeAdapter-java.lang.reflect.Type-java.lang.Object-
        gsonBuilder.registerTypeAdapter(Date.class,
                (JsonDeserializer<Date>) (jsonElement, type, jsonDeserializationContext)
                        -> new Date(jsonElement.getAsJsonPrimitive().getAsLong()));

        Gson gson = gsonBuilder.create();

        return gson;
    }
}