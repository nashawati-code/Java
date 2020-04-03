package bank;

public class AccountTransferTransaction extends Transaction {

	private Account destinationAccount;

	public AccountTransferTransaction(double amount, Account sourceAccount, Account destinationAccount) {
		super(amount, sourceAccount);
		
		sourceAccount.decreaseBalance(amount);
		destinationAccount.increaseBalance(amount);
		
		this.destinationAccount = destinationAccount;
		
		sourceAccount.addTransaction(this);
	}

	@Override
	public String getTransactionType() {
		return "Account Transfer";
	}

	@Override
	public String toString() {
		return this.getTransactionDate().toString() + "\t|" + this.getTransactionType() + "\t|" + this.getTransactionNumber() + "|$\t" + this.getAmount() + "\t\tDestination Account: " + this.destinationAccount.getAccountNumber();
	}
	
	
	
}
