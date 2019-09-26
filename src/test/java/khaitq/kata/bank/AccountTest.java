package khaitq.kata.bank;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

/**
*
* @author khaitq on 26 sept. 2019
*/

public class AccountTest {
	
	private Account account;
	
	@Before
	public void init() {
		this.account = new Account(new BigDecimal(0));
	}

	@Test
	public void make_a_deposit_test() {
		BigDecimal amount = new BigDecimal(100);
		this.account.deposit(amount);
		assertTrue(this.account.getBalance().equals(amount));
	}
	
	@Test
	public void make_a_withdraw_test() {
		BigDecimal amount = new BigDecimal(200);
		this.account.withdraw(amount);
		assertTrue(this.account.getBalance().equals(new BigDecimal(-200)));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void make_a_illegal_deposit_test() {
		BigDecimal amount = new BigDecimal(-200);
		this.account.deposit(amount);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void make_a_illegal_withdraw_test() {
		this.account.withdraw(null);
	}
	
	@Test
	public void print_all_history_test() {
		this.account.deposit(new BigDecimal(100));
		this.account.withdraw(new BigDecimal(30));
		
		this.account.printHistory();
	}
	
}


