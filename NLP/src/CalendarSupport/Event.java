package CalendarSupport;

/**
 * Class representing events. Events are things that happen during
 * the year that may effect stock prices.
 * @author Austin
 */
public class Event 
{
	private String name;
	private boolean isRecurrent;	// if it is a constantly repeating event
	private String startDate;		// date of event/first day of long term event
	private int duration;		// number of units it lasts
	private TimeUnit durationUnit;	// month, day, year, etc
	
	// constructors
	/*************************************************************************
	 * Constructor, set basic information
	 * @param name = name of event
	 * @param rec = true if a recurrent event
	 * @param start = first day of event (or day of event if not recurrent)
	 * @param dur = number of units event lasts
	 * @param unit = unit of duration
	 *************************************************************************/
	public Event(String name, boolean rec, String start, int dur, TimeUnit unit)
	{
		this.name = name;
		this.isRecurrent = rec;
		this.startDate = start;
		this.duration = dur;
		this.durationUnit = unit;
	}
	
	/*****************************************
	 * Constructor, set basic information
	 * @param name = name of event
	 * @param rec = true if recurrent
	 * @param day = day of event
	 *****************************************/
	public Event(String name, boolean rec, String day)
	{
		this.name = name;
		this.isRecurrent = rec;
		this.startDate = day;
		this.duration = 1;
		this.durationUnit = TimeUnit.Day;
	}
	// end constructors
	
	// setters and getters
	/***************************
	 * Set new name of event
	 * @param name = new name
	 ***************************/
	public void setName(String name)
	{
		this.name = name;
	}
	
	/*************************
	 * Get name of event
	 * @return name of event
	 *************************/
	public String getName()
	{
		return name;
	}
	
	/***************************************
	 * Set whether event recurs every year
	 * @param rec = true if recurrent
	 ***************************************/
	public void setRecurrent(boolean rec)
	{
		this.isRecurrent = rec;
	}
	
	/***********************************
	 * Get whether event is recurrent
	 * @return true if recurrent
	 ***********************************/
	public boolean getRecurrent()
	{
		return isRecurrent;
	}
	
	/****************************
	 * Set date of event
	 * @param day = new date
	 ****************************/
	public void setDate(String day)
	{
		this.startDate = day;
	}
	
	/**************************
	 * Get date of event
	 * @return date of event
	 **************************/
	public String getDate()
	{
		return startDate;
	}
	
	/********************************
	 * Set length event lasts
	 * @param dur = event length
	 ********************************/
	public void setDuration(int dur)
	{
		this.duration = dur;
	}
	
	/********************************
	 * Get duration value
	 * @return duration of event
	 ********************************/
	public int getDuration()
	{
		return duration;
	}
	
	/***************************************
	 * Set new unit of duration
	 * @param un = new unit of duration
	 ***************************************/
	public void setUnit(TimeUnit un)
	{
		this.durationUnit = un;
	}
	
	/******************************
	 * Get unit of duration
	 * @return unit of duration
	 ******************************/
	public TimeUnit getUnit()
	{
		return durationUnit;
	}
	// end getters and setters
}
