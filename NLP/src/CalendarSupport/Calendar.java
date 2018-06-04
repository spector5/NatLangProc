package CalendarSupport;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;
/***********************************************************************
 * Class that represents calendar for a specific. Class is made
 * with basic events such as holidays.
 * @author Austin
 ***********************************************************************/
@SuppressWarnings("serial")
public class Calendar implements Serializable
{
	private ArrayList<Year> years;	// list of all years
	
	// constructors
	/**
	 * Constructor
	 */
	public Calendar()
	{
		this.years = new ArrayList<>();	
	}
	// end constructors
	
	// getters and setters
	public void setYearList(ArrayList<Year> years)
	{
		this.years = years;
	}
	
	public ArrayList<Year> getYearList()
	{
		return this.years;
	}
	// end getters and setters
	
	public void addYear(Year yr)
	{
		years.add(yr);
	}
	
	public Day getDayRef(String date)
	{
		// iterate years
		StringTokenizer toke = new StringTokenizer(date, "/");
		int month = Integer.parseInt(toke.nextToken());
		int day = Integer.parseInt(toke.nextToken());
		int year = Integer.parseInt(toke.nextToken());
		int x = 0;
		
		while (x < years.size())
		{
			if (years.get(x).getYearNum() == year)
				break;
			x++;
		}
		
		return years.get(x).getMonthByIndex(month - 1).getDayByIndex(day - 1);
	}
	
	/*************************************************
	 * Print whole calendar and events on each day
	 *************************************************/
	public void printWholeCalendar()
	{
		for (int i = 0; i < years.size(); i++)
			years.get(i).printYear();
	}
}
