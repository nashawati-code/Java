package bank;

public class InterestEarnedTransaction extends Transaction {

	private String period;
	
	public InterestEarnedTransaction(double amount, Account sourceAccount, String period) {
		super(amount, sourceAccount);
		this.period = period;
		// Accrued interest
		double interest = (amount * sourceAccount.getBank().getCurrentInterestRate()) / 100;
		sourceAccount.increaseBalance(interest);
		sourceAccount.addTransaction(this);
	}
	
	public String getPeriod() {
		return this.getPeriod();
	}

	@Override
	public String getTransactionType() {
		return "Interest Earned";
	}
	
}
