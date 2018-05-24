package CalendarSupport;

import java.io.Serializable;
import java.util.ArrayList;

public class Year implements Serializable 
{
	private ArrayList<Month> months;
	private boolean isLeapYear;
	private int year;
	static final int NUM_MONTHS = 12;
	private final int SHORT_MONTH = 30;
	private final int LONG_MONTH = 31;
	private final int SHORT_FEB = 28;
	private final int LONG_FEB = 29;
	
	public Year(int year, boolean isLeap, String firstDay)
	{
		this.year = year;
		this.isLeapYear = isLeap;
		months = new ArrayList<>(12);
		
		// fill basic calendar of months
		months.add(new Month("January", "Winter", 1, LONG_MONTH, year, DayName.names.indexOf(firstDay)));
		if (isLeap)
			months.add(new Month("February", "Winter", 1, LONG_FEB, year, DayName.names.indexOf(months.get(0).getLastDay()) + 1));
		else
			months.add(new Month("February", "Winter", 1, SHORT_FEB, year, DayName.names.indexOf(months.get(0).getLastDay()) + 1));
		months.add(new Month("March", "Spring", 1, LONG_MONTH, year, DayName.names.indexOf(months.get(1).getLastDay()) + 1));
		months.add(new Month("April", "Spring", 2, SHORT_MONTH, year, DayName.names.indexOf(months.get(2).getLastDay()) + 1));
		months.add(new Month("May", "Spring", 2, LONG_MONTH, year, DayName.names.indexOf(months.get(3).getLastDay()) + 1));
		months.add(new Month("June", "Summer", 2, SHORT_MONTH, year, DayName.names.indexOf(months.get(4).getLastDay()) + 1));
		months.add(new Month("July", "Summer", 3, LONG_MONTH, year, DayName.names.indexOf(months.get(5).getLastDay()) + 1));
		months.add(new Month("August", "Summer", 3, LONG_MONTH, year, DayName.names.indexOf(months.get(6).getLastDay()) + 1));
		months.add(new Month("September", "Fall", 3, SHORT_MONTH, year, DayName.names.indexOf(months.get(7).getLastDay()) + 1));
		months.add(new Month("October", "Fall", 4, LONG_MONTH, year, DayName.names.indexOf(months.get(8).getLastDay()) + 1));
		months.add(new Month("November", "Fall", 4, SHORT_MONTH, year, DayName.names.indexOf(months.get(9).getLastDay()) + 1));
		months.add(new Month("December", "Winter", 4, LONG_MONTH, year, DayName.names.indexOf(months.get(10).getLastDay()) + 1));
		
		// add events that happen every year on the same day
		/* others to add
		 * easter, unknown date
		 */
		months.get(0).getDay(0).addEvent(new Event("New Years Day", true, "1/1", 1, TimeUnit.Day));
		months.get(1).getDay(1).addEvent(new Event("Groundhogs Day", true, "2/2", 1, TimeUnit.Day));
		months.get(1).getDay(13).addEvent(new Event("Valentines Day", true, "2/14", 1, TimeUnit.Day));
		months.get(2).getDay(19).addEvent(new Event("First Day of Spring", true, "3/20", 1, TimeUnit.Day));
		months.get(3).getDay(14).addEvent(new Event("Tax Day", true, "4/15", 1, TimeUnit.Day));
		months.get(4).getDay(4).addEvent(new Event("Cinco De Mayo", true, "5/5", 1, TimeUnit.Day));
		months.get(5).getDay(20).addEvent(new Event("First Day of Summer", true, "6/21", 1, TimeUnit.Day));
		months.get(6).getDay(3).addEvent(new Event("Independence Day", true, "7/4", 1, TimeUnit.Day));
		months.get(8).getDay(22).addEvent(new Event("First Day of Fall", true, "9/23", 1, TimeUnit.Day));
		months.get(9).getDay(30).addEvent(new Event("Halloween", true, "10/31", 1, TimeUnit.Day));
		months.get(10).getDay(10).addEvent(new Event("Veterans Day", true, "11/11", 1, TimeUnit.Day));
		months.get(11).getDay(20).addEvent(new Event("First Day of Winter", true, "12/21", 1, TimeUnit.Day));
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
		}
	}
	
	public void printYear()
	{
		for (int i = 0; i < months.size(); i++)
		{
			System.out.println(months.get(i).getName());
			ArrayList<Day> list = months.get(i).getDays();	// list of days in a month
			
			for (int q = 0; q < list.size(); q++)
			{
				System.out.print(list.get(q).getDayOfWeek() + " " + list.get(q).getDate() + ": " + list.get(q).getPrice() + " : ");
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
