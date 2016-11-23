package acfm.ownbank;
/**
 * 
 * @author fabio.sulser
 *
 */
public class AccountImpl implements Account {

	private int balance;
	private int accNumber;
	private AccountNumberGenerator accountNumberGenerator;

	public AccountImpl(AccountNumberGenerator accountNumberGenerator) {
		this.balance = 0;
		this.accountNumberGenerator = accountNumberGenerator;
		this.accNumber = accountNumberGenerator.getAccountNumber();
	}

	public void book(int amount) {
		balance += amount;

	}

	public int getBalance() {

		return balance;
	}

	public int getAcountNumber() {
		return accNumber;
	}

}
