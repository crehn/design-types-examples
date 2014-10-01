package net.designtypes.examples.simple;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.joda.time.LocalDate;
import org.joda.time.Years;

@Path("/insurees")
public class LifeExpectancyCalculator {

	@Inject
	private StatisticsTable statistics;

	@Inject
	private InsureeDataServiceGateway insureeDataService;

	@Inject
	private SystemTimeGateway time;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{insureeNumber}/residualLifeExpectancy")
	public String getResidualLifeExpecancy(@PathParam("insureeNumber") String insureeNumber) {
		InsureeData insureeData = insureeDataService.getBy(insureeNumber);

		return getResidualLifeExpecantcy(insureeData).toString();
	}

	private Double getResidualLifeExpecantcy(InsureeData insureeData) {
		if (insureeData.getBirthday() == null)
			throw new IllegalStateException("Cannot compute life expectancy of insuree without knowing the age.");

		double residualLifeExpectancy =
				statistics.getResidualLifeExpectancy(getAge(insureeData.getBirthday()), insureeData.isMale());
		return respectSmokingHabits(insureeData.getSmokingHabit(), residualLifeExpectancy);
	}

	private int getAge(LocalDate birthday) {
		return Years.yearsBetween(birthday, time.now()).getYears();
	}

	private double respectSmokingHabits(SmokingHabit smokingHabit, double residualLifeExpectancy) {
		if (smokingHabit == null)
			return residualLifeExpectancy;

		double reduction = smokingHabit.getLifeExpectancyReduction();
		return residualLifeExpectancy - reduction;
	}
}
