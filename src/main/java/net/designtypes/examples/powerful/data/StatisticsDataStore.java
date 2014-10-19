package net.designtypes.examples.powerful.data;

import net.designtypes.examples.powerful.model.Gender;

import org.joda.time.Years;

public interface StatisticsDataStore {

	double getResidualLifeExpectancy(Years age, Gender gender);
	
}
