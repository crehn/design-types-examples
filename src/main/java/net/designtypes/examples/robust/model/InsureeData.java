package net.designtypes.examples.robust.model;

import java.util.Date;

public class InsureeData {
	private String insureeNumber;
	private Gender gender;
	private Date birthday;
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
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public SmokingHabit getSmokingHabit() {
		return smokingHabit;
	}
	
	public void setSmokingHabit(SmokingHabit smokingHabit) {
		this.smokingHabit = smokingHabit;
	}
}
