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
	private int length;
	
	// constructors
	/*****************************************
	 * Constructor, set basic information
	 * @param nm = number of month
	 * @param sea = season of month
	 * @param qu = fiscal quarter
	 * @param year = year of month
	 *****************************************/
	public Month(int nm)
	{
		this.season = null;
		this.quarter = 0;
		this.year = 0;
		this.days = null;
		this.length = 0;
		switch (nm)
		{
		case 1:
			this.name = "January";
			break;
		case 2:
			this.name = "February";
			break;
		case 3:
			this.name = "March";
			break;
		case 4:
			this.name = "April";
			break;
		case 5:
			this.name = "May";
			break;
		case 6:
			this.name = "June";
			break;
		case 7:
			this.name = "July";
			break;
		case 8:
			this.name = "August";
			break;
		case 9:
			this.name = "September";
			break;
		case 10:
			this.name = "October";
			break;
		case 11:
			this.name = "November";
			break;
		case 12:
			this.name = "December";
			break;
		default:
			this.name = null;
			break;
		}
	}
	
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
		this.days = new ArrayList<>();
		this.length = 0;
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
	
	public void setLength(int leng)
	{
		this.length = leng;
	}
	
	/****************************
	 * Get name of month
	 * @return name of month
	 ****************************/
	public int getLength()
	{
		return length;
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
	
	public int getMonthNum()
	{
		switch (name)
		{
		case "January":
			return 1;
		case "February":
			return 2;
		case "March":
			return 3;
		case "April":
			return 4;
		case "May":
			return 5;
		case "June":
			return 6;
		case "July":
			return 7;
		case "August":
			return 8;
		case "September":
			return 9;
		case "October":
			return 10;
		case "November":
			return 11;
		case "December":
			return 12;
		default:
			return -1;
		}
	}
}
