package CompanySupport;

import java.util.ArrayList;

import CalendarSupport.Day;

/*********************************************************
 * Static class that will have mathematic operations for
 * use on entities.
 * @author Austin
 *********************************************************/
public class EntityOperations 
{
	/**
	 * Calculates the correlation of both entities for the range they overlap
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
		//System.out.println("E1 = " + e1Avg + " E2 = " + e2Avg);
		
		// sub avg from all x(a) and y(b) vals
		ArrayList<Float> a = e1.getPriceListBetweenDates(e1Start, e1End);
		//System.out.println("A set");
		for (int i = 0; i < a.size(); i++)
		{
			a.set(i, a.get(i) - e1Avg);
			//System.out.println(a.get(i));
		}
		ArrayList<Float> b = e2.getPriceListBetweenDates(e2Start, e2End);
		//System.out.println("B set");
		for (int i = 0; i < b.size(); i++)
		{
			b.set(i, b.get(i) - e2Avg);
			//System.out.println(b.get(i));
		}
		
		// calc a x b
		ArrayList<Float> ab = new ArrayList<>();
		//System.out.println("AB set");
		for (int i = 0; i < a.size(); i++)
		{
			ab.add(a.get(i) * b.get(i));
			//System.out.println(ab.get(i));
		}
		
		// calc a ^ 2
		ArrayList<Float> aSquare = new ArrayList<>();
		//System.out.println("A sqr set");
		for (int i = 0; i < a.size(); i++)
		{
			aSquare.add((float) Math.pow(a.get(i), 2));
			//System.out.println(aSquare.get(i));
		}
		
		// calc b ^ 2
		ArrayList<Float> bSquare = new ArrayList<>();
		//System.out.println("B sqr set");
		for (int i = 0; i < b.size(); i++)
		{
			bSquare.add((float) Math.pow(b.get(i), 2));
			//System.out.println(bSquare.get(i));
		}
		
		// calc sums
		float abSum = 0;
		for (int i = 0; i < ab.size(); i++)
			abSum += ab.get(i);
		//System.out.println("AB sum = " + abSum);
		float aSquareSum = 0;
		for (int i = 0; i < aSquare.size(); i++)
			aSquareSum += aSquare.get(i);
		//System.out.println("A sqr sum = " + aSquareSum);
		float bSquareSum = 0;
		for (int i = 0; i < bSquare.size(); i++)
			bSquareSum += bSquare.get(i);
		//System.out.println("B sqr sum = " + bSquareSum);
		
		// div ab/sqrt(a^2 x b^2)
		return (float) (abSum / (Math.sqrt(aSquareSum * bSquareSum)));
	}
}
