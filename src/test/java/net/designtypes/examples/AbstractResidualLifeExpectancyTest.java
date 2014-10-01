package net.designtypes.examples;

import static net.designtypes.examples.my.model.Gender.*;
import static org.mockito.Mockito.*;
import net.designtypes.examples.my.control.LifeExpectancyFacade;
import net.designtypes.examples.my.data.StatisticsDataStore;
import net.designtypes.examples.my.gateway.InsureeDataServiceGateway;
import net.designtypes.examples.my.gateway.SystemTimeGateway;
import net.designtypes.examples.my.model.*;
import net.designtypes.examples.my.model.Insuree.InsureeBuilder;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.mockito.*;

public abstract class AbstractResidualLifeExpectancyTest {

	protected static final double EPSILON = 0.1;
	protected static final LocalDate NOW = new LocalDate(2014, 10, 01);

	protected static final InsureeNumber INSUREE_NUMBER = new InsureeNumber("12345");
	protected static final InsureeBuilder INSUREE_BUILDER = Insuree.builder().insureeNumber(INSUREE_NUMBER);
	
	@InjectMocks
	protected LifeExpectancyFacade facade;
	@Spy
	StatisticsDataStore store;
	@Mock
	InsureeDataServiceGateway insureeData;
	@Mock
	SystemTimeGateway time;

	@Before
	public void setup() {
		when(time.now()).thenReturn(NOW);
	}

	protected void givenInsuree(Insuree insuree) {
		when(insureeData.getBy(INSUREE_NUMBER)).thenReturn(insuree);
	}
	
	protected InsureeBuilder generateFiftyYearOldMale() {
		return generateInsuree() //
				.birthday(NOW.minusYears(50)) //
				.gender(MALE);
	}
	
	protected InsureeBuilder generateInsuree() {
		return Insuree.builder() //
				.insureeNumber(INSUREE_NUMBER);
	}

}
