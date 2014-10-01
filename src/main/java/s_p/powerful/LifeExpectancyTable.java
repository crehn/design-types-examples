package s_p.powerful;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class LifeExpectancyTable {

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
	
	public static float getStatisticalLifeExpectancy(Calendar birthday,
			boolean male) {
		float statLifeExp = 0;
		int year = birthday.get(Calendar.YEAR);
		if (male) {
			statLifeExp = maleStatisticalLifeExpectancy.get(String.valueOf(year));
		} else {
			statLifeExp = femaleStatisticalLifeExpectancy.get(String.valueOf(year));
		}
		return statLifeExp;
	}

}
