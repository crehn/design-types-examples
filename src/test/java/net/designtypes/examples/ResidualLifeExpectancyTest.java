package net.designtypes.examples;

import static net.designtypes.examples.DummyData.*;
import static net.designtypes.examples.Solution.GenderTestType.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ResidualLifeExpectancyTest extends AbstractResidualLifeExpectancyTest {
	
	@Test
	public void shouldGetForNewbornMaleChild() {
		for (Solution solution : solutions) {
			solution.givenInsuree(NOW, MALE);
			
			double result = solution.getResidualLifeExpecancy(INSUREE_NUMBER);

			assertEquals(77.72, result, EPSILON);
		}
	}
	
	@Test
	public void shouldGetFor100YearOldMale() {
		for (Solution solution : solutions) {
			solution.givenInsuree(NOW.minusYears(100), MALE);
			
			double result = solution.getResidualLifeExpecancy(INSUREE_NUMBER);

			assertEquals(1.98, result, EPSILON);
		}
	}
	
	@Test
	public void shouldGetFor50YearOldMale() {
		for (Solution solution : solutions) {
			solution.givenInsuree(NOW.minusYears(50), MALE);
			
			double result = solution.getResidualLifeExpecancy(INSUREE_NUMBER);
			
			assertEquals(29.67, result, EPSILON);
		}
	}
	
	@Test
	public void shouldGetForNewbornFemaleChild() {
		for (Solution solution : solutions) {
			solution.givenInsuree(NOW, FEMALE);

			double result = solution.getResidualLifeExpecancy(INSUREE_NUMBER);

			assertEquals(82.73, result, EPSILON);
		}
	}

	@Test
	public void shouldGetFor100YearOldFemale() {
		for (Solution solution : solutions) {
			solution.givenInsuree(NOW.minusYears(100), FEMALE);

			double result = solution.getResidualLifeExpecancy(INSUREE_NUMBER);

			assertEquals(2.14, result, EPSILON);
		}
	}

	@Test
	public void shouldGetFor50YearOldFemale() {
		for (Solution solution : solutions) {
			solution.givenInsuree(NOW.minusYears(50), FEMALE);

			double result = solution.getResidualLifeExpecancy(INSUREE_NUMBER);

			assertEquals(33.98, result, EPSILON);
		}
	}
	
	@Test
	public void shouldGetFor50YearOldWithUnknownGender() {
		for (Solution solution : solutions) {
			solution.givenInsuree(NOW.minusYears(50), null);
			
			double result = solution.getResidualLifeExpecancy(INSUREE_NUMBER);
			
			assertEquals(29.67, result, EPSILON);
		}
	}
	
	@Test
	public void shouldThrowWhenAgeIsUnknown() {
		for (Solution solution : solutions) {
			try {
				solution.givenInsuree(null, MALE);
				
				solution.getResidualLifeExpecancy(INSUREE_NUMBER);
				fail("expected exception for solution " + solution.getName());
			} catch (Exception e) {
				// ok
			}
		}
	}
}
