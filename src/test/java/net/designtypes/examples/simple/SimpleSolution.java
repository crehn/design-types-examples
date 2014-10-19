package net.designtypes.examples.simple;

import static net.designtypes.examples.DummyData.*;
import static org.mockito.Mockito.*;
import net.designtypes.examples.SmokingHabitTestType;
import net.designtypes.examples.Solution;
import net.designtypes.examples.simple.base.*;
import net.designtypes.examples.simple.model.InsureeData;
import net.designtypes.examples.simple.model.SmokingHabit;
import net.designtypes.examples.simple.rest.LifeExpectancyCalculator;

import org.joda.time.LocalDate;
import org.mockito.*;

public class SimpleSolution extends Solution {
	
	@InjectMocks
	private LifeExpectancyCalculator calculator;
	@Spy
	private StatisticsTable statistics;
	@Mock
	private InsureeDataServiceGateway insureeData;
	@Mock
	private SystemTimeGateway time;

	public SimpleSolution() {
		MockitoAnnotations.initMocks(this);
		when(time.now()).thenReturn(NOW);
	}
	
	@Override
	public String getName() {
		return "simple";
	}

	@Override
	public void given50YearOldMaleInsuree(SmokingHabitTestType smokingHabit) {
		InsureeData insuree = new InsureeData(INSUREE_NUMBER);
		insuree.setBirthday(NOW.minusYears(50));
		insuree.setMale(true);
		insuree.setSmokingHabit(toSimple(smokingHabit));
		when(insureeData.getBy(INSUREE_NUMBER)).thenReturn(insuree);
	}
	
	private SmokingHabit toSimple(SmokingHabitTestType smokingHabit) {
		switch (smokingHabit) {
		case NON_SMOKER:
			return SmokingHabit.NON_SMOKER;
		case STOPPED_SMOKING:
			return SmokingHabit.STOPPED_SMOKING;
		case LESS_THAN_5_CIGARETTES_PER_DAY:
			return SmokingHabit.LESS_THAN_5_CIGARETTES_PER_DAY;
		case LESS_THAN_20_CIGARETTES_PER_DAY:
			return SmokingHabit.LESS_THAN_20_CIGARETTES_PER_DAY;
		case MORE_THAN_20_CIGARETTES_PER_DAY:
			return SmokingHabit.MORE_THAN_20_CIGARETTES_PER_DAY;
		}
		throw new RuntimeException();
	}

	@Override
	public void givenInsuree(LocalDate dateOfBirth, GenderTestType gender) {
		InsureeData insuree = new InsureeData(INSUREE_NUMBER);
		insuree.setBirthday(dateOfBirth);
		insuree.setMale(toSimple(gender));
		when(insureeData.getBy(INSUREE_NUMBER)).thenReturn(insuree);
	}

	private Boolean toSimple(GenderTestType gender) {
		if (gender == null)
			return null;

		switch (gender) {
		case MALE:
			return true;
		case FEMALE:
			return false;
		}
		throw new RuntimeException();
	}
	
	@Override
	public double getResidualLifeExpectancy(String insureeNumber) {
		return Double.parseDouble(calculator.getResidualLifeExpecancy(insureeNumber));
	}
}
