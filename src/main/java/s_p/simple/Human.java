package s_p.simple;

import java.util.Calendar;

public class Human {
	// typical variables
	private String firstName;
	private String lastName;
	private boolean male;
	private Calendar birthday;
	// additional attributes
	private boolean smoker;
	private boolean athlete;
	
	public float calculateLifeExpectancy() {
		float lifeExpectancy;
		lifeExpectancy = LifeExpectancyTable.getStatisticalLifeExpectancy(this.birthday, this.male);
		if (this.smoker) {
			lifeExpectancy -= 5;
		}
		if (this.athlete) {
			lifeExpectancy += 2;
		}
		return lifeExpectancy;
	}

	public Human(String firstName, String lastName, boolean male,
			Calendar birthday, boolean smoker, boolean athlete) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.male = male;
		this.birthday = birthday;
		this.smoker = smoker;
		this.athlete = athlete;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public boolean isMale() {
		return male;
	}

	public Calendar getBirthday() {
		return birthday;
	}

	public boolean isSmoker() {
		return smoker;
	}

	public boolean isAthlete() {
		return athlete;
	}
}
