package com.piggymetrics.accountv2.gson;

import com.google.gson.*;
import com.piggymetrics.accountv2.domain.Account;

import java.lang.reflect.Type;
import java.util.Date;

public class DeserializeAccount implements JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return new Date(jsonElement.getAsJsonPrimitive().getAsLong());
    }

}