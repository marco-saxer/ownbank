package acfm.ownbank;
/**
 * 
 * @author fabio.sulser
 *
 */
public abstract class AbstractAccount implements AccountWritable{
	private int balance;
	private int accountNumber;
	
	abstract boolean verifyBookingCondition(int amount);
	
	public AbstractAccount(int accountNumber){
		this.balance = 0;
		this.accountNumber = accountNumber;
	}
	
	public void book(int amount) throws AccountOverdrawnException{
		if(!verifyBookingCondition(amount)){
			throw new AccountOverdrawnException();
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
