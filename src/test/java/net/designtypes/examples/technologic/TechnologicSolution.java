package net.designtypes.examples.technologic;

import static net.designtypes.examples.DummyData.*;
import static org.mockito.Mockito.*;
import net.designtypes.examples.SmokingHabitTestType;
import net.designtypes.examples.Solution;
import net.designtypes.examples.technologic.control.LifeExpectancyFacade;
import net.designtypes.examples.technologic.data.StatisticsDataStore;
import net.designtypes.examples.technologic.gateway.InsureeDataServiceGateway;
import net.designtypes.examples.technologic.gateway.SystemTimeGateway;
import net.designtypes.examples.technologic.model.*;

import org.joda.time.LocalDate;
import org.mockito.*;

public class TechnologicSolution extends Solution {

	@InjectMocks
	private LifeExpectancyFacade facade;
	@Spy
	private StatisticsDataStore store;
	@Mock
	private InsureeDataServiceGateway insureeData;
	@Mock
	private SystemTimeGateway time;

	public TechnologicSolution() {
		MockitoAnnotations.initMocks(this);
		when(time.now()).thenReturn(NOW);
	}
	
	@Override
	public String getName() {
		return "technologic";
	}
	
	@Override
	public void given50YearOldMaleInsuree(SmokingHabitTestType smokingHabit) {
		Insuree insuree = Insuree.builder() //
				.birthday(NOW.minusYears(50)) //
				.gender(toTechnologic(GenderTestType.MALE)) //
				.smokingHabit(toTechnologic(smokingHabit)) //
				.build();
		when(insureeData.getBy(new InsureeNumber(INSUREE_NUMBER))).thenReturn(insuree);
	}

	private SmokingHabit toTechnologic(SmokingHabitTestType smokingHabit) {
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
		Insuree insuree = Insuree.builder() //
				.birthday(dateOfBirth) //
				.gender(toTechnologic(gender)) //
				.build();
		when(insureeData.getBy(new InsureeNumber(INSUREE_NUMBER))).thenReturn(insuree);
	}
	
	private Gender toTechnologic(GenderTestType gender) {
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
	public double getResidualLifeExpectancy(String insureeNumber) {
		return facade.getResidualLifeExpecantcy(new InsureeNumber(insureeNumber));
	}
}
