package CompanySupport;

import CalendarSupport.Day;

public class EntityOperations 
{
	/**
	 * Calculates the corolation of both entities for the range they overlap
	 * @param e1 = entity we are interested in
	 * @param e2 = entity to compare to
	 * @return floating point representation of correlation percentage
	 */
	public static float calcCorrelation (Entity e1, Entity e2)
	{
		// find calendar bounds
		Day e1Start = e1.getFirstDay();
		Day e2Start = e2.getFirstDay();
		Day e1End = e1.getLastDay();
		Day e2End = e2.getLastDay();
			
		// find means
		float e1Avg = e1.getAvgPrice(e1Start, e1End);
		float e2Avg = e2.getAvgPrice(e2Start, e2End);
		System.out.println("E1 = " + e1Avg + " E2 = " + e2Avg);
		
		// sub avg from all x(a) and y(b) vals
		float a = 
		return 0;
		// calc a x b
		
		// calc a ^ 2
		
		// calc b ^ 2
		
		// calc sums
		
		// div ab/sqrt(a^2 x b^2)
	}
}
