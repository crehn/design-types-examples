package net.designtypes.examples;

import static net.designtypes.examples.DummyData.*;
import static net.designtypes.examples.SmokingHabitTestType.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ResidualLifeExpectancySmokingTest extends AbstractResidualLifeExpectancyTest {

	@Test
	public void shouldGetForNonSmoker() {
		for (Solution solution : solutions) {
			solution.given50YearOldMaleInsuree(NON_SMOKER);
			
			double result = solution.getResidualLifeExpectancy(INSUREE_NUMBER);
			
			assertEquals(29.67, result, EPSILON);
		}
	}
	
	@Test
	public void shouldGetForPersonWhoStoppedSmoking() {
		for (Solution solution : solutions) {
			solution.given50YearOldMaleInsuree(STOPPED_SMOKING);
			
			double result = solution.getResidualLifeExpectancy(INSUREE_NUMBER);
			
			assertEquals(27.67, result, EPSILON);
		}
	}
	
	@Test
	public void shouldGetForSmokerWith5CigarettesPerDay() {
		for (Solution solution : solutions) {
			solution.given50YearOldMaleInsuree(LESS_THAN_5_CIGARETTES_PER_DAY);
			
			double result = solution.getResidualLifeExpectancy(INSUREE_NUMBER);
			
			assertEquals(24.97, result, EPSILON);
		}
	}
	
	@Test
	public void shouldGetForSmokerWith20CigarettesPerDay() {
		for (Solution solution : solutions) {
			solution.given50YearOldMaleInsuree(LESS_THAN_20_CIGARETTES_PER_DAY);
			
			double result = solution.getResidualLifeExpectancy(INSUREE_NUMBER);

			assertEquals(21.37, result, EPSILON);
		}
	}
	
	@Test
	public void shouldGetForSmokerWithMoreThan20CigarettesPerDay() {
		for (Solution solution : solutions) {
			solution.given50YearOldMaleInsuree(MORE_THAN_20_CIGARETTES_PER_DAY);
			
			double result = solution.getResidualLifeExpectancy(INSUREE_NUMBER);
			
			assertEquals(19.57, result, EPSILON);
		}
	}
}
