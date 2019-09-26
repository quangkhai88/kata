package khaitq.kata.bank;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;

/**
*
* @author khaitq on 26 sept. 2019
*/

public class OperationTest {
	

	@Test
	public void print_test() {
		
		Operation operation = new Operation(new BigDecimal(100), new BigDecimal(100), LocalDate.of(2019, 9, 26));
		assertTrue(operation.toString().equals("2019-09-26 | 100 | 100"));
		
	}

}


