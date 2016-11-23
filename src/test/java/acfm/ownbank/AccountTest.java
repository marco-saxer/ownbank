package acfm.ownbank;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;


public class AccountTest {

	AccountNumberGenerator accountNumberGenerator;

	@Before
	public void setup() {
		accountNumberGenerator = new AccountNumberGeneratorImpl();

	}

	@Test
	public void testBookAccount() {
		int amount = 100;
		Account account = new AccountImpl(accountNumberGenerator);

		assertEquals(0, account.getBalance());
		account.book(amount);
		assertEquals(amount, account.getBalance());

	}

	@Test
	public void testAccNumber() {
		// create mock
		AccountNumberGenerator accountNumberGenerator = EasyMock.createMock(AccountNumberGenerator.class);
		EasyMock.expect(accountNumberGenerator.getAccountNumber()).andReturn(10);

		EasyMock.replay(accountNumberGenerator);

		Account acc = new AccountImpl(accountNumberGenerator);

		assertEquals(10, acc.getAcountNumber());

		EasyMock.verify(accountNumberGenerator);


	}

}
