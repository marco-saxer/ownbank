package acfm.ownbank;

import static org.hamcrest.CoreMatchers.instanceOf;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author fabio.sulser
 *
 */
public class AccountFactoryTest {
	
	@Test
	public void testCreateSavingAccount() {
		int creditLine = 100;
				
		AccountFactory factory = new AccountFactoryImpl();
		
		AccountReadable accountReadable = factory.createAccount(creditLine, AccountType.SAVING_ACCOUNT);
		
		Assert.assertThat(accountReadable, instanceOf(SavingAccount.class));
	}
	
	@Test
	public void testCreateCreditAccount() {
		int creditLine = 100;
		
		AccountFactory factory = new AccountFactoryImpl();
		
		AccountReadable accountReadable = factory.createAccount(creditLine, AccountType.SAVING_ACCOUNT);
		
		Assert.assertThat(accountReadable, instanceOf(CreditAccount.class));
	}
}
