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


import javax.print.Doc;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.mockito.Mockito.when;

public class AccountServiceImplTest {

    @InjectMocks
    AccountService accountService = new AccountServiceImpl();

    @Mock
    AccountDBProvider repository;


    private String jsonData = "{\"_id\":\"demo\",\"lastSeen\":{\"$date\":1542648276849},\"note\":\"demo note\",\"expenses\":[{\"amount\":1300,\"currency\":\"USD\",\"icon\":\"home\",\"period\":\"MONTH\",\"title\":\"Rent\"},{\"amount\":120,\"currency\":\"USD\",\"icon\":\"utilities\",\"period\":\"MONTH\",\"title\":\"Utilities\"}],\"incomes\":[{\"amount\":42000,\"currency\":\"USD\",\"icon\":\"wallet\",\"period\":\"YEAR\",\"title\":\"Salary\"},{\"amount\":500,\"currency\":\"USD\",\"icon\":\"edu\",\"period\":\"MONTH\",\"title\":\"Scholarship\"}],\"saving\":{\"amount\":5900,\"capitalization\":false,\"currency\":\"USD\",\"deposit\":true,\"interest\":3.32}}";
    private String expectedOutput = "{\"_id\":\"demo\",\"lastSeen\":1542648276000,\"note\":\"demo note\",\"expenses\":[{\"amount\":1300,\"currency\":\"USD\",\"icon\":\"home\",\"period\":\"MONTH\",\"title\":\"Rent\"},{\"amount\":120,\"currency\":\"USD\",\"icon\":\"utilities\",\"period\":\"MONTH\",\"title\":\"Utilities\"}],\"incomes\":[{\"amount\":1300,\"currency\":\"USD\",\"icon\":\"home\",\"period\":\"MONTH\",\"title\":\"Rent\"},{\"amount\":120,\"currency\":\"USD\",\"icon\":\"utilities\",\"period\":\"MONTH\",\"title\":\"Utilities\"}],\"saving\":{\"amount\":5900,\"capitalization\":false,\"currency\":\"USD\",\"deposit\":true,\"interest\":3.32}}\n";

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        Document demo = Document.parse(jsonData);
        when(repository.findByName("demo")).thenReturn(demo);
    }

    @Test
    public void findByNameCorrectStructureTest() {
        Assert.assertNotNull(accountService.findByName("demo"));
        Assert.assertTrue(Document.parse(accountService.findByName("demo")).equals(Document.parse(expectedOutput)));
    }
}