
public class TestClass {
	public static void main(String[] args) {
		
		//CustomDate Class Test
		
		CustomDate c1 = new CustomDate(14, 3, 15);
		CustomDate c2 = new CustomDate(31, 1, 18);
		CustomDate c3 = new CustomDate(31, 12, 17);
		
		System.out.println("Result From Accessor Methods Of Date 1: " + c1.getMonth() + "/" + c1.getDay() + "/" + c1.getYear());
		
		c1.incrementDay();
		c2.incrementDay();
		c3.incrementDay();
		
		System.out.println("Result From Day Incrementation Of Date 1: " + c1.getMonth() + "/" + c1.getDay() + "/" + c1.getYear());
		System.out.println("Result From Day Incrementation Of Date 2: " + c2.getMonth() + "/" + c2.getDay() + "/" + c2.getYear());
		System.out.println("Result From Day Incrementation Of Date 3: " + c3.getMonth() + "/" + c3.getDay() + "/" + c3.getYear());
		
		System.out.println("Result From  toString Method Of Date 1: " + c1.toString());
		
		CustomDate c4 = new CustomDate(15, 3, 15);
		
		System.out.println("Result From Date Equality Function For Date 1 and 4: " + c1.equals(c4));
		System.out.println("Result From Date Equality Function For Date 2 and 3: " + c2.equals(c3));
		
		System.out.println(" ");
		
		//Stock Class Test
		
		Stock s1 = new Stock("*/", 30.5);
		Stock s2 = new Stock("@$", 61, c1, .01);
		
		s1.setCurrentPrice(31);
		s2.setCurrentPrice(62);
		
		s1.setDividendRate(.01);
		s2.setDividendRate(.02);
		
		s1.setDividendDate(c2);
		s2.setDividendDate(c3);
		
		System.out.println("Stock 1 After Mutator Methods: " + "Price " + s1.getCurrentPrice() + " Dividend Rate: " + s1.getDividendRate() + " Dividend Date: " + s1.getDividendDate().toString());
		
		double costIncrease = s1.buy(5, 20);
		System.out.println("Result From Buying 5 shares of stock 1 at 20 commission: " + costIncrease);
		
		s2.buy(10, 20);
		double profit = s1.sell(1000, 10);
		System.out.println("Result From Selling more shares of stock than the user has: " + profit);
		profit = s1.sell(2, 10);
		System.out.println("Result From Selling 2 shares of stock 1 at 10 commission: " + profit);
		
		double splitProfit1 = s1.split(1, 3);
		System.out.println("Result From Splitting stock 1 into a whole number: " + splitProfit1);
		double splitProfit2 = s2.split(1, 3);
		System.out.println("Result (profit) From Splitting stock 2 into a fractional: " + splitProfit2);
		
		double dividend = s1.payDividend();
		
		System.out.println("Dividend From Stock 1: " + dividend);
		
		System.out.println("Result From Accessor Methods Of Stock 1: " + "Symbol: " + s1.getTickerSymbol() + " Price: " + s1.getCurrentPrice() + " Dividend Rate: " + s1.getDividendRate() + " Dividend Date: " + s1.getDividendDate().toString() + " Shares: " + s1.getNumberShares() + " Cost Basis: " + s1.getCostBasis() + " Capital Gains: " + s1.getCapitalGains());

		System.out.println(" ");
		
		//Cash Class Test
		
		Cash ca1 = new Cash(.017);
		
		ca1.balance = 2000;
		
		ca1.processDay();
		ca1.processDay();
		ca1.processDay();
		
		System.out.println("Result From Accessor Methods of Cash 1 Before Month: " + "Balance: " + ca1.getBalance() + " Interest Rate: " + ca1.getInterestRate() + " Interest Earned: " + ca1.getInterestEarned());
		ca1.processMonth();
		System.out.println("Result From Accessor Methods of Cash 1 After Month: " + "Balance: " + ca1.getBalance() + " Interest Rate: " + ca1.getInterestRate() + " Interest Earned: " + ca1.getInterestEarned());
		
		ca1.setInterestRate(.02);
		System.out.println("Result From The Mutator Method Altering Interest Rates: " +"Interest Rate: " + ca1.getInterestRate());
		System.out.println(" ");
		
		//Savings Class Test
		Savings sa1 = new Savings(.015);
		
		sa1.deposit(2000);
		System.out.println("Result From The Mutator Method Depositing Money of Savings 1: " +"Balance: " + sa1.getBalance());
		sa1.withdraw(2000);
		System.out.println("Result From The Mutator Method Withdrawing Money of Savings 1: " + "Balance: " + sa1.getBalance());
		System.out.println(" ");
		
		//Loan Class Test
		
		Loan l1 = new Loan(.02, 3000, 200);
		l1.setLoanLimit(4000);
		l1.setOverdraftPenalty(300);
		l1.balance = 4100;
		l1.processDay();
		System.out.println("Result From Accessor Methods of Loan 1 Before Month: " + "Balance: " + l1.getBalance() + " Overdraft Penalty: " + l1.getOverdraftPenalty() + " Interest Earned: " + l1.getInterestEarned());
		l1.processMonth();
		System.out.println("Result From Accessor Methods of Loan 1 After Month: " + "Balance: " + l1.getBalance() + " Overdraft Penalty: " + l1.getOverdraftPenalty() + " Interest Earned: " + l1.getInterestEarned());
		
		Loan l2 = new Loan(.02, 1000, 100);
		l2.balance = 500;
		l2.processDay();
		System.out.println("Result From Accessor Methods of Loan 2 Before Month: " + "Balance: " + l2.getBalance() + " Overdraft Penalty: " + l2.getOverdraftPenalty() + " Interest Earned: " + l2.getInterestEarned());
		l2.processMonth();
		System.out.println("Result From Accessor Methods of Loan 2 After Month: " + "Balance: " + l2.getBalance() + " Overdraft Penalty: " + l2.getOverdraftPenalty() + " Interest Earned: " + l2.getInterestEarned());
		System.out.println(" ");
		
		//Customer Class Test
		
		Stock s3 = new Stock("/c/", 20, c1, .015);
		Stock s4 = new Stock("/a/", 20, new CustomDate(30, 1, 18), .015);
		Savings sa2 = new Savings(.015);
		Loan l3 = new Loan(.015, 5000, 500);
		
		Customer customer = new Customer("John", "Titor", s3, sa2, l3, c1, 20);
		
		System.out.println("Result From Accessor Methods Of Customer: " + "Name: " + customer.getFirstName() + " " + customer.getLastName() + " Stock Ticker Symbol: " + customer.getStock().getTickerSymbol() + " Savings Interest Rate: " + customer.getSavings().getInterestRate() + " Loan Interest Rate: " + customer.getLoan().getInterestRate() + " Commission: " + customer.getCommissionAmount() + " Date: " + customer.getDate().toString());
		
		customer.setFirstName("Bob");
		customer.setLastName("Dylan");
		customer.setStock(s4);
		customer.setCommissionAmount(30);
		customer.setDate(new CustomDate(29, 1, 18));
		
		System.out.println("Result From Accessor Methods Of Customer After Mutator Calls: " + "Name: " + customer.getFirstName() + " " + customer.getLastName() + " Stock Ticker Symbol: " + customer.getStock().getTickerSymbol() + " Savings Interest Rate: " + customer.getSavings().getInterestRate() + " Loan Interest Rate: " + customer.getLoan().getInterestRate() + " Commission: " + customer.getCommissionAmount() + " Date: " + customer.getDate().toString());
		
		customer.deposit(300);
		boolean sold = customer.buyShares(1000, "/a/");
		
		System.out.println("Customer Value After Buying Shares But Failing: " + customer.currentValue() + " Actually Sold? " + sold);
		sold = customer.buyShares(5, "/a/");
		System.out.println("Customer Value After Buying Shares And Succeeding: " + customer.currentValue() + " Actually Sold? " + sold);
		
		customer.sellShares(5, "/a/");
		
		System.out.println("Customer Value After Selling Shares: " + customer.currentValue());

		sold = customer.buyShares(5, "/a/");
		customer.getSavings().balance = 300;
		System.out.println("Savings Balance Before Dividend Payed: " + customer.getSavings().balance);
		customer.incrementDate();
		System.out.println("Savings Balance After Dividend Payed: " + customer.getSavings().balance);
		
		customer.getSavings().balance = -500;
		System.out.println("Savings Balance Before Negative Balance Transfered To Loan: " + customer.getSavings().balance);
		customer.incrementDate();
		System.out.println("Savings Balance After Negative Balance Transfered To Loan: " + customer.getSavings().balance + " Loan Balance: " + customer.getLoan().balance);
		
		customer.deposit(500);
		System.out.println("Savings Balance and Loan Balance Before Month Changes: " + "Savings: " + customer.getSavings().balance + " Loan: " + customer.getLoan().balance);
		customer.incrementDate();
		System.out.println("Savings Balance and Loan Balance After Month Changes: " + "Savings: " + customer.getSavings().balance + " Loan: " + customer.getLoan().balance);
		
		customer.getSavings().balance = 550;
		customer.getLoan().balance = 500;
		
		System.out.println("Savings Balance and Loan Balance Before Paying Loan: " + "Savings: " + customer.getSavings().balance + " Loan: " + customer.getLoan().balance);
		customer.withdraw(500);
		customer.payLoan(500);
		System.out.println("Savings Balance and Loan After Before Paying Loan: " + "Savings: " + customer.getSavings().balance + " Loan: " + customer.getLoan().balance);
		
		
	}
}
