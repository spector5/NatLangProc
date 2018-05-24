package CompanySupport;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

import CalendarSupport.Calendar;
import CalendarSupport.Day;
import CalendarSupport.Month;

/*******************************************************************
 * Class that represents a business object. This class will hold a
 * calendar for a specific company that will be processed to find
 * trends in stock price.
 * @author Austin
 *******************************************************************/
public abstract class Entity 
{
	protected String name;
	protected String symbol;		// stock market abbreviation
	protected ArrayList<Calendar> cal;		// unique calendar for company
	
	// getters and setters
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	
	public void setSymbol(String sy)
	{
		this.symbol = sy;
	}
	public String getSymbol()
	{
		return symbol;
	}
	
	public void setCalender(ArrayList<Calendar> cal)
	{
		this.cal = cal;
	}
	public ArrayList<Calendar> getCalender()
	{
		return cal;
	}
	// end getters and setters
	
	/**
	 * Finds the latest date that has a stock value
	 * @return day with the last stock value
	 */
	public Day getLastDay()
	{
		// iterate years
		for (int p = cal.size() - 1; p >= 0; p--)
		{
			Calendar c = cal.get(p);
			// iterate months
			for (int i = 11; i >= 0; i--)
			{
				Month m = c.getMonth(i);
				// iterate days
				for (int q = m.getLength() - 1; q >= 0; q--)
				{
					if (m.getDay(q).getPrice() != 0.0)
						return m.getDay(q);
				}
			}
		}
		return null;
	}
	
	// TODO this gets all 0s for e2 for some reason (not sure if this was fixed 5/14)
	/**
	 * Finds the first date that has a stock value
	 * @return day with first stock value
	 */
	public Day getFirstDay()
	{
		// iterate years
		for (int p = 0; p < cal.size(); p++)
		{
			Calendar c = cal.get(p);
			// iterate months
			for (int i = 0; i < 12; i++)
			{
				Month m = c.getMonth(i);
				// iterate days
				for (int q = 0; q < m.getLength(); q++)
				{
					if (m.getDay(q).getPrice() != 0.0)
						return m.getDay(q);
				}
			}
		}
		return null;
	}

	/**
	 * Fills the calendar with stock prices found in the companies flat text file
	 * @param startDate = date in file to start finding prices
	 * @param endDate = date in file to finish finding prices
	 * @throws IOException
	 */
	public void fillCalenderWithPrice(String startDate, String endDate) throws IOException
	{
		BufferedReader br;
		Day start = new Day(startDate);
		Day end = new Day(endDate);
		
		try {
			br = new BufferedReader(new FileReader(symbol + "_test.txt"));	// TODO replace with _hist.txt
		} catch (FileNotFoundException e) {
			System.out.println(e.getClass() + ": Could not find file " + symbol + "_test.txt");	// TODO replace with _hist.txt
			return;
		}	
		
		String line;
		// gets to the first entry
		while((line = br.readLine()) != null)
		{
			StringTokenizer toke = new StringTokenizer(line, "\t");
			Day dayIn = new Day(toke.nextToken());
			if (dayIn.compareTo(end) < 0)
			{
				System.out.println("Alert: the end date is not in the list, additional prices will be set to 0.00");
				break;
			}
			
			if (line.indexOf(endDate) == 0)
				break;
		}
		
		// iterates through relevant dates
		StringTokenizer tokenizer;
		int monthVal;
		int dayVal;
		Month month;
		Day day;
		while (line != null)
		{
			tokenizer = new StringTokenizer(line, "/\t");
			monthVal = Integer.parseInt(tokenizer.nextToken());
			dayVal = Integer.parseInt(tokenizer.nextToken());
			month = cal.get(0).getMonth(monthVal - 1);
			day = month.getDay(dayVal - 1);
			
			day.setPrice(Float.parseFloat(line.substring(line.lastIndexOf('\t') + 1)));
			
			// ends loop at start date
			if (line.indexOf(startDate) == 0)
				break;
			line = br.readLine();
		}
	}

	/**
	 * Averages all prices in calendar between two dates
	 * @param start = first day to add up
	 * @param end = last day to add up
	 * @return float of average price
	 */
	public float getAvgPrice(Day start, Day end) 
	{
		float total = 0;
		int num = 0;
		// iterate years
		for (int y = 0; y < cal.size(); y++)
		{
			Calendar calen = cal.get(y);
			// iterate months
			for (int m = 0; m < calen.getAllMonths().size(); m++)
			{
				Month month = calen.getMonth(m);
				// iterate days
				for (int d = 0; d < month.getLength(); d++)
				{
					Day day = month.getDay(d);
					if (day.getPrice() != 0 && (day.compareTo(start) >= 0 && day.compareTo(end) <= 0))
					{
						total += day.getPrice();
						num++;
					}
				}
			}
		}
		return total / num;
	}
	
	/**
	 * Returns list of prices between two dates
	 * @param start = first day to add to list
	 * @param end = last day to add to list
	 * @return list of prices
	 */
	public ArrayList<Float> getPriceListBetweenDates(Day start, Day end)
	{
		ArrayList<Float> ret = new ArrayList<>();
		
		for (int y = 0; y < cal.size(); y++)
		{
			Calendar calen = cal.get(y);
			for (int m = 0; m < calen.getAllMonths().size(); m++)
			{
				Month month = calen.getMonth(m);
				for (int d = 0; d < month.getLength(); d++)
				{
					Day day = month.getDay(d);
					if (day.getPrice() != 0 && (day.compareTo(start) >= 0 && day.compareTo(end) <= 0))
					{
						ret.add(day.getPrice());
					}
				}
			}
		}
		return ret;
	}
	
	/**
	 * Returns table of prices between two dates
	 * @param start = first day to add to list
	 * @param end = last day to add to list
	 * @return table of prices with date as key
	 */
	public LinkedHashMap<String, Float> getPriceTableBetweenDates(Day start, Day end)
	{
		LinkedHashMap<String, Float> ret = new LinkedHashMap<>();
		
		for (int y = 0; y < cal.size(); y++)
		{
			Calendar calen = cal.get(y);
			for (int m = 0; m < calen.getAllMonths().size(); m++)
			{
				Month month = calen.getMonth(m);
				for (int d = 0; d < month.getLength(); d++)
				{
					Day day = month.getDay(d);
					if (day.getPrice() != 0 && (day.compareTo(start) >= 0 && day.compareTo(end) <= 0))
					{
						ret.put(day.getDate(), day.getPrice());
					}
				}
			}
		}
		return ret;
	}
	
	/**
	 * Creates a calendar from a map of dates and prices (should only be used for averaged entities)
	 * @param map = map of date strings and price floats
	 */
	public void createCalendarFromMap(LinkedHashMap<String, Float> map)
	{
		
	}
}
