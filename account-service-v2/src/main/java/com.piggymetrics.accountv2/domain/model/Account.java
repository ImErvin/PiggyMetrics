/*
package com.piggymetrics.accountv2.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity(name="Account")
@Data
@Getter
@Setter
public class Account {

	@Id
	private String name;

	private Date lastSeen;

	@Valid
	private List<Item> incomes;

	@Valid
	private List<Item> expenses;

	@Valid
	@NotNull
	private Saving saving;

	@Size(min = 0, max = 20_000)
	private String note;
}
*/
