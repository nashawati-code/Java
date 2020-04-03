package bank;

public class CashWithdrawalTransaction extends Transaction {

	public CashWithdrawalTransaction(double amount, Account sourceAccount) {
		super(amount, sourceAccount);
		sourceAccount.decreaseBalance(amount);
		sourceAccount.addTransaction(this);
	}

	@Override
	public String getTransactionType() {
		return "Cash Withdrawal";
	}

}
