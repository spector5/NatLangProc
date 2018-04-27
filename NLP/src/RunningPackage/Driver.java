package RunningPackage;

import CalendarSupport.Calendar;
import CalendarSupport.DayName;
import CompanySupport.Company;

/**
 * Main class for predictor software.
 * 
 * Currently in testing state,
 * Alpha 0.1
 * 
 * Goals--------
 * 		Get company made
 * 		make full calendar for current year
 * 		populate test events
 * 		populate test price graph
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
