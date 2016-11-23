package acfm.ownbank;

public class CreditAccount extends AbstractAccount{

	private int creditLine;
	
	public CreditAccount(int accountNumber, int creditLine) {
		super(accountNumber);
		this.creditLine = creditLine;
	}
	
	@Override
	boolean verifyBookingCondition(int amount) {
		return getBalance() + amount < creditLine;
		
	}


}
