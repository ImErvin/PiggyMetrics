package com.piggymetrics.accountv2.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class User {

	@NotNull
	@Size(min = 3, max = 20)
    private String username;

	@NotNull
	@Size(min = 6, max = 40)
	private String password;

}
