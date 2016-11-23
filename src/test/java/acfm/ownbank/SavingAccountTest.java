package acfm.ownbank;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author fabio.sulser
 *
 */
public class SavingAccountTest {
	
	@Test
	public void testCreateAccount() {
		int accountNumber = 1000;
		
		AccountNumberGenerator accountNumberGenerator = EasyMock.createMock(AccountNumberGenerator.class);
		EasyMock.expect(accountNumberGenerator.getAccountNumber()).andReturn(accountNumber);
		EasyMock.replay(accountNumberGenerator);

		AccountWritable account = new SavingAccount(accountNumberGenerator.getAccountNumber());
				
		Assert.assertNotEquals(account, null);

		Assert.assertEquals(accountNumber, account.getAcountNumber());
	}
	
	
	@Test
	public void checkForOverdrawnException() {
		int accountNumber = 1000;
		int amount = 100;
		
		AccountNumberGenerator accountNumberGenerator = EasyMock.createMock(AccountNumberGenerator.class);
		EasyMock.expect(accountNumberGenerator.getAccountNumber()).andReturn(accountNumber);
		EasyMock.replay(accountNumberGenerator);

		AccountWritable account = new SavingAccount(accountNumberGenerator.getAccountNumber());				
		
		try {
			account.book(-amount);
			Assert.fail();
		} catch (AccountOverdrawnException e) {
		}
	}
	
	@Test
	public void checkForBookingSuccess() throws AccountOverdrawnException {
		AccountNumberGenerator accountNumberGenerator = new AccountNumberGeneratorImpl();
		AccountWritable account = new SavingAccount(accountNumberGenerator.getAccountNumber());				
		int amount = 100;
		
		account.book(amount);
		
		Assert.assertEquals(amount, account.getBalance());
	}

}
