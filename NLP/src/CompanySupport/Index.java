package CompanySupport;

import CalendarSupport.Calendar;

public class Index {
	private String name;
	private String symbol;		// stock market abbreviation
	private Calendar cal;		// unique calendar for company
	
	// constructors
	/************************************************************
	 * Constructor, set basic information
	 * @param name = name of company
	 * @param symbol = symbol of company on stock market
	 * @param calandar = calendar specific to company
	 ************************************************************/
	public Index(String name, String symbol, Calendar calandar)
	{
		this.name = name;
		this.symbol = symbol;
		this.cal = calandar;
	}
	
	/***********************************************************
	 * Constructor, set basic information
	 * @param name = name of company
	 * @param symbol = symbol of company on stock market
	 ***********************************************************/
	public Index(String name, String symbol)
	{
		this.name = name;
		this.symbol = symbol;
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
