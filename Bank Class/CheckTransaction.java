package bank;

public class CheckTransaction extends Transaction {

	private int checkNumber;
	
	public CheckTransaction(double amount, Account sourceAccount, int checkNumber) {
		super(amount, sourceAccount);
		this.checkNumber = checkNumber;
		sourceAccount.addTransaction(this);
	}
	

	@Override
	public String getTransactionType() {
		return "Check Transaction";
	}

	@Override
	public String toString() {
		return this.getTransactionDate().toString() + "\t|" + this.getTransactionType() + "\t|" + this.getTransactionNumber() + "|$\t" + this.getAmount() + "\t\tCheck#: " + this.checkNumber;
	}

	
}
