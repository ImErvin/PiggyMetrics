package com.piggymetrics.accountv2.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Account {
    @SerializedName("_id")
    @Expose(serialize = false)
    private String name;
    @SerializedName("lastSeen")
    @Expose(serialize = false)
    private LastSeen lastSeen;
    @SerializedName("note")
    @Expose(serialize = false)
    private String note;
    @SerializedName("expenses")
    @Expose(serialize = false)
    private List<Item> expenses;
    @SerializedName("incomes")
    @Expose(serialize = false)
    private List<Item> incomes;
    @SerializedName("saving")
    @Expose(serialize = false)
    private Saving saving;
}
