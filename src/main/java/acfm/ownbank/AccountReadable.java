package acfm.ownbank;
/**
 * 
 * @author fabio.sulser
 *
 */
public interface AccountReadable {

	public void book(int amount) throws AccountOverdrawnException;
	
}
