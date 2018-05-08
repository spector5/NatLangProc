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

public class Index extends Entity
{	
	// constructors
	/************************************************************
	 * Constructor, set basic information
	 * @param name = name of company
	 * @param symbol = symbol of company on stock market
	 * @param calandar = calendar specific to company
	 ************************************************************/
	public Index(String name, String symbol, ArrayList<Calendar> calandar)
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
	// end getters and setters
}
