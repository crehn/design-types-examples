package t_r.robust;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LifeExpectancyTable {

    private final static Logger logger = LoggerFactory.getLogger(LifeExpectancyTable.class);
    
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
	
	/**
	 * Delivers life expectancy depending on year of birth and gender.
	 * @param birthday
	 * @param male
	 * @return life expectancy in years as float
	 */
	static float getStatisticalLifeExpectancy(Calendar birthday, boolean male) {
	    Float statLifeExp;
	    if (birthday == null) {
            throw new IllegalArgumentException("Passed birthday is null!");
        }
		int year = birthday.get(Calendar.YEAR);
		if (male) {
			statLifeExp = maleStatisticalLifeExpectancy.get(String.valueOf(year));
		} else {
			statLifeExp = femaleStatisticalLifeExpectancy.get(String.valueOf(year));
		}
		if (statLifeExp == null) {
		    logger.error("Passed birthday[{}] is not contained in the life expectancy tables:\nmale: {}\nfemale: ", birthday, maleStatisticalLifeExpectancy, femaleStatisticalLifeExpectancy);
		    throw new IllegalStateException("Passed birthday["+birthday+"] is not contained in the life expectancy tables!");
		}
		return statLifeExp;
	}

}
