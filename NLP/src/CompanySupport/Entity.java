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
	protected ArrayList<PricePair> prices;		// unique calendar for company
	// TODO can probably make prices into a heap with date as the key
	
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
	
	public void setPrices(ArrayList<PricePair> p)
	{
		this.prices = p;
	}
	public ArrayList<PricePair> getPrices()
	{
		return this.prices;
	}
	// end getters and setters
	
	/**
	 * Finds the latest date that has a stock value
	 * @return day with the last stock value
	 */
	public Day getLastDay()
	{
		return prices.get(prices.size() - 1).getDate();
	}

	/**
	 * Finds the first date that has a stock value
	 * @return day with first stock value
	 */
	public Day getFirstDay()
	{
		return prices.get(0).getDate();
	}

	/**
	 * Fills the calendar with stock prices found in the companies flat text file
	 * @param startDate = date in file to start finding prices
	 * @param endDate = date in file to finish finding prices
	 * @throws IOException
	 */
	public void fillEntityWithPrice(String startDate, String endDate, Calendar cal) throws IOException
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
				System.out.println("Alert[Entity.fillEntityWithPrice]: End date not in file, ending at " + dayIn.getDate());
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
			tokenizer = new StringTokenizer(line, "\t");
			day = cal.getDayRef(tokenizer.nextToken());
			
			String l = tokenizer.nextToken();
			prices.add(new PricePair(day, Float.parseFloat(l)));
			
			// ends loop at start date
			if (line.indexOf(startDate) == 0)
				break;
			line = br.readLine();
		}
		if (line == null)
			System.out.println("Alert[Entity.fillEntityWithPrice]: Start date not in file, starting at " + prices.get(prices.size() - 1).getDate().getDate());
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
		int x = 0;
		
		// get index of first day
		while (x < prices.size())
		{
			if (prices.get(x).getDate().equals(start.getDate()))
				break;
			x++;
		}
		
		// add prices in range
		do
		{
			total += prices.get(x).getPrice();
			x++;
		} while (prices.get(x).getDate().compareTo(end) >= 0);
		
		return total / num;
	}
	
	/**
	 * Returns list of price pairs between two dates
	 * @param start = first day to add to list
	 * @param end = last day to add to list
	 * @return list of prices
	 */
	public ArrayList<PricePair> getPricePairs(Day start, Day end)
	{
		ArrayList<PricePair> ret = new ArrayList<>();
		int x = 0;
		
		// get index of first day
		while (x < prices.size())
		{
			if (prices.get(x).getDate().equals(start.getDate()))
				break;
			x++;
		}
		
		// add prices in range
		do
		{
			ret.add(prices.get(x));
			x++;
		} while (prices.get(x).getDate().compareTo(end) >= 0);
		
		return ret;
	}
	
	public void printPrices()
	{
		System.out.println(name + " (" + symbol + ")");
		for (int i = 0; i < prices.size(); i++)
			System.out.println(prices.get(i));
	}
}
