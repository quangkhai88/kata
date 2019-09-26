package khaitq.kata.bank;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
*
* @author khaitq on 26 sept. 2019
*/

public class Account {
	
	private BigDecimal balance;
	
	private Statement statement;
	
	public Account(BigDecimal init) {
		this.balance 	= init;
		this.statement 	= new Statement();
	}
	
	public void deposit(BigDecimal amount) {
		checkAmount(amount);
		addToAccount(amount);
	}
	
	private void checkAmount(BigDecimal amount) {
		if (amount == null || amount.longValue() < 0) 
			throw new IllegalArgumentException("Amount must greater than zero");
	}

	public void withdraw(BigDecimal amount) {
		checkAmount(amount);
		amount = new BigDecimal(0).subtract(amount);
		addToAccount(amount);
	}
	
	public void addToAccount(BigDecimal amount) {
		this.balance = this.balance.add(amount);
		this.statement.addOperation(new Operation(amount, balance, LocalDate.now()));
	}
	
	public void printHistory() {
		this.statement.printStatement();
	}
	
	public BigDecimal getBalance() {
		return this.balance;
	}

}


