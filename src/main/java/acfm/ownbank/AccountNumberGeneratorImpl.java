package acfm.ownbank;
/**
 * 
 * @author fabio.sulser
 *
 */
public class AccountNumberGeneratorImpl implements AccountNumberGenerator {

	int accountNumber = 1000;
	
	public int getAccountNumber() {
		// TODO Auto-generated method stub
		accountNumber++;
		return accountNumber;
	}

}
