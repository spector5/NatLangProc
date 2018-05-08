package CalendarSupport;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

/***************************************************************************
 * Class represents days. Each day is for a specific company. Each day
 * has a list of events that could effect stock prices, and the closing
 * price for its company.
 * @author Austin
 ***************************************************************************/
public class Day implements Comparable<Day>
{
	private int number;		// number on the calendar
	private Month month;	// month it belongs to
	private ArrayList<Event> events;	// events happening on this day, one time or recurring doesn't matter
	private float closePrice;
	private int year;
	private String name;	// day of the week
	
	// constructors
	/*****************************************
	 * Constructor, set basic information
	 * @param date = date that will be represented
	 *****************************************/
	public Day(String date)
	{
		StringTokenizer toke = new StringTokenizer(date, "/");
		this.month = new Month(Integer.parseInt(toke.nextToken()));
		this.number = Integer.parseInt(toke.nextToken());
		this.year = Integer.parseInt(toke.nextToken());
		this.events = null;
		this.name = null;	// TODO make getter setter
		this.closePrice = 0;
	}
	
	/*****************************************
	 * Constructor, set basic information
	 * @param num = number of day
	 * @param name = day of the week
	 * @param month = month day belongs to
	 * @param year = current year
	 *****************************************/
	public Day(int num, String name, Month month, int year)
	{
		this.number = num;
		this.month = month;
		events = new ArrayList<>();
		this.year = year;
		this.name = name;	// TODO make getter setter
		this.closePrice = 0;
	}
	
	/***************************************
	 * Constructor, set basic information
	 * @param num = number of day
	 * @param month = month day belongs to
	 * @param year = current year
	 * @param price = closing stock price
	 ***************************************/
	public Day(int num, Month month, int year, float price)
	{
		this.number = num;
		this.month = month;
		events = new ArrayList<>();
		this.year = year;
		closePrice = price;
	}
	// end constructors
	
	// getters and setters
	public int getNum()
	{
		return number;
	}
	public void setNum(int num)
	{
		number = num;
	}
	
	public Month getMonth()
	{
		return month;
	}
	public void setMonth(Month mon)
	{
		month = mon;
	}

	public ArrayList<Event> getEvents()
	{
		return events;
	}
	
	public boolean addEvent(Event ev)
	{
		return events.add(ev);
	}
	public boolean removeEvent(Event ev)
	{
		return events.remove(ev);
	}
	
	public Event getByIndex(int i)
	{
		return events.remove(i);
	}
	
	public Iterator<Event> getEventIterator()
	{
		return events.iterator();
	}

	public float getPrice()
	{
		return closePrice;
	}
	public void setPrice(float price)
	{
		closePrice = price;
	}
	
	public int getYear()
	{
		return year;
	}
	public void setYear(int yr)
	{
		year = yr;
	}

	public String getDayOfWeek()
	{
		return name;
	}

	public String getDate()
	{
		return month.getName() + " " + number + ", " + year;
	}
	// end getters and setters

	/**
	 * Compares the current date to a date passed in
	 * @param arg0 = day to compare to
	 * @return 1 if this is later, -1 if this is earlier, 0 if same day
	 */
	@Override
	public int compareTo(Day arg0) 
	{
		//StringTokenizer arg0Date = new StringTokenizer(arg0.getDate(), "/");
		int arg0Month = arg0.getMonth().getMonthNum();
		int arg0Day = arg0.getNum();
		int arg0Year = arg0.getYear();
		
		// check year
		if (this.year > arg0Year)
			return 1;
		else if (this.year < arg0Year)
			return -1;
		
		// check month
		if (this.month.getMonthNum() > arg0Month)
			return 1;
		else if (this.month.getMonthNum() < arg0Month)
			return -1;
		
		// check day
		if (this.number > arg0Day)
			return 1;
		else if (this.number < arg0Day)
			return -1;
		
		return 0;
	}
}
