package acfm.ownbank;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author fabio.sulser
 *
 */
public class CreditAccountTest {
	
	@Test
	public void testCreateAccount() {
		int accountNumber = 1000;
		int limit = 10;
		
		AccountNumberGenerator accountNumberGenerator = EasyMock.createMock(AccountNumberGenerator.class);
		EasyMock.expect(accountNumberGenerator.getAccountNumber()).andReturn(accountNumber);
		EasyMock.replay(accountNumberGenerator);

		AccountWritable account = new CreditAccount(accountNumberGenerator.getAccountNumber(), limit);
				
		Assert.assertNotEquals(account, null);

		Assert.assertEquals(accountNumber, account.getAcountNumber());
	}
	
	
	@Test
	public void checkForOverdrawnException() {
		int accountNumber = 1000;
		int amount = 100;
		int limit = 10;
		
		AccountNumberGenerator accountNumberGenerator = EasyMock.createMock(AccountNumberGenerator.class);
		EasyMock.expect(accountNumberGenerator.getAccountNumber()).andReturn(accountNumber);
		EasyMock.replay(accountNumberGenerator);

		AccountWritable account = new CreditAccount(accountNumberGenerator.getAccountNumber(), limit);				
		
		try {
			account.book(-amount);
			Assert.fail();
		} catch (AccountOverdrawnException e) {
		}
	}
	
	@Test
	public void checkForBookingSuccess() throws AccountOverdrawnException {
		int limit = 10;
		AccountNumberGenerator accountNumberGenerator = new AccountNumberGeneratorImpl();
		AccountWritable account = new CreditAccount(accountNumberGenerator.getAccountNumber(), limit);				
		int amount = 100;
		
		account.book(amount);
		
		Assert.assertEquals(amount, account.getBalance());
	}
}
