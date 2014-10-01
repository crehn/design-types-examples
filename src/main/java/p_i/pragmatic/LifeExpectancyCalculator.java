package p_i.pragmatic;

import java.util.HashMap;
import java.util.Map;

public class LifeExpectancyCalculator {
	
	private static Map<String, Float> maleStatisticalLifeExpectancy;
	private static Map<String, Float> femaleStatisticalLifeExpectancy;
	
	static {
		maleStatisticalLifeExpectancy = new HashMap<String, Float>();
		maleStatisticalLifeExpectancy.put("1914", 52.3f);
		maleStatisticalLifeExpectancy.put("1915", 53.1f);
		maleStatisticalLifeExpectancy.put("1916", 54.6f);
		// ...
		femaleStatisticalLifeExpectancy = new HashMap<String, Float>();
		femaleStatisticalLifeExpectancy.put("1914", 59.5f);
		femaleStatisticalLifeExpectancy.put("1915", 60.7f);
		femaleStatisticalLifeExpectancy.put("1916", 61.9f);
		// ...
	}
	
	public float calculateLifeExpectancy(int year, boolean male, float lifeExpectancyDifferential) {
		float lifeExpectancy;
		if (male) {
			lifeExpectancy = maleStatisticalLifeExpectancy.get(String.valueOf(year));
		} else {
			lifeExpectancy = femaleStatisticalLifeExpectancy.get(String.valueOf(year));
		}
		lifeExpectancy += lifeExpectancyDifferential;
		return lifeExpectancy;
	}
}
