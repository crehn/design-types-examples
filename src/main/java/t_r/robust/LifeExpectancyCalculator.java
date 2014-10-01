package t_r.robust;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;


public final class LifeExpectancyCalculator {

    private final static Logger logger = LoggerFactory.getLogger(LifeExpectancyCalculator.class);
    
    /**
     * Calculate the life expectancy of the passed human using static life expectancy tables as well as personal attributes.
     * @param human
     *            the person to calculate the life expectancy for
     * @throws IllegalArgumentException
     *             if parameter is insufficient
     * @return the calculated life expectancy in years as float
     */
    public float calculateLifeExpectancy(Human human) {
        logger.trace("method entry");
        float lifeExpectancy;
        if (human == null) {
            throw new IllegalArgumentException("Passed human is null!");
        }
        MDC.put("user", human.toString());
        try {
            lifeExpectancy = LifeExpectancyTable.getStatisticalLifeExpectancy(human.getBirthday(), human.isMale());
            logger.debug("calculated life expectancy respecting life expectancy table only is: {}", human, lifeExpectancy);
            if (human.getPersonalAttributes() != null) {
                for (PersonalAttribute curPersAttr : human.getPersonalAttributes()) {
                    lifeExpectancy += curPersAttr.getLifeExpectancyDifferential();
                }
                logger.debug("calculated life expectancy respecting personal attributes also is: {}", human, lifeExpectancy);
            }
        } catch (Exception e) {
            throw new IllegalStateException("Unexpected exception occurred calculating life expectancy of: " + human, e);
        }
        return lifeExpectancy;
    }
}
