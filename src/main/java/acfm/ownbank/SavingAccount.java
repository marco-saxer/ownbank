package acfm.ownbank;

public class SavingAccount extends AbstractAccount{

	public SavingAccount(int accountNumber) {
		super(accountNumber);
	}

	@Override
	boolean verifyBookingCondition(int amount) {
		return (getBalance() + amount >= 0);		
	}

}
