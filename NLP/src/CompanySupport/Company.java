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
	}
	// end constructors
	
	// getters and setters
	/***********************************************
	 * Change name of company
	 * @param name = new name of company
	 ***********************************************/
	public void setName(String name)
	{
		this.name = name;
	}
	
	/***************************
	 * Get company name
	 * @return company name
	 ***************************/
	public String getName()
	{
		return name;
	}
	
	/*********************************************
	 * Set stock market abbreviation of company
	 * @param sy = new abbreviation
	 *********************************************/
	public void setSymbol(String sy)
	{
		this.symbol = sy;
	}
	
	/*********************************************
	 * Get stock market abbreviation of company
	 * @return abbreviation of company
	 *********************************************/
	public String getSymbol()
	{
		return symbol;
	}
	
	/*********************************
	 * Change industry company is in
	 * @param in = new industry
	 *********************************/
	public void setIndustry(String in)
	{
		this.industry = in;
	}
	
	/***********************************
	 * Get industry the company is in
	 * @return industry of company
	 ***********************************/
	public String getIndustry()
	{
		return industry;
	}
	
	/*********************************
	 * Set new president of company
	 * @param pres = new president
	 *********************************/
	public void setPresident(String pres)
	{
		this.president = pres;
	}
	
	/******************************
	 * Get president of company
	 * @return name of president
	 ******************************/
	public String getPresident()
	{
		return president;
	}
	
	/**********************************
	 * Set new calender for company
	 * @param cal = new calender
	 **********************************/
	public void setCalender(Calendar cal)
	{
		this.cal = cal;
	}
	
	/***********************************
	 * Get whole calender of company
	 * @return calender for company
	 ***********************************/
	public Calendar getCalender()
	{
		return cal;
	}
	// end getters and setters
}
