package net.designtypes.examples.simple.model;

import org.joda.time.LocalDate;

public class InsureeData {
	private String insureeNumber;
	private Boolean isMale;
	private LocalDate birthday;
	private SmokingHabit smokingHabit;
	
	public InsureeData(String insureeNumber) {
		this.insureeNumber = insureeNumber;
	}
	
	public String getInsureeNumber() {
		return insureeNumber;
	}

	public void setInsureeNumber(String insureeNumber) {
		this.insureeNumber = insureeNumber;
	}

	public Boolean isMale() {
		return isMale;
	}

	public void setMale(Boolean isMale) {
		this.isMale = isMale;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public SmokingHabit getSmokingHabit() {
		return smokingHabit;
	}

	public void setSmokingHabit(SmokingHabit smokingHabit) {
		this.smokingHabit = smokingHabit;
	}
}
