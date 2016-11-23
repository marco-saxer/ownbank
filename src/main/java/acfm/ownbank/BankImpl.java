package acfm.ownbank;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author fabio.sulser
 *
 */
public class BankImpl implements Bank {

	AccountNumberGenerator generator;
	
	Map<Integer,Account> accounts = new HashMap<Integer, Account>();
	
	public BankImpl(AccountNumberGenerator generator) {
		super();
		this.generator = generator;
	}

	public int createAccount() {
		Account accountNew = new SavingAccount(generator.getAccountNumber());	
		int accNumber = accountNew.getAcountNumber();
		accounts.put(accNumber,accountNew);
		return accNumber;
	}

	public void deposit(int accNumber, int amount) throws AccountOverdrawnException {
		Account AccNew = accounts.get(accNumber);
		AccNew.book(amount);		
	}

	public void transfer(int accNumberFrom, int accNumberTo, int amount) throws AccountOverdrawnException {
		deposit(accNumberFrom,amount);withdrawal(accNumberTo,amount);
	}

	public void withdrawal(int accNumber, int amount) throws AccountOverdrawnException {
		Account AccNew = accounts.get(accNumber);
		AccNew.book(-amount);	

	}

	public int getBalance(int accNumber) {
		Account AccNew = accounts.get(accNumber);
		return AccNew.getBalance();
	}

}
