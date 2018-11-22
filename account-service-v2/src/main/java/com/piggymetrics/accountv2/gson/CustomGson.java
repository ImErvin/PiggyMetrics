package com.piggymetrics.accountv2.gson;

import com.google.gson.Gson;

public interface CustomGson {

    Gson accountSerializer();

    Gson accountDeserializer();
}
