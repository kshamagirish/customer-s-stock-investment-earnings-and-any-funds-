
public class Cash {
	
	//Instance Variables 
	protected double balance = 0;
	protected double rate = 0;
	protected double interest_earned = 0;
	
	/*Constructor
	 * Takes in 1 parameter and initializes the instance variable
	 */
	public Cash(double r) {
		rate = r;
	}
	
	//Returns balance
	public double getBalance() {
		return balance;
	}
	
	//returns the interest rate
	public double getInterestRate() {
		return rate;
	}
	
	//returns the interest earned
	public double getInterestEarned() {
		return interest_earned;
	}
	
	//sets the interest rate
	public void setInterestRate(double r) {
		rate = r;
	}
	
	//subtracts the amount parameter from the balance
	public void transfer(double amount) {
		balance -= amount;
	}
	
	//calculates the interest earned over one month
	public void processDay() {
		if(balance > 0) {
			interest_earned = balance * (rate/365);
		}
	}
	
	//adds the interest to the balance and resets the interest earned
	public void processMonth() {
		balance += interest_earned;
		interest_earned = 0;
	}

}
