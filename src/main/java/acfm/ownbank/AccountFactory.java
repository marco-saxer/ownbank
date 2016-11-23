package acfm.ownbank;

public interface AccountFactory {

	AccountReadable createAccount(int creditLine, AccountType accountType);

}
