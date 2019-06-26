
public class Customer {
	
	//instance Variables and Objects 
	private String first_name, last_name;
	private Stock stock;
	private Savings savings;
	private Loan loan;
	private CustomDate date;
	private double commission;
	
	/*Constructor
	 * Takes in 7 parameters and initializes the instance variables and objects
	 */
	public Customer(String fn, String ln, Stock st, Savings sa, Loan l, CustomDate d, double c) {
		first_name = fn;
		last_name = ln;
		stock = st;
		savings = sa;
		loan = l;
		date = d;
		commission = c;
	}
	
	//returns first name
	public String getFirstName() {
		return first_name;
	}
	
	//returns last name
	public String getLastName() {
		return last_name;
	}
	
	//returns stock object
	public Stock getStock() {
		return stock;
	}
	
	//returns savings object
	public Savings getSavings() {
		return savings;
	}
	
	//returns loan object
	public Loan getLoan() {
		return loan;
	}
	
	//returns commission amount
	public double getCommissionAmount() {
		return commission;
	}
	
	//returns the custom date object
	public CustomDate getDate() {
		return date;
	}
	
	//sets the first name
	public void setFirstName(String fn) {
		first_name = fn;
	}
	
	//sets the last name
	public void setLastName(String ln) {
		last_name = ln;
	}
	
	//sets the stock object
	public void setStock(Stock s) {
		stock = s;
	}
	
	//sets the commission amount
	public void setCommissionAmount(double c) {
		commission = c;
	}
	
	//sets the date object
	public void setDate(CustomDate d) {
		date = d;
	}
	
	//returns the current value of stock and savings minus loan owed
	public double currentValue() {
		return ((savings.getBalance() + (stock.getCurrentPrice() * stock.getNumberShares())) - loan.getBalance());
	}
	
	//deposits money into savings
	public void deposit(double amount) {
		savings.deposit(amount);
	}
	
	//pays off loan by amount
	public void payLoan(double amount) {
		loan.transfer(amount);
	}
	
	//takes money out and returns whether or not it went through
	public boolean withdraw(double amount) {
		if(amount < savings.getBalance()) {
			savings.transfer(amount);
			return true;
		} else {
			return false;
		}
	}
	
	//sells shares and adds profit to savings account
	public void sellShares(int shareCount, String ticker) {
		if(ticker == stock.getTickerSymbol()) {
			double money = stock.sell(shareCount, commission);
			savings.deposit(money);
		}
	}
	
	//checks if the stock symbol is correct and if the user has enough money to purchase the stock. if they do it takes the money from savings and returns true. returns false if no.
	public boolean buyShares(int shareCount, String ticker) {
		if(ticker == stock.getTickerSymbol() && currentValue() >= (shareCount * stock.getCurrentPrice()))  {
			double money = stock.buy(shareCount, commission);
			savings.transfer(money);
			return true;
		}
		return false;
	}
	
	/*
	 * increments the date of the custom date object
	 * if the month and year are the same as the dividend date, the dividend is deposited in the savings account
	 * if the balance of savings is less than zero, the negative balance is passed to the loan and the savings balance is set to 0
	 * it then processes the days for the savings account and the loan
	 * if its the first of the month, then process the month method
	 */
	public void incrementDate() {
		date.incrementDay();
		if(date.equals(stock.getDividendDate())) {
			double money = stock.payDividend();
			savings.deposit(money);
		}
		if(savings.getBalance() < 0) {
			loan.transfer(savings.getBalance());
			savings.balance = 0;
		}
		savings.processDay();
		loan.processDay();
		if(date.getDay() == 1) {
			savings.processMonth();
			loan.processMonth();
		}
		
	}
 	
}
