package acfm.ownbank;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;


public class AccountTest {

	Account account;

	@Before
	public void setup() {
		AccountNumberGenerator accountNumberGenerator = new AccountNumberGeneratorImpl();

		account = new AccountImpl(accountNumberGenerator);

	}

	@Test
	public void testBookAccount() throws Exception {
		int amount = 100;
		account.book(amount);
		assertEquals(amount, account.getBalance());

	}

	@Test
	public void testAccNumber() throws Exception {
		
		
		// create mock
		AccountNumberGenerator accountNumberGenerator = EasyMock.createMock(AccountNumberGenerator.class);
		EasyMock.expect(accountNumberGenerator.getAccountNumber()).andReturn(10);

		EasyMock.replay(accountNumberGenerator);
		
		Account acc = new AccountImpl(accountNumberGenerator);

		assertEquals(10, acc.getAcountNumber());

		EasyMock.verify(accountNumberGenerator);



	}

}
