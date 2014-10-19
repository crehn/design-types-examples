package net.designtypes.examples.powerful.data.impl;

import javax.enterprise.inject.Alternative;

import net.designtypes.examples.powerful.data.StatisticsDataStore;
import net.designtypes.examples.powerful.model.Gender;

import org.joda.time.Years;

@Alternative
public class DatabaseStatisticsDataStore implements StatisticsDataStore {

	@Override
	public double getResidualLifeExpectancy(Years age, Gender gender) {
		// load data from database
		return 0;
	}
	
}
