package CompanySupport;

import java.util.ArrayList;

import CalendarSupport.Calendar;

/*******************************************************************
 * Class that represents a single company.
 * @author Austin
 *******************************************************************/
public class Company extends Entity
{
	private String industry;
	private String parent;		// parent company
	private String president;	// president/ceo/head of company
	
	// constructors
	/**
	 * Constructor, set basic information
	 * @param name = name of company
	 * @param symbol = symbol of company on stock market
	 * @param ind = industry of company
	 * @param parent = parent company (blank if there are none)
	 * @param pres = president/ceo of company
	 * @param calandar = calender specific to company
	 */
	public Company(String name, String symbol, String ind, String parent, String pres, ArrayList<Calendar> calandar)
	{
		this.name = name;
		this.symbol = symbol;
		this.industry = ind;
		this.parent = parent;
		this.president = pres;
		this.cal = calandar;
	}
	
	/**
	 * Constructor, set basic information
	 * @param name = name of company
	 * @param symbol = symbol of company on stock market
	 * @param ind = industry of company
	 * @param parent = parent company (blank if there are none)
	 * @param pres = president/ceo of company
	 */
	public Company(String name, String symbol, String ind, String parent, String pres)
	{
		this.name = name;
		this.symbol = symbol;
		this.industry = ind;
		this.parent = parent;
		this.president = pres;
		this.cal = null;
	}
	
	/**
	 * Constructor, set basic information
	 * @param name = name of company
	 * @param symbol = symbol of company on stock market
	 * @param ind = industry of company
	 */
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
	// end getters and setters
}
