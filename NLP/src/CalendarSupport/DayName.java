package CalendarSupport;

import java.util.ArrayList;

/**
 * This is a replacement for the enum version of this class, because why enums
 * Should probably replace this with enums, but for now just use a list and worry
 * about it later.
 * @author Austin
 * Here is the code of the previous enum version
 * public enum DayName {
 * 	SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
 *	public DayName next() {
 *		return SUNDAY;
 *	}
 * }
 */
public class DayName 
{
	// everything is public static final to mimic enums
	public static final String SUNDAY = "Sunday";
	public static final String MONDAY = "Monday";
	public static final String TUESDAY = "Tuesday";
	public static final String WEDNESDAY = "Wednesday";
	public static final String THURSDAY = "Thursday";
	public static final String FRIDAY = "Friday";
	public static final String SATURDAY = "Saturday";
	
	// this list is here to allow iteration
	@SuppressWarnings("serial")
	public static ArrayList<String> names = new ArrayList<String>() {{
		add(SUNDAY);
		add(MONDAY);
		add(TUESDAY);
		add(WEDNESDAY);
		add(THURSDAY);
		add(FRIDAY);
		add(SATURDAY);
	}};
}
