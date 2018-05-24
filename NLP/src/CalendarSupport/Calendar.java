package CalendarSupport;

import java.io.Serializable;
import java.util.ArrayList;
import CalendarSupport.Month;
/***********************************************************************
 * Class that represents calendar for a specific. Class is made
 * with basic events such as holidays.
 * @author Austin
 ***********************************************************************/
public class Calendar implements Serializable
{
	private ArrayList<Year> years;	// list of all years
	
	// constructors
	/**
	 * Constructor
	 */
	public Calendar(boolean leap, int year, String firstDay)
	{
		this.years = new ArrayList<>();
		
		// add events that happen every year on the same day
		/* others to add
		 * easter, unknown date
		 */
		/*months.get(0).getDay(0).addEvent(new Event("New Years Day", true, "1/1", 1, TimeUnit.Day));
		months.get(1).getDay(1).addEvent(new Event("Groundhogs Day", true, "2/2", 1, TimeUnit.Day));
		months.get(1).getDay(13).addEvent(new Event("Valentines Day", true, "2/14", 1, TimeUnit.Day));
		months.get(3).getDay(14).addEvent(new Event("Tax Day", true, "4/15", 1, TimeUnit.Day));
		months.get(4).getDay(4).addEvent(new Event("Cinco De Mayo", true, "5/5", 1, TimeUnit.Day));
		months.get(6).getDay(3).addEvent(new Event("Independence Day", true, "7/4", 1, TimeUnit.Day));
		months.get(9).getDay(30).addEvent(new Event("Halloween", true, "10/31", 1, TimeUnit.Day));
		months.get(10).getDay(10).addEvent(new Event("Veterans Day", true, "11/11", 1, TimeUnit.Day));
		months.get(11).getDay(24).addEvent(new Event("Christmas", true, "12/25", 1, TimeUnit.Day));
		// month that change day each year
		// martin luther king day (third mon in jan)
		int days = 0;	// number of relevent days
		Month month = months.get(0);
		for (int i = 0; i < month.getLength(); i++)
		{
			if (month.getDay(i).getDayOfWeek().equals(DayName.MONDAY))
			{
				if (++days == 3) 
				{
					month.getDay(i).addEvent(new Event("Martin Luther King Jr. Day", true, "1/" + (i + 1), 1, TimeUnit.Day));
					break;
				}
			}
		}
		// presidents day (third mon in feb)
		days = 0;
		month = months.get(1);
		for (int i = 0; i < month.getLength(); i++)
		{
			if (month.getDay(i).getDayOfWeek().equals(DayName.MONDAY))
			{
				if (++days == 3) 
				{
					month.getDay(i).addEvent(new Event("Presidents Day", true, "2/" + (i + 1), 1, TimeUnit.Day));
					break;
				}
			}
		}
		// mothers day (second sun in may)
		days = 0;
		month = months.get(4);
		for (int i = 0; i < month.getLength(); i++)
		{
			if (month.getDay(i).getDayOfWeek().equals(DayName.SUNDAY))
			{
				if (++days == 2) 
				{
					month.getDay(i).addEvent(new Event("Mothers Day", true, "5/" + (i + 1), 1, TimeUnit.Day));
					break;
				}
			}
		}
		// memorial day (last mon in may)
		days = 0;
		month = months.get(4);
		for (int i = month.getLength() - 1; i >= 0; i--)
		{
			if (month.getDay(i).getDayOfWeek().equals(DayName.MONDAY))
			{
				if (++days == 1) 
				{
					month.getDay(i).addEvent(new Event("Memorial Day", true, "5/" + (i + 1), 1, TimeUnit.Day));
					break;
				}
			}
		}
		// fathers day (third sun in jun)
		days = 0;
		month = months.get(5);
		for (int i = 0; i < month.getLength(); i++)
		{
			if (month.getDay(i).getDayOfWeek().equals(DayName.SUNDAY))
			{
				if (++days == 3) 
				{
					month.getDay(i).addEvent(new Event("Fathers Day", true, "6/" + (i + 1), 1, TimeUnit.Day));
					break;
				}
			}
		}
		// labor day (first mon in sept)
		days = 0;
		month = months.get(8);
		for (int i = 0; i < month.getLength(); i++)
		{
			if (month.getDay(i).getDayOfWeek().equals(DayName.MONDAY))
			{
				if (++days == 1) 
				{
					month.getDay(i).addEvent(new Event("Labor Day", true, "9/" + (i + 1), 1, TimeUnit.Day));
					break;
				}
			}
		}
		// columbus day (second mon in oct)
		days = 0;
		month = months.get(9);
		for (int i = 0; i < month.getLength(); i++)
		{
			if (month.getDay(i).getDayOfWeek().equals(DayName.MONDAY))
			{
				if (++days == 2) 
				{
					month.getDay(i).addEvent(new Event("Columbus Day", true, "10/" + (i + 1), 1, TimeUnit.Day));
					break;
				}
			}
		}
		// thanksgiving (fourth thur in nov), black friday (day after easter), cyber monday (mon after thanksgiving)
		days = 0;
		month = months.get(10);
		for (int i = 0; i < month.getLength(); i++)
		{
			if (month.getDay(i).getDayOfWeek().equals(DayName.THURSDAY))
			{
				if (++days == 4) 
				{
					month.getDay(i).addEvent(new Event("Thanksgiving", true, "11/" + (i + 1), 1, TimeUnit.Day));
					month.getDay(i + 1).addEvent(new Event("Black Friday", true, "11/" + (i + 2), 1, TimeUnit.Day));
					if (i >= 26)
					{
						months.get(11).getDay((i + 4) - SHORT_MONTH)
							.addEvent(new Event("Cyber Monday", true, "12/" + ((i + 5) - SHORT_MONTH), 1, TimeUnit.Day));
					}
					else
						month.getDay(i + 4).addEvent(new Event("Cyber Monday", true, "11/" + (i + 5), 1, TimeUnit.Day));
					break;
				}
			}
		}*/
		
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
	
	/*************************************************
	 * Print whole calendar and events on each day
	 *************************************************/
	public void printWholeCalendar()
	{
		for (int i = 0; i < years.size(); i++)
			years.get(i).printYear();
	}
}
