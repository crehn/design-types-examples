package net.designtypes.examples.technologic.control;

import javax.inject.Inject;

import lombok.extern.slf4j.Slf4j;
import net.designtypes.examples.technologic.data.StatisticsDataStore;
import net.designtypes.examples.technologic.gateway.InsureeDataServiceGateway;
import net.designtypes.examples.technologic.gateway.SystemTimeGateway;
import net.designtypes.examples.technologic.lib.Logged;
import net.designtypes.examples.technologic.model.Insuree;
import net.designtypes.examples.technologic.model.InsureeNumber;

import org.joda.time.Years;

@Slf4j
@Logged
public class LifeExpectancyFacade {

	@Inject
	private InsureeDataServiceGateway insureeData;

	@Inject
	private StatisticsDataStore store;
	
	@Inject
	private SystemTimeGateway time;
	
	public double getResidualLifeExpecantcy(InsureeNumber insureeNumber) {
		Insuree insuree = insureeData.getBy(insureeNumber);

		return getResidualLifeExpectancy(insuree);
	}
	
	private double getResidualLifeExpectancy(Insuree insuree) {
		Years age = insuree.getAge(time.now());
		if (age == null)
			throw new AgeIsUnknownException("Cannot compute life expectancy of insuree " + insuree.getInsureeNumber()
					+ " without knowing the age.");
		
		double residualLifeExpectancy = store.getResidualLifeExpectancy(age, insuree.getGender());
		return respectSmokingHabits(insuree, residualLifeExpectancy);
	}

	private double respectSmokingHabits(Insuree insuree, double residualLifeExpectancy) {
		if (insuree.getSmokingHabit() == null)
			return residualLifeExpectancy;

		double reduction = insuree.getSmokingHabit().getLifeExpectancyReduction();
		log.debug("reduce life expectancy for [{}] by [{}] due to smoking", insuree.getInsureeNumber(), reduction);
		return residualLifeExpectancy - reduction;
	}
}
