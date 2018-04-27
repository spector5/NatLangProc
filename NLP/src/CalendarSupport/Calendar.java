package CalendarSupport;

import java.util.ArrayList;
import CalendarSupport.Month;
/***********************************************************************
 * Class that represents calendar for a specific year. Class is made
 * with basic events such as holidays.
 * @author Austin
 ***********************************************************************/
public class Calendar 
{
	private boolean isLeapYear;
	private ArrayList<Month> months;
	private int year;
	private final int NUM_MONTHS = 12;
	private final int LONG_MONTH = 31;
	private final int SHORT_MONTH = 30;
	private final int WEEK_LEN = 7;
	
	// constructors
	/*****************************************************************************************
	 * Constructor, will fill calendar with basic, recurring events (like regular holidays)
	 * @param leap = true if leap year
	 *****************************************************************************************/
	public Calendar(boolean leap, int year, DayName firstDay)
	{
		this.year = year;
		this.isLeapYear = leap;
		months = new ArrayList<>();
		
		// fill basic calender
		months.add(new Month("January", "Winter", 1, year));
		months.add(new Month("February", "Winter", 1, year));
		months.add(new Month("March", "Spring", 1, year));
		months.add(new Month("April", "Spring", 2, year));
		months.add(new Month("May", "Spring", 2, year));
		months.add(new Month("June", "Summer", 2, year));
		months.add(new Month("July", "Summer", 3, year));
		months.add(new Month("August", "Summer", 3, year));
		months.add(new Month("September", "Fall", 3, year));
		months.add(new Month("October", "Fall", 4, year));
		months.add(new Month("November", "Fall", 4, year));
		months.add(new Month("December", "Winter", 4, year));
		
		months.get(0).addDay(new Day(1, DayName.SUNDAY, months.get(0), year));
		boolean isLong = true;
		DayName day = firstDay;
		for (int i = 0; i < NUM_MONTHS; i++)
		{
			Month m = months.get(i);
			if (m.getName().equals("February"))
			{
				if (isLeapYear)
				{
					for (int l = 0; l < 29; l++)
						m.addDay(new Day(i + 1, day, m, year));
				}
				else
				{
					for (int l = 0; l < 29; l++)
						m.addDay(new Day(i + 1, day, m, year));
				}
				
				isLong = true;
			}
			else if (m.getName().equals("August"))
			{
				for (int l = 0; l < LONG_MONTH; l++)
					m.addDay(new Day(i + 1, day, m, year));
					
				isLong = false;
			}
			else if (isLong)
			{
				for (int l = 0; l < LONG_MONTH; l++)
					m.addDay(new Day(i + 1, day, m, year));
					
				isLong = false;
			}
			else
			{
				for (int l = 0; l < SHORT_MONTH; l++)
					m.addDay(new Day(i + 1, day, m, year));
					
				isLong = true;
			}
		}
		
		// add events
		months.get(0).getDay(0).addEvent(new Event("New Years Day", true, "1/1", 1, TimeUnit.Day));
		months.get(1).getDay(1).addEvent(new Event("Groundhogs Day", true, "2/2", 1, TimeUnit.Day));
		months.get(1).getDay(13).addEvent(new Event("Valentines Day", true, "2/14", 1, TimeUnit.Day));
		months.get(2).getDay(19).addEvent(new Event("March Equinox", true, "3/20", 1, TimeUnit.Day));
		months.get(3).getDay(17).addEvent(new Event("Tax Day", true, "4/18", 1, TimeUnit.Day));
		months.get(4).getDay(4).addEvent(new Event("Cinco De Mayo", true, "5/5", 1, TimeUnit.Day));
		months.get(5).getDay(20).addEvent(new Event("June Solstice", true, "6/21", 1, TimeUnit.Day));
		months.get(6).getDay(3).addEvent(new Event("Independence Day", true, "7/4", 1, TimeUnit.Day));
		months.get(9).getDay(30).addEvent(new Event("Halloween", true, "10/31", 1, TimeUnit.Day));
		months.get(11).getDay(24).addEvent(new Event("Christmas", true, "12/25", 1, TimeUnit.Day));
	}
	// end constructors
	
	/*************************************************
	 * Print whole calendar and events on each day
	 *************************************************/
	public void printAllEvents()
	{
		for (int i = 0; i < months.size(); i++)
		{
			System.out.println(months.get(i).getName());
			ArrayList<Day> list = months.get(i).getDays();
			
			for (int q = 0; q < list.size(); q++)
			{
				System.out.print(list.get(q).getDayOfWeek() + " " + list.get(q).getDate(q) + ": ");
				ArrayList<Event> ev = list.get(q).getEvents();
				
				for (int w = 0; w < ev.size(); w++)
				{
					System.out.print(ev.get(w).getName() + "  ");
				}
				System.out.println();
			}
		}
	}
}
