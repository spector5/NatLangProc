package RunningPackage;

import java.io.IOException;
import java.util.ArrayList;

import CalendarSupport.Calendar;
import CalendarSupport.DayName;
import CompanySupport.Company;
import CompanySupport.EntityOperations;
import CompanySupport.Index;

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
 * TODO weekend prices are 0, market isn't open and haven't figured out how to deal with this
 * 
 * @author Austin
 */
public class Driver 
{
	
	public static void main (String[] args) throws IOException
	{
		ArrayList<Calendar> nasCal = new ArrayList<>();
		nasCal.add(new Calendar(false, 2013, DayName.TUESDAY));
		Index nas = new Index("NASDAQ", "^IXIC", nasCal);
		ArrayList<Calendar> krabCal = new ArrayList<>();
		krabCal.add(new Calendar(false, 2013, DayName.TUESDAY));
		Company krab = new Company("Krusty Krab", "KK", "fast food", null, "Eugene Krabs", krabCal);
		
		nas.fillCalenderWithPrice("1/1/2013", "12/31/2013");
		krab.fillCalenderWithPrice("1/1/2013", "12/31/2013");
		
		EntityOperations.calcCorrelation(krab,  nas);

	}
}
