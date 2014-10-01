package net.designtypes.examples.simple.rest;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import net.designtypes.examples.simple.base.*;
import net.designtypes.examples.simple.model.InsureeData;
import net.designtypes.examples.simple.model.SmokingHabit;

import org.joda.time.LocalDate;
import org.joda.time.Years;

@Path("/insurees")
public class LifeExpectancyCalculator {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LifeExpectancyCalculator.class);

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
		log.info("get life expectency for insuree: " + insureeNumber);
		InsureeData insureeData = insureeDataService.getBy(insureeNumber);
		String result = getResidualLifeExpecantcy(insureeData).toString();
		log.info("got life expectency for insuree [" + insureeNumber + "]: " + result);
		return result;
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
		log.debug("reduce life expectancy by [{}] due to smoking", reduction);
		return residualLifeExpectancy - reduction;
	}
}
