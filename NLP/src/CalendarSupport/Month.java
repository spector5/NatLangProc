package CalendarSupport;

import java.util.ArrayList;

/***********************************
 * Class that represents a month.
 * @author Austin
 ***********************************/
public class Month 
{
	private ArrayList<Day> days;	// list of all days
	private int quarter;
	private String season;
	private String name;
	private int year;
	
	// constructors
	/*****************************************
	 * Constructor, set basic information
	 * @param nm = name of month
	 * @param sea = season of month
	 * @param qu = fiscal quarter
	 * @param year = year of month
	 *****************************************/
	public Month(String nm, String sea, int qu, int year)
	{
		this.name = nm;
		this.season = sea;
		this.quarter = qu;
		this.year = year;
		days = new ArrayList<>();
	}
	// end constructors
	
	// getters and setters
	/****************************
	 * Set new name of month
	 * @param name = new name
	 ****************************/
	public void setName(String name)
	{
		this.name = name;
	}
	
	/****************************
	 * Get name of month
	 * @return name of month
	 ****************************/
	public String getName()
	{
		return name;
	}
	
	/*************************
	 * Set season
	 * @param sea = season
	 *************************/
	public void setSeason(String sea)
	{
		this.season = sea;
	}
	
	/*******************
	 * Get season
	 * @return season
	 *******************/
	public String getSeason()
	{
		return season;
	}
	
	/****************************
	 * Set fiscal quarter
	 * @param quart = quarter
	 ****************************/
	public void setQuarter(int quart)
	{
		this.quarter = quart;
	}
	
	/************************
	 * Get fiscal quarter
	 * @return quarter
	 ************************/
	public int getQuarter()
	{
		return quarter;
	}
	
	/***************************
	 * Set new year of month
	 * @param yr = new year
	 ***************************/
	public void setYear(int yr)
	{
		this.year = yr;
	}
	
	/**********************
	 * Get year of month
	 * @return year
	 **********************/
	public int getYear()
	{
		return year;
	}
	
	/***********************************
	 * Add day to month
	 * @param day = day to be added
	 ***********************************/
	public void addDay(Day day)
	{
		days.add(day);
	}
	
	/******************************************
	 * Get day by index
	 * @param index = index to get day from
	 * @return day at index
	 ******************************************/
	public Day getDay(int index)
	{
		return days.get(index);
	}
	
	/***********************************
	 * Get all days
	 * @return list of days
	 ***********************************/
	public ArrayList<Day> getDays()
	{
		return days;
	}
	// end getters and setters
}
