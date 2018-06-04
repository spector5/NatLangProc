package RunningPackage;

import java.io.IOException;

import CalendarSupport.Calendar;
import CalendarSupport.DayName;
import CalendarSupport.Year;
import CompanySupport.Company;
import CompanySupport.Index;

/**
 * Main class for predictor software.
 * 
 * Task 1- Completed 5/14
 * Get the indecies filled
 * Get a company populated
 * Calculate corrolation
 * 
 * Task 2-
 * Average all indecies
 * 
 * Task 3-
 * Get leading company filled
 * Calculate corrolation
 * 
 * TODO weekend prices are 0, market isn't open and haven't figured out how to deal with this
 * 
 * @author Austin
 */
public class Driver 
{
	
	public static void main (String[] args) throws IOException
	{
		Year twentyThirteen = new Year(2013, false, DayName.names.get(2));
		Calendar cal = new Calendar();
		cal.addYear(twentyThirteen);
		
		Index nas = new Index("NASDAQ", "^IXIC");
		Index sap = new Index("S&P 500", "^GSPC");
		Company krab = new Company("Krusty Krab", "KK", "fast food", null, "Eugene Krabs");

		nas.fillEntityWithPrice("1/1/2012", "12/25/2013", cal);
		sap.fillEntityWithPrice("3/1/2013", "3/11/2013", cal);
		krab.fillEntityWithPrice("3/1/2013", "3/11/2013", cal);

		//EntityOperations.calcCorrelation(krab,  nas);
		//EntityOperations.combineIndices(nas, sap);
	}
}
