package acfm.ownbank;
/**
 * 
 * @author fabio.sulser
 *
 */
public interface Account {

	public void book(int amount) throws AccountOverdrawnException;
	
	public int getBalance();
	
	public int getAcountNumber();
}
