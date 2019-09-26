package khaitq.kata.bank;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
*
* @author khaitq on 26 sept. 2019
*/

public class Operation {
	
	private BigDecimal 	amount;
	
	private BigDecimal 	balance;
	
	private LocalDate 	date;
	
	public Operation(BigDecimal amount, BigDecimal balance, LocalDate date) {
		this.amount = amount;
		this.balance = balance;
		this.date = date;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public LocalDate getDate() {
		return date;
	}
	
	@Override
	public String toString() {
		return date.format(DateTimeFormatter.ISO_DATE) + " | " + amount.longValue() + " | " + balance.longValue();
	}

}


