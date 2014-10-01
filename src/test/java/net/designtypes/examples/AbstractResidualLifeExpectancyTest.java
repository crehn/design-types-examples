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
	protected static final InsureeBuilder FIFTY_YEAR_OLD_MALE = Insuree.builder().birthday(NOW.minusYears(50))
				.gender(MALE);
	protected static final InsureeNumber INSUREE_NUMBER = new InsureeNumber("12345");
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

}
