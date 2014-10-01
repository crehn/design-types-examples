package net.designtypes.examples;

import org.joda.time.LocalDate;

public abstract class Solution {
	
	public enum GenderTestType {
		MALE, FEMALE
	}
	
	public abstract String getName();

	public abstract double getResidualLifeExpecancy(String insureeNumber);
	
	public abstract void givenInsuree(LocalDate dateOfBirth, GenderTestType male);
	
	public abstract void given50YearOldMaleInsuree(SmokingHabitTestType stoppedSmoking);

}
