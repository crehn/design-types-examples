package t_r.robust;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

public class LifeExpectancyTableTest {

    @Test(expected=IllegalStateException.class)
    public void testCalculationWithBirthdayOutOfBoudary() {
        Calendar birthday = new GregorianCalendar(1900, 1, 1);
        Human human = new Human("Max", "Musterman", true, birthday, null);
        LifeExpectancyCalculator calculator = new LifeExpectancyCalculator();
        calculator.calculateLifeExpectancy(human);
    }
    
    @Test
    public void testCalculationWithoutPersonalAttributes() {
        Calendar birthday = new GregorianCalendar(1915, 1, 1);
        Human human = new Human("Max", "Musterman", true, birthday, null);
        LifeExpectancyCalculator calculator = new LifeExpectancyCalculator();
        float calculatedLifeExpectancy = calculator.calculateLifeExpectancy(human);
        Assert.assertEquals(53.1f, calculatedLifeExpectancy, 0.1);
    }

}
