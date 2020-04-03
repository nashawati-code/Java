package bank;

import java.util.Date;

public abstract class Transaction {

	// <<autogen>> stereotype
	private Date transactionDate;
	private double amount;
	private Account sourceAccount;
	private String transactionNumber;
	private static long lastTransactionNumber;
	
	
	private Transaction() {
		this.transactionDate = new Date();
		transactionNumber = String.format("%010d", ++lastTransactionNumber);
	}
	
	public Transaction(double amount, Account sourceAccount) {
		this();
		this.amount = amount;
		this.sourceAccount = sourceAccount;
	}
	
	public String getTransactionNumber() {
		return transactionNumber;
	}
	
	public Date getTransactionDate() {
		return this.transactionDate;
	}
	
	public double getAmount() {
		return this.amount;
	}
	
	public Account getSourceAccount() {
		return this.getSourceAccount();
	}

	@Override
	public String toString() {
		return this.getTransactionDate().toString() + "\t|" + this.getTransactionType() + "\t|" + transactionNumber + "|$\t" + this.getAmount();
	}
	
	public abstract String getTransactionType();
	
}
