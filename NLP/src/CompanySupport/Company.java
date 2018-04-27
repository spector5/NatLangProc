package CompanySupport;

import CalendarSupport.Calendar;

/*******************************************************************
 * Class that represents a single company. This class will hold a
 * calendar for a specific company that will be processed to find
 * trends in stock price.
 * @author Austin
 *******************************************************************/
public class Company 
{
	private String name;
	private String symbol;		// stock market abbreviation
	private String industry;
	private String parent;		// parent company
	private String president;	// president/ceo/head of company
	private Calendar cal;		// unique calendar for company
	
	// constructors
	/************************************************************
	 * Constructor, set basic information
	 * @param name = name of company
	 * @param symbol = symbol of company on stock market
	 * @param ind = industry of company
	 * @param parent = parent company (blank if there are none)
	 * @param pres = president/ceo of company
	 * @param calandar = calender specific to company
	 ************************************************************/
	public Company(String name, String symbol, String ind, String parent, String pres, Calendar calandar)
	{
		this.name = name;
		this.symbol = symbol;
		this.industry = ind;
		this.parent = parent;
		this.president = pres;
		this.cal = calandar;
	}
	
	/***********************************************************
	 * Constructor, set basic information
	 * @param name = name of company
	 * @param symbol = symbol of company on stock market
	 * @param ind = industry of company
	 * @param parent = parent company (blank if there are none)
	 * @param pres = president/ceo of company
	 ***********************************************************/
	public Company(String name, String symbol, String ind, String parent, String pres)
	{
		this.name = name;
		this.symbol = symbol;
		this.industry = ind;
		this.parent = parent;
		this.president = pres;
		this.cal = null;
	}
	
	/********************************************************
	 * Constructor, set basic information
	 * @param name = name of company
	 * @param symbol = symbol of company on stock market
	 * @param ind = industry of company
	 ********************************************************/
	public Company(String name, String symbol, String ind)
	{
		this.name = name;
		this.symbol = symbol;
		this.industry = ind;
		this.parent = null;
		this.president = null;
		this.cal = null;
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
	
	public void setSymbol(String sy)
	{
		this.symbol = sy;
	}
	public String getSymbol()
	{
		return symbol;
	}
	
	public void setIndustry(String in)
	{
		this.industry = in;
	}
	public String getIndustry()
	{
		return industry;
	}
	
	public void setParent(String c)
	{
		this.parent = c;
	}
	public String getParent()
	{
		return this.parent;
	}
	
	public void setPresident(String pres)
	{
		this.president = pres;
	}
	public String getPresident()
	{
		return president;
	}
	
	public void setCalender(Calendar cal)
	{
		this.cal = cal;
	}
	public Calendar getCalender()
	{
		return cal;
	}
	// end getters and setters
}
