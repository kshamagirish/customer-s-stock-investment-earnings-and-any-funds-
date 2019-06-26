
public class Savings extends Cash {
	
	/*Constructor
	 * Takes in 1 parameter and initializes the instance variable
	 */
	public Savings(double r) {
		super(r);
	}
	
	//Adds to the balance a specified amount
	public void deposit(double amount) {
		balance += amount;
	}
	
	//takes out money in a specified amount
	public boolean withdraw(double amount) {
		if(amount <= balance) {
			balance -= amount;
			return true;
		} else {
			return false;
		}
	}
}
