package acfm.ownbank;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class BankTest {

	@Before
	public void setup() {


	}

	@Test
	public void testCreateAccount() {
		AccountNumberGenerator accountNumberGenerator = new AccountNumberGeneratorImpl();
		Bank bank = new BankImpl(accountNumberGenerator);
		Account account = EasyMock.createMock(Account.class);
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
		Account account = EasyMock.createMock(Account.class);
		EasyMock.expect(account.getAcountNumber()).andReturn(accountNr);
		EasyMock.expect(account.getBalance()).andReturn(100);
		EasyMock.replay(account);
		bank.deposit(account.getAcountNumber(), amount);
		assertEquals(amount, bank.getBalance(accountNr));

	}

	@Test
	public void testWithdrawal() throws Exception {
		int amount = 100;
		int expectedAmount = -100;

		AccountNumberGenerator accountNumberGenerator = new AccountNumberGeneratorImpl();
		Bank bank = new BankImpl(accountNumberGenerator);
		int accountNr = bank.createAccount();
		Account account = EasyMock.createMock(Account.class);
		EasyMock.expect(account.getAcountNumber()).andReturn(accountNr);
		EasyMock.expect(account.getBalance()).andReturn(100);
		EasyMock.replay(account);
		bank.withdrawal(account.getAcountNumber(), amount);
		assertEquals(expectedAmount, bank.getBalance(accountNr));

	}

	@Test
	public void testTransfer() throws Exception {
		int amount = 100;
		AccountNumberGenerator accountNumberGenerator = new AccountNumberGeneratorImpl();
		Bank bank = new BankImpl(accountNumberGenerator);

		int accountFrom = bank.createAccount();
		int accountTo = bank.createAccount();

		Account accountFromMock = EasyMock.createMock(Account.class);
		Account accountToMock = EasyMock.createMock(Account.class);
		EasyMock.expect(accountFromMock.getBalance()).andReturn(-100);
		EasyMock.expect(accountToMock.getBalance()).andReturn(100);
		EasyMock.replay(accountFromMock);
		EasyMock.replay(accountToMock);

		bank.transfer(accountFrom, accountTo, amount);

		assertEquals(100, bank.getBalance(accountFrom));
		assertEquals(-100, bank.getBalance(accountTo));


	}


}
