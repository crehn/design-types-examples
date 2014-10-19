package net.designtypes.examples.powerful;

import static net.designtypes.examples.DummyData.*;
import static org.mockito.Mockito.*;
import net.designtypes.examples.SmokingHabitTestType;
import net.designtypes.examples.Solution;
import net.designtypes.examples.powerful.core.impl.LifeExpectancyFacadeImpl;
import net.designtypes.examples.powerful.data.impl.InMemoryStatisticsDataStore;
import net.designtypes.examples.powerful.gateway.impl.InsureeDataServiceGatewayImpl;
import net.designtypes.examples.powerful.gateway.impl.SystemTimeGatewayImpl;
import net.designtypes.examples.powerful.model.*;

import org.joda.time.LocalDate;
import org.mockito.*;

public class PowerfulSolution extends Solution {
	
	@InjectMocks
	private LifeExpectancyFacadeImpl facade;
	@Spy
	private InMemoryStatisticsDataStore store;
	@Mock
	private InsureeDataServiceGatewayImpl insureeData;
	@Mock
	private SystemTimeGatewayImpl time;

	public PowerfulSolution() {
		MockitoAnnotations.initMocks(this);
		when(time.now()).thenReturn(NOW);
	}
	
	@Override
	public String getName() {
		return "powerful";
	}

	@Override
	public double getResidualLifeExpectancy(String insureeNumber) {
		return facade.getResidualLifeExpectancy(new InsureeNumber(insureeNumber));
	}

	@Override
	public void givenInsuree(LocalDate dateOfBirth, GenderTestType gender) {
		Insuree insuree = new Insuree(new InsureeNumber(INSUREE_NUMBER));
		insuree.setBirthday(dateOfBirth);
		insuree.setGender(toPowerful(gender));
		when(insureeData.getBy(new InsureeNumber(INSUREE_NUMBER))).thenReturn(insuree);
	}

	private Gender toPowerful(GenderTestType gender) {
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
	public void given50YearOldMaleInsuree(SmokingHabitTestType smokingHabit) {
		Insuree insuree = new Insuree(new InsureeNumber(INSUREE_NUMBER));
		insuree.setBirthday(NOW.minusYears(50));
		insuree.setGender(Gender.MALE);
		insuree.setSmokingHabit(toPowerful(smokingHabit));
		when(insureeData.getBy(new InsureeNumber(INSUREE_NUMBER))).thenReturn(insuree);
	}
	
	private SmokingHabit toPowerful(SmokingHabitTestType smokingHabit) {
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
	
}
