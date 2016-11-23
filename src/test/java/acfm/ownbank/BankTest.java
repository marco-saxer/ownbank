package acfm.ownbank;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
/**
 * 
 * @author fabio.sulser
 *
 */
public class BankTest {

	@Before
	public void setup() {


	}

	@Test
	public void testCreateAccount() {
		AccountNumberGenerator accountNumberGenerator = new AccountNumberGeneratorImpl();
		Bank bank = new BankImpl(accountNumberGenerator);
		AccountWritable account = EasyMock.createMock(AccountWritable.class);
		EasyMock.expect(account.getAcountNumber()).andReturn(1001);
		EasyMock.replay(account);
		assertEquals(1001, bank.createAccount());
	}

	@Test
	public void testDeposit() throws Exception {
		int amount = 100;
		AccountNumberGenerator accountNumberGenerator = new AccountNumberGeneratorImpl();
		Bank bank = new BankImpl(accountNumberGenerator);
		int accountNr = bank.createAccount();
		AccountWritable account = EasyMock.createMock(AccountWritable.class);
		EasyMock.expect(account.getAcountNumber()).andReturn(accountNr);
		EasyMock.expect(account.getBalance()).andReturn(100);
		EasyMock.replay(account);
		bank.deposit(account.getAcountNumber(), amount);
		assertEquals(amount, bank.getBalance(accountNr));

	}

	@Ignore
	@Test
	public void testWithdrawal() throws Exception {
		int amount = 10;
		int expectedAmount = -100;

		AccountNumberGenerator accountNumberGenerator = new AccountNumberGeneratorImpl();
		Bank bank = new BankImpl(accountNumberGenerator);
		int accountNr = bank.createAccount();
		AccountWritable account = EasyMock.createMock(AccountWritable.class);
		EasyMock.expect(account.getAcountNumber()).andReturn(accountNr);
		EasyMock.expect(account.getBalance()).andReturn(200);
		EasyMock.replay(account);
		bank.withdrawal(account.getAcountNumber(), amount);
		assertEquals(expectedAmount, bank.getBalance(accountNr));

	}

	@Ignore
	@Test
	public void testTransfer() throws Exception {
		int amount = 100;
		AccountNumberGenerator accountNumberGenerator = new AccountNumberGeneratorImpl();
		Bank bank = new BankImpl(accountNumberGenerator);

		int accountFrom = bank.createAccount();
		int accountTo = bank.createAccount();

		AccountWritable accountFromMock = EasyMock.createMock(AccountWritable.class);
		AccountWritable accountToMock = EasyMock.createMock(AccountWritable.class);
		EasyMock.expect(accountFromMock.getBalance()).andReturn(-100);
		EasyMock.expect(accountToMock.getBalance()).andReturn(100);
		EasyMock.replay(accountFromMock);
		EasyMock.replay(accountToMock);

		bank.transfer(accountFrom, accountTo, amount);

		assertEquals(100, bank.getBalance(accountFrom));
		assertEquals(-100, bank.getBalance(accountTo));


	}


}
