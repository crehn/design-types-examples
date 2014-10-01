package net.designtypes.examples.library;

import java.util.Calendar;
import java.util.Date;

public class LifeExpectancyCalculator {

	private StatisticsTable statistics = new StatisticsTable();

	public double getResidualLifeExpecantcy(Date birthday, boolean isMale, SmokingHabit smokingHabit) {
		if (birthday == null)
			throw new IllegalStateException("Cannot compute life expectancy of insuree without knowing the age.");

		double residualLifeExpectancy = statistics.getResidualLifeExpectancy(getAge(birthday), isMale);
		return respectSmokingHabits(smokingHabit, residualLifeExpectancy);
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

		double reduction;
		switch (smokingHabit) {
		case NON_SMOKER:
			reduction = 0.0;
			break;
		case STOPPED_SMOKING:
			reduction = 2.0;
			break;
		case LESS_THAN_5_CIGARETTES_PER_DAY:
			reduction = 4.7;
			break;
		case LESS_THAN_20_CIGARETTES_PER_DAY:
			reduction = 8.3;
			break;
		case MORE_THAN_20_CIGARETTES_PER_DAY:
			reduction = 10.1;
			break;
		default:
			reduction = 00.0;
			break;
		}
		return residualLifeExpectancy - reduction;
	}
}
