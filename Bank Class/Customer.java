package bank;

import java.util.ArrayList;

public class Customer extends Person {

	private String customerNumber;
	private static int lastCustomerCount;
	private ArrayList<Account> accounts = new ArrayList<Account>();
	private String nssf;
	private int numberOfAccounts;
	
	
	public Customer(String firstName, String lastName, String nssf) {
		super(firstName, lastName);
		this.nssf = nssf;
		
		if(lastCustomerCount == 0) {
			lastCustomerCount = 998001;
			this.customerNumber = "C" + lastCustomerCount;
		} else {
			lastCustomerCount++;
			this.customerNumber = "C" + lastCustomerCount;
		}

	}
	
	public String getCustomerNumber() {
		return customerNumber;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public String getNSSF() {
		return nssf;
	}

	public int getNumberOfAccounts() {
		return numberOfAccounts;
	}
	
	public Account openAccount(AccountTypeEnum accountType, double initialBalance, Bank bank) {
		
		Account account = null;
		
		switch(accountType) {
		case Checking:
			account = new CheckingAccount(initialBalance, this, bank);
			bank.addAccount(account);
			break;
		case Retirement:
			account = new RetirementAccount(initialBalance, this, bank);
			bank.addAccount(account);
			break;
		case Savings:
			account = new SavingsAccount(initialBalance, this, bank);
			bank.addAccount(account);
			break;
		}
		
		this.accounts.add(account);
		this.numberOfAccounts++;
		return account;
	}

}
