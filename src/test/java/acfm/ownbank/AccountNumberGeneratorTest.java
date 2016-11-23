package acfm.ownbank;

import org.junit.Assert;
import org.junit.Test;

public class AccountNumberGeneratorTest {
	
	AccountNumberGenerator generator = new AccountNumberGeneratorImpl();
	
	@Test
	public void testAccNum(){
		int a,b,c;
		a = generator.getAccountNumber();
		b = generator.getAccountNumber();
		c = generator.getAccountNumber();
		
		Assert.assertNotEquals(a, c);
		Assert.assertNotEquals(a, b);
		Assert.assertNotEquals(b, c);
	}
	
	
}
