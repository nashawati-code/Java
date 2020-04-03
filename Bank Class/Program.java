package bank;

import java.util.ArrayList;
import java.util.Random;

public class Program {
	
	private static String[] firstNames = {"Marquita", "Lachelle", "Rusty", "Lucie", "Elwood", "Hank"};
	private static String[] lastNames = {"Goospaster", "Montague", "Mulligan", "Rose", "Abdullah", "Hellmann"}; 

	public static void main(String[] args) {
		
		Random random = new Random();
		Bank cityBank = new Bank("City Bank");
		ArrayList<Customer> customers;
		
		for(int i = 0; i < firstNames.length; i++) {
			cityBank.addCustomer(firstNames[i], lastNames[i], String.format("%04d", random.nextInt(10000)));
		}
				
		customers = cityBank.getCustomers();
		
		for(Customer customer: customers) {
			
			// Open a random number of accounts of a random type for every customer
			for(int i = 0; i < random.nextInt(4) + 1; i++)	
			customer.openAccount(AccountTypeEnum.values()[random.nextInt(AccountTypeEnum.values().length)], random.nextInt(100000), cityBank);
			
			
			// Randomly do a cash withdrawal transactions for customer
			if(random.nextInt(2) == 0) {
				CashWithdrawalTransaction transaction = new CashWithdrawalTransaction(random.nextInt(100000) ,customer.getAccounts().get(random.nextInt(customer.getAccounts().size())));
			}
				
			
		}
		
		
		// Account transfer transactions for a customer
		ArrayList<Account> firstCustomer = customers.get(0).getAccounts();
		Account firstAccount = firstCustomer.get(0);
		ArrayList<Account> secondCustomer = customers.get(1).getAccounts();
		Account secondAccount = firstCustomer.get(0);			
		AccountTransferTransaction transaction = new AccountTransferTransaction(random.nextInt(100000), firstAccount, secondAccount);
		
		// CheckTransaction
		CheckTransaction checkTransaction = new CheckTransaction(random.nextInt(100000), customers.get(3).getAccounts().get(0), 1);
				
		/*______________________ Output ______________________*/
		System.out.println(cityBank.toString());
		
	}
	
}
