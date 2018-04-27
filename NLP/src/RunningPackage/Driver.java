package RunningPackage;

import CalendarSupport.Calendar;
import CalendarSupport.DayName;
import CompanySupport.Company;

/**
 * Main class for predictor software.
 * 
 * Task 1-
 * Get the indecies filled
 * Get a company populated
 * Calculate corrolation
 * 
 * Task 2-
 * Get leading company filled
 * Calculate corrolation
 * 
 * @author Austin
 */
public class Driver 
{
	
	public static void main (String[] args)
	{
		Company test = new Company("Krusty Krab", "KK", "fast food", "", "Eugene Krabs", new Calendar(false, 2017, DayName.SUNDAY));
		
		System.out.println("Company: " + test.getName());
		System.out.println("Stock Symbol: " + test.getSymbol());
		System.out.println("Industry: " + test.getIndustry());
		System.out.println("Owner: " + test.getPresident());
		test.getCalender().printAllEvents();
	}
}
