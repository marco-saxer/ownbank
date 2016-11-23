package acfm.ownbank;

public class AccountFactoryImpl implements AccountFactory {

	private AccountNumberGenerator accountNumberGenerator;

	public AccountFactoryImpl() {
		accountNumberGenerator = new AccountNumberGeneratorImpl();
	}

	public AccountReadable createAccount(int creditLine, AccountType accountType) throws AccountTypeException {
		AbstractAccount newAccount = null;
		int accNumber = accountNumberGenerator.getAccountNumber();
		switch (accountType) {
			case CREDIT_ACCOUNT:
				newAccount = new CreditAccount(accNumber, creditLine);
				break;
			case SAVING_ACCOUNT:
				newAccount = new SavingAccount(accNumber);
				break;
			default:
				throw new AccountTypeException();
		}

		return newAccount;
	}

}
