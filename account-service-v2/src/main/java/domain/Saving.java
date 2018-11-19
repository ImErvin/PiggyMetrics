package domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter @Setter
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
