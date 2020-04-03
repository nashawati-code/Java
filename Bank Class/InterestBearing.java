package bank;

public interface InterestBearing {

	public void accrueMonthlyInterest(String period);
	public void setInterestRate(float interestRate);
	public float getInterestRate();
	
}
