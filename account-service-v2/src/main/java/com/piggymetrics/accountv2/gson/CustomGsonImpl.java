package com.piggymetrics.accountv2.gson;

import com.google.gson.*;
import com.piggymetrics.accountv2.domain.Account;
import lombok.NoArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Date;

@ApplicationScoped
public class CustomGsonImpl implements CustomGson {
    @Override
    public Gson accountSerializer() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.registerTypeAdapter(Account.class, new SerializeAccount());

        Gson gson = gsonBuilder.create();

        return gson;
    }

    @Override
    public Gson accountDeserializer() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.registerTypeAdapter(Date.class, new DeserializeAccount());

        Gson gson = gsonBuilder.create();

        return gson;
    }
}
