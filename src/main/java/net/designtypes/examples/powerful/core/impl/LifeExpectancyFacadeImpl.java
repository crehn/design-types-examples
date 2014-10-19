package net.designtypes.examples.powerful.core.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import net.designtypes.examples.powerful.core.LifeExpectancyFacade;
import net.designtypes.examples.powerful.data.StatisticsDataStore;
import net.designtypes.examples.powerful.gateway.InsureeDataServiceGateway;
import net.designtypes.examples.powerful.gateway.SystemTimeGateway;
import net.designtypes.examples.powerful.lib.Logged;
import net.designtypes.examples.powerful.model.Insuree;
import net.designtypes.examples.powerful.model.InsureeNumber;

import org.joda.time.Years;

@Logged
@Stateless
@WebService
public class LifeExpectancyFacadeImpl implements LifeExpectancyFacade {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LifeExpectancyFacadeImpl.class);

	@Inject
	private InsureeDataServiceGateway insureeData;

	@Inject
	private StatisticsDataStore store;
	
	@Inject
	private SystemTimeGateway time;
	
	@Override
	@WebMethod
	public double getResidualLifeExpectancy(InsureeNumber insureeNumber) {
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
