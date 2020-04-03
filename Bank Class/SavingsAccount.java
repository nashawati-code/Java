package bank;

public class SavingsAccount extends Account implements InterestBearing, Withdraw {

	private float interestRate;
	
	@Override
	public void withdraw(double amount) {
		CashWithdrawalTransaction withdraw = new CashWithdrawalTransaction(amount, this);
	}

	@Override
	public void accrueMonthlyInterest(String period) {
		this.accrueMonthlyInterest(period);		
	}

	@Override
	public void setInterestRate(float interestRate) {
		this.interestRate = this.getBank().getCurrentInterestRate();
	}

	@Override
	public float getInterestRate() {
		return interestRate;
	}

	@Override
	protected String getNewAccountNumber() {
		return "SAV";
	}

	@Override
	protected String getAccountType() {
		return "Savings "; // Extra space to keep the output tab aligned
	}
	
	public SavingsAccount(double initialBalance, Customer customer, Bank bank) {
		super(initialBalance, customer, bank);
	}
	
}
