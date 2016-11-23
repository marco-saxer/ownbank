package acfm.ownbank;
/**
 * 
 * @author fabio.sulser
 *
 */
public abstract class AbstractAccount implements Account{
	private int balance;
	private int accountNumber;
	
	public AbstractAccount(int accountNumber){
		this.balance = 0;
		this.accountNumber = accountNumber;
	}
	
	public void book(int amount){
		balance += amount;
	}
	
	public int getBalance(){
		return balance;
	}
	
	public int getAcountNumber(){
		return accountNumber;
	}
	
}
