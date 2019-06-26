

public class Stock {
	
	//Instance Variables
	
	public String symbol;
	private CustomDate date;
	private double price;
	private double dividend_rate;
	private double shares;
	private double cost;
	private double capital_gains;
	
	/*Constructor
	 * Takes in 2 parameters and initializes the instance variables
	 */
	public Stock(String s, double p) {
		symbol = s;
		price = p;
	}
	
	/*Constructor
	 * Takes in 4 parameters and initializes the instance variables,
	 */
	public Stock(String s, double p, CustomDate day, double d) {
		symbol = s;
		price = p;
		date = day;
		dividend_rate = d;
	}
	
	//Returns the Ticker Symbol Of The Stock
	public String getTickerSymbol() {
		return symbol;
	}
	
	//Returns The Current Price Of The Stock
	public double getCurrentPrice() {
		return price;
	}
	
	//Returns the Dividend Rate Of The Stock
	public double getDividendRate() {
		return dividend_rate;
	}
	
	//Returns the CustomDate object which represents the Dividend Date
	public CustomDate getDividendDate() {
		return date;
	}
	
	//Sets the current price
	public void setCurrentPrice(double p) {
		price = p;
	}
	
	//Sets the current dividend rate
	public void setDividendRate(double d) {
		dividend_rate = d;
	}
	
	//Sets the current dividend date
	public void setDividendDate(CustomDate d) {
		date = d;
	}
	
	//Gets the number of shares
	public double getNumberShares() {
		return shares;
	}
	
	//returns the cost basis of the stock
	public double getCostBasis() {
		return cost;
	}
	
	//returns the capital gains
	public double getCapitalGains() {
		return capital_gains;
	}
	
	//calculates the dividend rate and returns it
	public double payDividend() {
		return (dividend_rate * shares);
	}
	
	//buys shares and alters the variables accordingly.
	public double buy(int shareNum, double commission) {
		shares += shareNum; //Increments user shares
		double costIncrease = (shareNum * price) + commission; //calculates the increase in the stock cost basis
		cost += costIncrease; 
		return costIncrease; // returns how much it was increased by
	}
	
	//sells off the shares and returns the profit made.
	public double sell(int shareSold, double commission) {
		if(shareSold > shares) { //Checks to see if the user has enough shares to sell. 
			return 0;
		} else {
			shares -= shareSold; //Decreases the number of shares
			double costDecrease = (shareSold / shares); //calculates the decrease in the stock cost basis
			double capitalIncrease = ((shareSold * price) - commission) - costDecrease; //calculates the increase in capital gains
			cost -= costDecrease; 
			capital_gains += capitalIncrease; 
			return ((shareSold * price) - commission); // returns the profit made
		}
	}
	
	//Divides the shares by the ratio given in the parameters
	public double split(int numerator, int denominator) {
		if(numerator == 0 || denominator == 0) { //checks to see if it is a proper ratio
			return 0;
		}
		double ratio = ((double) numerator) /  ((double) denominator);
		shares = shares * ratio; // multiplies the shares by the ratio
		
		if((shares % 1) == 0) { //if it results in a whole number of stock, return nothing.
			return 0;
		} else { // this is the case where there is some fraction of a stock
			int shareCount = (int) shares;
			double shareDifference = shareCount - shares;
			double shareFrac = Math.abs(shareDifference);
			shares -= shareFrac; 
			double costDecrease = (shareFrac / shares);
			double capitalIncrease = ((shareFrac * price)) - costDecrease; //calculates capital gains increase
			cost -= costDecrease;
			capital_gains += capitalIncrease;
			return (shareFrac * price); //returns profit made from fractional share
		}
	}
}
