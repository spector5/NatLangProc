package CalendarSupport;

/******************************************************************
 * Class representing events. Events are things that happen during
 * the year that may effect stock prices.
 * @author Austin
 ******************************************************************/
public class Event 
{
	private String name;
	private boolean isRecurrent;	// if it is a constantly repeating event
	private String startDate;		// date of event/first day of long term event
	private int duration;		// number of units it lasts
	private TimeUnit durationUnit;	// month, day, year, etc
	
	// constructors
	/**
	 * Constructor, set basic information
	 * @param name = name of event
	 * @param rec = true if a recurrent event
	 * @param start = first day of event (or day of event if not recurrent)
	 * @param dur = number of units event lasts
	 * @param unit = unit of duration
	 */
	public Event(String name, boolean rec, String start, int dur, TimeUnit unit)
	{
		this.name = name;
		this.isRecurrent = rec;
		this.startDate = start;
		this.duration = dur;
		this.durationUnit = unit;
	}
	
	/**
	 * Constructor, set basic information
	 * @param name = name of event
	 * @param rec = true if recurrent
	 * @param day = day of event
	 */
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
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	
	public void setRecurrent(boolean rec)
	{
		this.isRecurrent = rec;
	}
	public boolean getRecurrent()
	{
		return isRecurrent;
	}
	
	public void setDate(String day)
	{
		this.startDate = day;
	}
	public String getDate()
	{
		return startDate;
	}
	
	public void setDuration(int dur)
	{
		this.duration = dur;
	}
	public int getDuration()
	{
		return duration;
	}
	
	public void setUnit(TimeUnit un)
	{
		this.durationUnit = un;
	}
	public TimeUnit getUnit()
	{
		return durationUnit;
	}
	// end getters and setters
}
