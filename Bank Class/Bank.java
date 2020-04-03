package bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Bank {

	private String bankName;
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private ArrayList<Account> accounts = new ArrayList<Account>();
	private float currentInterestRate;
	private int numberOfCustomers;
	private int numberOfAccounts;
	private static Random r;
	
	public Bank(String bankName) {
		this.bankName = bankName;
		// Set interest rate
		r = new Random();
		currentInterestRate = r.nextFloat() * 5;
	}
	
	public ArrayList<Customer> getCustomers() {
		return this.customers;
	}
	
	public String getBankName() {
		return this.bankName;
	}
	
	public void addCustomer(String firstName, String lastName, String nssf) {
		customers.add(new Customer(firstName, lastName, nssf));
		numberOfCustomers++;
	}
	
	public Account getAccounts() {
		return this.getAccounts();
	}
	
	public int getCustomerCount() {
		return this.numberOfCustomers;
	}
	
	public int getAccountCount() {
		return this.numberOfAccounts;
	}
	
	public double getTotalDeposits() {

		double totalDeposit = 0;
		
		for(Account account : accounts) {
			totalDeposit += account.getBalance();
		}
		
		return totalDeposit;

	}
	
	public float getCurrentInterestRate() {
		return this.getCurrentInterestRate();
	}

	@Override
	public String toString() {
		
		String output = this.getBankName() + 
		"\n" + this.getCustomerCount() + " customers" +
		"\n" + this.getAccountCount() + " accounts" +
		"\n$ " + this.getTotalDeposits() + " in total deposits" +
		"\nCustomers:";
		
		for(Customer customer: this.getCustomers()) {
			output += "\n\t***  " + customer.firstName + " " + customer.lastName + "  ***\n\tCustomer Accounts:";
			
			
			for(Account account: customer.getAccounts()) {
				// Account
				output += "\n\t\t" + account.toString();
				
				// Transactions
				output += "\n\t\t\tTransactions:";
				for(Transaction transaction: account.getTransactions().values()) {
					output += "\n\t\t\t" + transaction.toString();
				}
			
			}
			
			// Separate Customers
			output += "\n";
		}
		
		output += "All Bank Accounts:\n";
		
		for(Account account: accounts) {
			// Account
			output += "\n\t\t" + account.toString();
			
			// Transactions
			output += "\n\t\t\tTransactions:";
			for(Transaction transaction: account.getTransactions().values()) {
				output += "\n\t\t\t" + transaction.toString();
			}
		}
		
		return output;
		
	}
	
	public void addAccount(Account account) {
		accounts.add(account);
		this.numberOfAccounts++;
	}
	
}
