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
	
	Map<Integer,Account> accounts = new HashMap();
	
	public BankImpl(AccountNumberGenerator generator) {
		super();
		this.generator = generator;
	}

	public int createAccount() {
		// TODO Auto-generated method stub
		Account accountNew = new AccountImpl(generator);	
		int accNumber = accountNew.getAcountNumber();
		accounts.put(accNumber,accountNew);
		return accNumber;
	}

	public void deposit(int accNumber, int amount) {
		// TODO Auto-generated method stub
		Account AccNew = accounts.get(accNumber);
		AccNew.book(amount);		
	}

	public void transfer(int accNumberFrom, int accNumberTo, int amount) {
		// TODO Auto-generated method stub	
		deposit(accNumberFrom,amount);withdrawal(accNumberTo,amount);
	}

	public void withdrawal(int accNumber, int amount) {
		// TODO Auto-generated method stub
		Account AccNew = accounts.get(accNumber);
		AccNew.book(-amount);	

	}

	public int getBalance(int accNumber) {
		// TODO Auto-generated method stub
		Account AccNew = accounts.get(accNumber);
		return AccNew.getBalance();
	}

}
