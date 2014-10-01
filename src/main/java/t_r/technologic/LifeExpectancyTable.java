package t_r.technologic;

import javolution.util.FastMap;

public class LifeExpectancyTable {

	private static FastMap<String, Float> maleStatisticalLifeExpectancy;
	private static FastMap<String, Float> femaleStatisticalLifeExpectancy;
	
	static {
		maleStatisticalLifeExpectancy = new FastMap<String, Float>();
		maleStatisticalLifeExpectancy.put("1914", 52.3f);
		maleStatisticalLifeExpectancy.put("1915", 53.1f);
		maleStatisticalLifeExpectancy.put("1916", 54.6f);
		// ...
		femaleStatisticalLifeExpectancy = new FastMap<String, Float>();
		femaleStatisticalLifeExpectancy.put("1914", 59.5f);
		femaleStatisticalLifeExpectancy.put("1915", 60.7f);
		femaleStatisticalLifeExpectancy.put("1916", 61.9f);
		// ...
	}
	
	public static float getStatisticalLifeExpectancy(Human human) {
	    float lifeExpectancy;
		int year = human.getBirthday().getYear();
		if (human.isMale()) {
		    lifeExpectancy = maleStatisticalLifeExpectancy.get(String.valueOf(year));
		} else {
		    lifeExpectancy = femaleStatisticalLifeExpectancy.get(String.valueOf(year));
		}
		for (PersonalAttribute curPersAttr : human.getPersonalAttributes()) {
            lifeExpectancy += curPersAttr.getLifeExpectancyDifferential();
        }
		return lifeExpectancy;
	}
}
