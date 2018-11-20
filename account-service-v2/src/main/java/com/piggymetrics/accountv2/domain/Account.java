package com.piggymetrics.accountv2.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
public class Account {
	@SerializedName("_id")
	@Expose
	private String name;
	@SerializedName("lastSeen")
	@Expose
	private LastSeen lastSeen;
	@SerializedName("note")
	@Expose
	private String note;
	@SerializedName("expenses")
	@Expose
	private List<Item> expenses;
	@SerializedName("incomes")
	@Expose
	private List<Item> incomes;
	@SerializedName("saving")
	@Expose
	private Saving saving;
}