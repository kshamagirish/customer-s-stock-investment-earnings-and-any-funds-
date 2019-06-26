
public class Loan extends Cash{
	
	//Instance Variables
	private double loan_limit, penalty;
	private boolean overdrafted = false;
	
	/*Constructor
	 * Takes in 3 parameters and initializes the instance variables
	 */
	public Loan(double r, double l, double p) {
		super(r);
		loan_limit = l;
		penalty = p;
	}
	
	//returns the loan limit
	public double getLoanLimit() {
		return loan_limit;
	}
	
	//returns the overdraft penalty
	public double getOverdraftPenalty() {
		return penalty;
	}
	
	//sets the loan limit
	public void setLoanLimit(double l) {
		loan_limit = l;
	}
	
	//sets the overdraft penalty
	public void setOverdraftPenalty(double p) {
		penalty = p;
	}
	
	//calculates the interest earned on the loan and checks to see if it is overdrafted
	public void processDay() {
		if(balance > 0) {
			interest_earned = balance * (rate/365);
		}
		if(balance > loan_limit) {
			overdrafted = true;
		}
	}
	
	//adds the interest to the balance and checks if the loan is overdrafted.
	public void processMonth() {
		balance += interest_earned;
		interest_earned = 0;
		
		if(overdrafted) {
			balance += penalty;
		}
		overdrafted = false;
	}

}
