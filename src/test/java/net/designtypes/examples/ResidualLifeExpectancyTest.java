package net.designtypes.examples;

import static net.designtypes.examples.my.model.Gender.*;
import static org.junit.Assert.*;
import net.designtypes.examples.my.control.AgeIsUnknownException;
import net.designtypes.examples.my.model.Insuree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ResidualLifeExpectancyTest extends AbstractResidualLifeExpectancyTest {
	
	@Test
	public void shouldGetForNewbornMaleChild() {
		givenInsuree(Insuree.builder().birthday(NOW).gender(MALE).build());
		
		double result = facade.getResidualLifeExpecantcy(INSUREE_NUMBER);

		assertEquals(77.72, result, EPSILON);
	}

	@Test
	public void shouldGetFor100YearOldMale() {
		givenInsuree(Insuree.builder().birthday(NOW.minusYears(100)).gender(MALE).build());
		
		double result = facade.getResidualLifeExpecantcy(INSUREE_NUMBER);

		assertEquals(1.98, result, EPSILON);
	}
	
	@Test
	public void shouldGetFor50YearOldMale() {
		givenInsuree(FIFTY_YEAR_OLD_MALE.build());
		
		double result = facade.getResidualLifeExpecantcy(INSUREE_NUMBER);
		
		assertEquals(29.67, result, EPSILON);
	}

	@Test
	public void shouldGetForNewbornFemaleChild() {
		givenInsuree(Insuree.builder().birthday(NOW).gender(FEMALE).build());

		double result = facade.getResidualLifeExpecantcy(INSUREE_NUMBER);

		assertEquals(82.73, result, EPSILON);
	}

	@Test
	public void shouldGetFor100YearOldFemale() {
		givenInsuree(Insuree.builder().birthday(NOW.minusYears(100)).gender(FEMALE).build());

		double result = facade.getResidualLifeExpecantcy(INSUREE_NUMBER);

		assertEquals(2.14, result, EPSILON);
	}

	@Test
	public void shouldGetFor50YearOldFemale() {
		givenInsuree(Insuree.builder().birthday(NOW.minusYears(50)).gender(FEMALE).build());

		double result = facade.getResidualLifeExpecantcy(INSUREE_NUMBER);

		assertEquals(33.98, result, EPSILON);
	}
	
	@Test
	public void shouldGetFor50YearOldWithUnknownGender() {
		givenInsuree(Insuree.builder().birthday(NOW.minusYears(50)).gender(null).build());
		
		double result = facade.getResidualLifeExpecantcy(INSUREE_NUMBER);
		
		assertEquals(29.67, result, EPSILON);
	}

	@Test(expected = AgeIsUnknownException.class)
	public void shouldThrowWhenAgeIsUnknown() {
		givenInsuree(Insuree.builder().birthday(null).gender(null).build());

		facade.getResidualLifeExpecantcy(INSUREE_NUMBER);
	}
}
