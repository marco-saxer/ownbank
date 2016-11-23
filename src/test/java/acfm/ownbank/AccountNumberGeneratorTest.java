package acfm.ownbank;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author fabio.sulser
 *
 */
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
	
	@Test
	public void testNumberSet(){
		Set set1 = new HashSet();

		for (int i = 0; i< 1000; i++) {
		  set1.add(generator.getAccountNumber());		
		}
		
		Assert.assertEquals(set1.size(),1000);
	}
}
