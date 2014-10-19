package net.designtypes.examples;

import org.joda.time.LocalDate;

public abstract class Solution {
	
	public enum GenderTestType {
		MALE, FEMALE
	}
	
	public abstract String getName();

	public abstract double getResidualLifeExpectancy(String insureeNumber);
	
	public abstract void givenInsuree(LocalDate dateOfBirth, GenderTestType gender);
	
	public abstract void given50YearOldMaleInsuree(SmokingHabitTestType smokingHabit);

}
