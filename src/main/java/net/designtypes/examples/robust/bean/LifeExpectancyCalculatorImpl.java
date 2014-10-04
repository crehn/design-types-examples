package net.designtypes.examples.robust.bean;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import net.designtypes.examples.robust.api.LifeExpectancyCalculator;
import net.designtypes.examples.robust.bean.local.*;
import net.designtypes.examples.robust.model.InsureeData;
import net.designtypes.examples.robust.model.SmokingHabit;

import org.apache.log4j.MDC;

@Stateless
public class LifeExpectancyCalculatorImpl implements LifeExpectancyCalculator {
	private static final org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(LifeExpectancyCalculatorImpl.class);
	
	@EJB
	private StatisticsTable statistics;
	
	@EJB
	private InsureeDataServiceGateway insureeDataService;
	
	@EJB
	private SystemTimeGateway time;
	
	@Override
	public Double getResidualLifeExpecancy(String insureeNumber) throws RemoteException {
		MDC.put("insureeNumber", insureeNumber);
		try {
			log.info("get residualk life expectancy");
			InsureeData insureeData = insureeDataService.getBy(insureeNumber);
			
			Double result = getResidualLifeExpecantcy(insureeData);
			log.info("return residual life expectancy: " + result);
			return result;
		} finally {
			MDC.remove("insureeNumber");
		}
	}
	
	private Double getResidualLifeExpecantcy(InsureeData insuree) {
		if (insuree.getBirthday() == null) {
			String message = "Cannot compute life expectancy of insuree without knowing the age.";
			log.warn(message);
			throw new IllegalStateException(message);
		}
		
		double residualLifeExpectancy =
				statistics.getResidualLifeExpectancy(getAge(insuree.getBirthday()), insuree.getGender());
		return respectSmokingHabits(insuree.getSmokingHabit(), residualLifeExpectancy);
	}
	
	private int getAge(Date birthday) {
		assert birthday != null;

		Calendar dob = Calendar.getInstance();
		dob.setTime(birthday);
		Calendar today = Calendar.getInstance();
		int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
		if (today.get(Calendar.MONTH) < dob.get(Calendar.MONTH)) {
			age--;
		} else if (today.get(Calendar.MONTH) == dob.get(Calendar.MONTH)
				&& today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH)) {
			age--;
		}
		return age;
	}
	
	private double respectSmokingHabits(SmokingHabit smokingHabit, double residualLifeExpectancy) {
		if (smokingHabit == null)
			return residualLifeExpectancy;
		
		double reduction = smokingHabit.getLifeExpectancyReduction();
		log.debug("reduce life expectancy by [" + reduction + "] due to smoking");
		return residualLifeExpectancy - reduction;
	}
}
