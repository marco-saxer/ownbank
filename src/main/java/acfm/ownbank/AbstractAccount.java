package acfm.ownbank;
/**
 * 
 * @author fabio.sulser
 *
 */
public abstract class AbstractAccount implements Account{
	private int balance;
	private int accountNumber;
	
	abstract boolean verifyBookingCondition(int amount);
	
	public AbstractAccount(int accountNumber){
		this.balance = 0;
		this.accountNumber = accountNumber;
	}
	
	public void book(int amount){
		if(!verifyBookingCondition(amount)){
			//TODO throw exception
		}
		balance += amount;
	}
	
	public int getBalance(){
		return balance;
	}
	
	public int getAcountNumber(){
		return accountNumber;
	}
	
}
