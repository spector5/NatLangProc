package CalendarSupport;

import java.util.ArrayList;
import java.util.Iterator;

/***************************************************************************
 * Class represents days. Each day is for a specific company. Each day
 * has a list of events that could effect stock prices, and the closing
 * price for its company.
 * @author Austin
 ***************************************************************************/
public class Day 
{
	private int number;		// number on the calendar
	private Month month;	// month it belongs to
	private ArrayList<Event> events;	// events happening on this day, one time or recurring doesn't matter
	private double closePrice;
	private int year;
	private DayName name;	// day of the week
	
	// constructors
	/*****************************************
	 * Constructor, set basic information
	 * @param num = number of day
	 * @param name = day of the week
	 * @param month = month day belongs to
	 * @param year = current year
	 *****************************************/
	public Day(int num, DayName name, Month month, int year)
	{
		this.number = num;
		this.month = month;
		events = new ArrayList<>();
		this.year = year;
		this.name = name;	// TODO make getter setter
	}
	
	/***************************************
	 * Constructor, set basic information
	 * @param num = number of day
	 * @param month = month day belongs to
	 * @param year = current year
	 * @param price = closing stock price
	 ***************************************/
	public Day(int num, Month month, int year, double price)
	{
		this.number = num;
		this.month = month;
		events = new ArrayList<>();
		this.year = year;
		closePrice = price;
	}
	// end constructors
	
	// getters and setters
	/*************************
	 * Get number of day
	 * @return number of day
	 *************************/
	public int getNum()
	{
		return number;
	}
	
	/*************************
	 * Set new number of day
	 * @param num
	 *************************/
	public void setNum(int num)
	{
		number = num;
	}
	
	/****************************
	 * Get month day belongs to
	 * @return parent month
	 ****************************/
	public Month getMonth()
	{
		return month;
	}
	
	/*****************************
	 * Set month day belongs to
	 * @param mon = new month
	 *****************************/
	public void setMonth(Month mon)
	{
		month = mon;
	}
	
	/**************************************
	 * Get list of all events on this day
	 * @return list of events
	 **************************************/
	public ArrayList<Event> getEvents()
	{
		return events;
	}
	
	/************************************************
	 * Add new event to list
	 * @param ev = new event to add
	 * @return true if successful, otherwise false
	 ************************************************/
	public boolean addEvent(Event ev)
	{
		return events.add(ev);
	}
	
	/************************************************
	 * Take event out of list of events
	 * @param ev = new event
	 * @return true if successful, otherwise false
	 ************************************************/
	public boolean removeEvent(Event ev)
	{
		return events.remove(ev);
	}
	
	/***************************
	 * Get specific event
	 * @param i = index
	 * @return event at index
	 ***************************/
	public Event getByIndex(int i)
	{
		return events.remove(i);
	}
	
	/*******************************
	 * Get iterator of event list
	 * @return iterator of events
	 *******************************/
	public Iterator<Event> getEventIterator()
	{
		return events.iterator();
	}
	
	/*****************************************
	 * Get closing stock price for this day
	 * @return stock price
	 *****************************************/
	public double getPrice()
	{
		return closePrice;
	}
	
	/**********************************
	 * Set new closing price for day
	 * @param price = new price
	 **********************************/
	public void setPrice(double price)
	{
		closePrice = price;
	}
	
	/****************************
	 * Get current year
	 * @return current year
	 ****************************/
	public int getYear()
	{
		return year;
	}
	
	/*************************
	 * Set new year
	 * @param yr = new year
	 *************************/
	public void setYear(int yr)
	{
		year = yr;
	}
	
	/****************************
	 * Get day of the week
	 * @return day of the week
	 ****************************/
	public DayName getDayOfWeek()
	{
		return name;
	}
	
	/*******************************************
	 * Get date as a string
	 * @return date in month number, year form
	 *******************************************/
	public String getDate(int num)
	{
		return month.getName() + " " + number + ", " + year;
	}
	// end getters and setters
}
