package bank;

public class CheckingAccount extends Account implements Withdraw, Deposit {

	public CheckingAccount(double initialBalance, Customer customer, Bank bank) {
		super(initialBalance, customer, bank);
	}
	
	public void writeCheck(double amount, int checkNumber) {

		CheckTransaction check = new CheckTransaction(amount, this, checkNumber);
	
	}

	@Override
	protected String getNewAccountNumber() {
		return "CHK";
	}

	@Override
	protected String getAccountType() {
		return "Checking";
	}

	@Override
	public void withdraw(double amount) {
		this.decreaseBalance(amount);
	}
	
	public void deposit(double amount) {
		super.deposit(amount);
	}

}
