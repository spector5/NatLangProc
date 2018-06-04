package CalendarSupport;

import java.io.Serializable;
import java.util.ArrayList;

/***********************************
 * Class that represents a month.
 * @author Austin
 ***********************************/
public class Month implements Serializable
{
	private ArrayList<Day> days;	// list of all days
	private int quarter;
	private String season;
	private String name;
	private int year;
	private int length;
	private String lastDay;
	
	// constructors
	/**
	 * Constructor, set basic information
	 * @param nm = number of month
	 */
	public Month(int nm)
	{
		this.season = null;
		this.quarter = 0;
		this.year = 0;
		this.days = null;
		this.length = 0;
		this.lastDay = null;
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
	
	/**
	 * Constructor, set basic information
	 * @param nm = name of month
	 * @param sea = season of month
	 * @param qu = fiscal quarter
	 * @param length = number of days in month
	 * @param year = year of month
	 * @param firstDay = index from DayName of first day of month
	 */
	public Month(String nm, String sea, int qu, int length, int year, int firstDay)
	{
		this.name = nm;
		this.season = sea;
		this.quarter = qu;
		this.year = year;
		this.days = new ArrayList<>();
		this.length = 0;
		
		for (int i = 0; i < length; i++)
		{
			if (firstDay >= DayName.names.size())
				firstDay = 0;
			days.add(new Day(i + 1, DayName.names.get(firstDay++), this, year));
		}
		
		if (firstDay == 0)
			this.lastDay = DayName.names.get(6);
		else
			this.lastDay = DayName.names.get(--firstDay);
	}
	// end constructors
	
	// getters and setters
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	
	public void setLastDay(String name)
	{
		this.lastDay = name;
	}
	public String getLastDay() {
		return lastDay;
	}
	
	public void setLength(int leng)
	{
		this.length = leng;
	}
	public int getLength()
	{
		return length;
	}
	
	public void setSeason(String sea)
	{
		this.season = sea;
	}
	public String getSeason()
	{
		return season;
	}
	
	public void setQuarter(int quart)
	{
		this.quarter = quart;
	}
	public int getQuarter()
	{
		return quarter;
	}
	
	public void setYear(int yr)
	{
		this.year = yr;
	}
	public int getYear()
	{
		return year;
	}
	
	public void addDay(Day day)
	{
		days.add(day);
	}
	public Day getDayByIndex(int index)
	{
		return days.get(index);
	}
	
	public ArrayList<Day> getDays()
	{
		return days;
	}
	// end getters and setters
	
	/**
	 * Get number that would appear in the date (starts at 1)
	 * @return number 1 - 12
	 */
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
