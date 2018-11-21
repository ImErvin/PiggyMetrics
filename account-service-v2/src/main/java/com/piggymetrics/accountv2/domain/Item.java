package com.piggymetrics.accountv2.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Item {
    @SerializedName("amount")
    @Expose
    private BigDecimal amount;
    @SerializedName("currency")
    @Expose
    private Currency currency;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("period")
    @Expose
    private TimePeriod period;
    @SerializedName("title")
    @Expose
    private String title;
}
