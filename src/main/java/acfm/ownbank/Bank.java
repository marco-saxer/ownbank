package acfm.ownbank;
/**
 * 
 * @author fabio.sulser
 *
 */
public interface Bank {
	
	public int createAccount();
	
	public void deposit(int accNumber, int amount);
	
	public void transfer(int accNumberFrom, int accNumberTo, int amount);
	
	public void withdrawal(int accNumber, int amount);
	
	public int getBalance(int accNumber);
	
	
}
