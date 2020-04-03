package bank;

public class CashDepositTransaction extends Transaction {

	public CashDepositTransaction(double amount, Account sourceAccount) {
		super(amount, sourceAccount);
		sourceAccount.increaseBalance(amount);
		sourceAccount.addTransaction(this);
	}

	@Override
	public String getTransactionType() {
		return "Cash Deposit";
	}

}
