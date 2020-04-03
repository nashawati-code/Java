package bank;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class Account {
	
	private String accountNumber;
	private Map<String, Transaction> mapTransactions;
	private double balance;
	private Customer customer;
	private Bank bank;
	protected static int lastAccountNumber;
	
	protected abstract String getNewAccountNumber();
	protected abstract String getAccountType();
	
	
	private Account() {
		this.mapTransactions = new HashMap<>();
		this.accountNumber = getNewAccountNumber() + "00000" + ++lastAccountNumber; // pad properly (According to output)
	}
	
	public Account(double initialBalance, Customer customer, Bank bank) {
		this();
		
		final CashDepositTransaction deposit = new CashDepositTransaction(initialBalance, this);
		mapTransactions.put(deposit.getTransactionNumber(), deposit);
		
		this.balance = initialBalance; //transact.getAmount();
		this.customer = customer;
		this.bank = bank;
	}
		
	public void deposit(double amount) {
		this.increaseBalance(amount);
		final CashDepositTransaction deposit = new CashDepositTransaction(amount, this);
		this.addTransaction(deposit);
	}
	
	public Map<String, Transaction> getTransactions() {
		return this.mapTransactions;
	}
	
	public String getAccountNumber() {
		return this.accountNumber;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	@Override
	public String toString() {
		String output = this.getAccountType() + "\t| " + this.getAccountNumber() + "\t| $\t" + this.getBalance();
		return output;
		
	}
	
	protected void increaseBalance(double amount) {
		this.balance += amount;
	}
	
	protected void decreaseBalance(double amount) {
		this.balance -= amount;
	}
	
	public Bank getBank() {
		return this.bank;
	}
	
	public Customer getCustomer() {
		return this.customer;
	}
	
	protected void addTransaction(Transaction transaction) {
		this.mapTransactions.put(transaction.getTransactionNumber(), transaction);
	}
	
	public int getTransanctionCount() {
		return this.mapTransactions.size();
	}
	
	public void transferTo(Account toAccount, double amount) {
		Transaction withdraw = new CashWithdrawalTransaction(amount, this);
		this.addTransaction(withdraw);
		Transaction deposit = new CashDepositTransaction(amount, toAccount);
		toAccount.addTransaction(deposit);
	}


}


