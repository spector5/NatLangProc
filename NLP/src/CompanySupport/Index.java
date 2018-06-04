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

/*******************************************************************
 * Class that represents a single major index.
 * @author Austin
 *******************************************************************/
public class Index extends Entity
{	
	// constructors
	/**
	 * Constructor, set basic information; should only be used for averaged indices
	 */
	public Index()
	{
		this.name = null;
		this.symbol = null;
		this.prices = new ArrayList<>();
	}
	
	/**
	 * Constructor, set basic information
	 * @param name = name of company
	 * @param symbol = symbol of company on stock market
	 * @param calandar = calendar specific to company
	 */
	public Index(String name, String symbol)
	{
		this.name = name;
		this.symbol = symbol;
		this.prices = new ArrayList<>();
	}
	// end constructors
}
