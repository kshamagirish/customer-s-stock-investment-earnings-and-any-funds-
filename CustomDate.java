

public class CustomDate {
	
	//Instance Variables 
	private int day;
	private int month;
	private int year;
	
	/*Constructor
	 * Takes in 3 parameters and initializes the instance variables
	 */
	public CustomDate(int d, int m, int y) {
		day = d;
		month = m;
		year = y;
	}
	
	
	//Returns Day
	public int getDay() {
		return day;
	}
	
	//Returns Month
	public int getMonth() {
		return month;
	}
	
	//Returns Year
	public int getYear() {
		return year;
	}
	
	
	/*Increments every day
	 * Switch case uses the month to check if it is the last day of the month
	 * If it is, then it rolls over to the next day and sets the day to 1
	 * if it is month 12, it rolls the year and month over and sets day to 1
	 */
	public void incrementDay() {
		switch(month) { // This uses the month variable and goes to the case declaration which matches it. 
		case 1:
			if(day == 31) {
				month++;
				day = 1;
			} else {
				day++;
			}
			break;
		case 2:
			if(day == 28) {
				month++;
				day = 1;
			} else {
				day++;
			}
			break;
		case 3:
			if(day == 31) {
				month++;
				day = 1;
			} else {
				day++;
			}
			break;
		case 4:
			if(day == 30) {
				month++;
				day = 1;
			} else {
				day++;
			}
			break;
		case 5: 
			if(day == 31) {
				month++;
				day = 1;
			} else {
				day++;
			}
			break;
		case 6:
			if(day == 30) {
				month++;
				day = 1;
			} else {
				day++;
			}
			break;
		case 7:
			if(day == 31) {
				month++;
				day = 1;
			} else {
				day++;
			}
			break;
		case 8:
			if(day == 31) {
				month++;
				day = 1;
			} else {
				day++;
			}
			break;
		case 9:
			if(day == 30) {
				month++;
				day = 1;
			} else {
				day++;
			}
			break;
		case 10:
			if(day == 31) {
				month++;
				day = 1;
			} else {
				day++;
			}
			break;
		case 11:
			if(day == 30) {
				month++;
				day = 1;
			} else {
				day++;
			}
			break;
		case 12:
			if(day == 31) {
				year++;
				month = 1;
				day = 1;
			} else {
				day++;
			}
			break;
		}
		
				
	}
	
	//Returns the date in US month-day-year format
	public String toString() {
		return (month + "/" + day + "/" + year);
	}
	
	//Checks if two dates are equal by comparing their day, month, and year values
	public boolean equals(CustomDate d) {
		if(d.getDay() == day && d.getMonth() == month) {
			return true;
		} else {
			return false;
		}
	}
}
