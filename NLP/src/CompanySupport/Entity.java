package CompanySupport;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import CalendarSupport.Calendar;
import CalendarSupport.Day;
import CalendarSupport.Month;

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
	
	public Day getLastDay()
	{
		for (int p = cal.size() - 1; p >= 0; p--)
		{
			Calendar c = cal.get(p);
			for (int i = 11; i >= 0; i--)
			{
				Month m = c.getMonth(i);
				for (int q = m.getLength() - 1; q >= 0; q--)
				{
					if (m.getDay(q).getPrice() != 0.0)
						return m.getDay(q);
				}
			}
		}
		return null;
	}
	
	// todo this gets all 0s for e2 for some reason
	public Day getFirstDay()
	{
		for (int p = 0; p < cal.size(); p++)
		{
			Calendar c = cal.get(p);
			for (int i = 0; i < 12; i++)
			{
				Month m = c.getMonth(i);
				for (int q = 0; q < m.getLength(); q++)
				{
					if (m.getDay(q).getPrice() != 0.0)
						return m.getDay(q);
				}
			}
		}
		return null;
	}
	
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
		
		// iterates through relevent dates
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
	public float getAvgPrice(Day start, Day end) 
	{
		float total = 0;
		int num = 0;
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
						total += day.getPrice();
						num++;
					}
				}
			}
		}
		return total / num;
	}
}
