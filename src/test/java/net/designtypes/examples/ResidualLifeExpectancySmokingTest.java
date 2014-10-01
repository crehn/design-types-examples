package net.designtypes.examples;

import static net.designtypes.examples.my.model.SmokingHabit.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ResidualLifeExpectancySmokingTest extends AbstractResidualLifeExpectancyTest {
	
	@Test
	public void shouldGetForNonSmoker() {
		givenInsuree(generateFiftyYearOldMale().smokingHabit(NON_SMOKER).build());
		
		double result = facade.getResidualLifeExpecantcy(INSUREE_NUMBER);
		
		assertEquals(29.67, result, EPSILON);
	}

	@Test
	public void shouldGetForPersonWhoStoppedSmoking() {
		givenInsuree(generateFiftyYearOldMale().smokingHabit(STOPPED_SMOKING).build());

		double result = facade.getResidualLifeExpecantcy(INSUREE_NUMBER);

		assertEquals(27.67, result, EPSILON);
	}

	@Test
	public void shouldGetForSmokerWith5CigarettesPerDay() {
		givenInsuree(generateFiftyYearOldMale().smokingHabit(LESS_THAN_5_CIGARETTES_PER_DAY).build());

		double result = facade.getResidualLifeExpecantcy(INSUREE_NUMBER);

		assertEquals(24.97, result, EPSILON);
	}

	@Test
	public void shouldGetForSmokerWith20CigarettesPerDay() {
		givenInsuree(generateFiftyYearOldMale().smokingHabit(LESS_THAN_20_CIGARETTES_PER_DAY).build());

		double result = facade.getResidualLifeExpecantcy(INSUREE_NUMBER);

		assertEquals(21.37, result, EPSILON);
	}

	@Test
	public void shouldGetForSmokerWithMoreThan20CigarettesPerDay() {
		givenInsuree(generateFiftyYearOldMale().smokingHabit(MORE_THAN_20_CIGARETTES_PER_DAY).build());

		double result = facade.getResidualLifeExpecantcy(INSUREE_NUMBER);

		assertEquals(19.57, result, EPSILON);
	}
}
