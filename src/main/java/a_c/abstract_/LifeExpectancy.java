package a_c.abstract_;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class LifeExpectancy {
	
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
	
	public LifeExpectancy(Human human) {
		calculateLifeExpectancy(human);
	}

	private float calculateLifeExpectancy(Human human) {
		float lifeExpectancy;
		int year = human.getBirthday().get(Calendar.YEAR);
		if (Gender.male.equals(human.getGender())) {
			lifeExpectancy = maleStatisticalLifeExpectancy.get(year);
		} else {
			lifeExpectancy = femaleStatisticalLifeExpectancy.get(year);
		}
		for (PersonalAttribute curPersAttr : human.getPersonalAttributes()) {
			lifeExpectancy += curPersAttr.getLifeExpectancyDifferential();
		}
		return lifeExpectancy;
	}
}
