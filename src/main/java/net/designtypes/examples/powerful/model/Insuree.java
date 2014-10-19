package net.designtypes.examples.powerful.model;

import org.joda.time.LocalDate;
import org.joda.time.Years;

public class Insuree {
	private InsureeNumber insureeNumber;
	private Gender gender;
	private LocalDate birthday;
	private SmokingHabit smokingHabit;

	public Insuree(InsureeNumber insureeNumber) {
		this.insureeNumber = insureeNumber;
	}
	
	public Years getAge(LocalDate now) {
		if (birthday == null)
			return null;
		
		return Years.yearsBetween(birthday, now);
	}

	public InsureeNumber getInsureeNumber() {
		return insureeNumber;
	}

	public void setInsureeNumber(InsureeNumber insureeNumber) {
		this.insureeNumber = insureeNumber;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
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
