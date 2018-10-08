package com.piggymetrics.accountv2.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class Item {

	@NotNull
	@Size(min = 1, max = 20)
	private String title;

	@NotNull
	private BigDecimal amount;

	@NotNull
	private Currency currency;

	@NotNull
	private TimePeriod period;

	@NotNull
	private String icon;

}
