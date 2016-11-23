package acfm.ownbank;
/**
 * 
 * @author fabio.sulser
 *
 */
public interface Account {

	public void book(int amount);
	
	public int getBalance();
	
	public int getAcountNumber();
}
