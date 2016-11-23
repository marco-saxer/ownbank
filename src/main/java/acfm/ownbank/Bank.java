package acfm.ownbank;
/**
 * 
 * @author fabio.sulser
 *
 */
public interface Bank {
	
	public int createAccount();
	
	public void deposit(int accNumber, int amount) throws AccountOverdrawnException;
	
	public void transfer(int accNumberFrom, int accNumberTo, int amount) throws AccountOverdrawnException;
	
	public void withdrawal(int accNumber, int amount) throws AccountOverdrawnException;
	
	public int getBalance(int accNumber);
	
	
}
