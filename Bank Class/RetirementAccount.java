package bank;

public class RetirementAccount extends Account implements InterestBearing {

	private float interestRate;
	
	public RetirementAccount(double initialBalance, Customer customer, Bank bank) {
		super(initialBalance, customer, bank);
	}

	@Override
	public void accrueMonthlyInterest(String period) {
		this.accrueMonthlyInterest(period);
	}

	@Override
	public void setInterestRate(float interestRate) {
		this.setInterestRate(interestRate);
	}

	@Override
	public float getInterestRate() {
		return this.getInterestRate();
	}

	@Override
	protected String getNewAccountNumber() {
		return "RTR";
	}

	@Override
	protected String getAccountType() {
		return "Retirement";
	}

}
