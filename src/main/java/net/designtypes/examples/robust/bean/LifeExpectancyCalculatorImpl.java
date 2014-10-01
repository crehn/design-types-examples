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
		InsureeData insureeData = insureeDataService.getBy(insureeNumber);

		return getResidualLifeExpecantcy(insureeData);
	}

	private Double getResidualLifeExpecantcy(InsureeData insureeData) {
		if (insureeData.getBirthday() == null)
			throw new IllegalStateException("Cannot compute life expectancy of insuree without knowing the age.");

		double residualLifeExpectancy =
				statistics.getResidualLifeExpectancy(getAge(insureeData.getBirthday()), insureeData.getGender());
		return respectSmokingHabits(insureeData.getSmokingHabit(), residualLifeExpectancy);
	}

	private int getAge(Date birthday) {
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
