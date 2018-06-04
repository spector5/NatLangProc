package CompanySupport;

import CalendarSupport.Day;

public class PricePair 
{
	private Day date;
	private float price;
	
	public PricePair(Day d, float p)
	{
		this.date = d;
		this.price = p;
	}
	
	public Day getDate()
	{
		return this.date;
	}
	public void setDate(Day d)
	{
		this.date = d;
	}
	
	public float getPrice()
	{
		return this.price;
	}
	public void setPrice(float p)
	{
		this.price = p;
	}
	
	@Override
	public String toString()
	{
		return date.getDate() + ": " + price;
	}
}
