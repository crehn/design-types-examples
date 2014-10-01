package net.designtypes.examples.robust;

import static net.designtypes.examples.DummyData.*;
import static org.mockito.Mockito.*;

import java.rmi.RemoteException;

import net.designtypes.examples.SmokingHabitTestType;
import net.designtypes.examples.Solution;
import net.designtypes.examples.robust.bean.LifeExpectancyCalculatorImpl;
import net.designtypes.examples.robust.bean.local.*;
import net.designtypes.examples.robust.model.*;

import org.joda.time.LocalDate;
import org.mockito.*;

public class RobustSolution extends Solution {

	@InjectMocks
	private LifeExpectancyCalculatorImpl calculator;
	@Spy
	private StatisticsTable statistics;
	@Mock
	private InsureeDataServiceGateway insureeData;
	@Mock
	private SystemTimeGateway time;
	
	public RobustSolution() {
		MockitoAnnotations.initMocks(this);
		when(time.now()).thenReturn(NOW.toDate());
	}

	@Override
	public String getName() {
		return "robust";
	}
	
	@Override
	public void given50YearOldMaleInsuree(SmokingHabitTestType smokingHabit) {
		InsureeData insuree = new InsureeData(INSUREE_NUMBER);
		insuree.setBirthday(NOW.minusYears(50).toDate());
		insuree.setGender(Gender.MALE);
		insuree.setSmokingHabit(toRobust(smokingHabit));
		when(insureeData.getBy(INSUREE_NUMBER)).thenReturn(insuree);
	}

	private SmokingHabit toRobust(SmokingHabitTestType smokingHabit) {
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
		insuree.setBirthday(dateOfBirth.toDate());
		insuree.setGender(toRobust(gender));
		when(insureeData.getBy(INSUREE_NUMBER)).thenReturn(insuree);
	}
	
	private Gender toRobust(GenderTestType gender) {
		if (gender == null)
			return null;
		
		switch (gender) {
		case MALE:
			return Gender.MALE;
		case FEMALE:
			return Gender.FEMALE;
		}
		throw new RuntimeException();
	}

	@Override
	public double getResidualLifeExpecancy(String insureeNumber) {
		try {
			return calculator.getResidualLifeExpecancy(insureeNumber);
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}
	}
}
