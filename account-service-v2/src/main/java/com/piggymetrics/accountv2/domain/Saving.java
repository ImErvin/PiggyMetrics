package com.piggymetrics.accountv2.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Saving {
	@SerializedName("amount")
	@Expose
	private BigDecimal amount;
	@SerializedName("capitalization")
	@Expose
	private Boolean capitalization;
	@SerializedName("currency")
	@Expose
	private Currency currency;
	@SerializedName("deposit")
	@Expose
	private Boolean deposit;
	@SerializedName("interest")
	@Expose
	private BigDecimal interest;
}
