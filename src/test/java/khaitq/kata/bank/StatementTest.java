package khaitq.kata.bank;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

/**
*
* @author khaitq on 26 sept. 2019
*/

public class StatementTest {

	private Statement statement;
	
	@Before
	public void init() {
		this.statement = new Statement();
	}
	
	@Test
	public void no_operation_test() {
		assertTrue(this.statement.getPrintStatement().equals("Date | Amount | Balance\n"));
	}
	
	@Test
	public void add_operation_test() {
		this.statement.addOperation(new Operation(new BigDecimal(-30), new BigDecimal(100), LocalDate.of(2019, 9, 26)));
		
		String expected = "Date | Amount | Balance\n" + 
						  "2019-09-26 | -30 | 100\n";
		assertTrue(this.statement.getPrintStatement().equals(expected));
	}

}


