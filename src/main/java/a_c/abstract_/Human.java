package a_c.abstract_;

import java.util.Calendar;
import java.util.List;

public abstract class Human {
	private String firstName;
	private String lastName;
	private Calendar birthday;
	private List<PersonalAttribute> personalAttributes;
	private LifeExpectancy lifeExpectancy;
	
	public Human(String firstName, String lastName, Calendar birthday,
			List<PersonalAttribute> personalAttributes) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.personalAttributes = personalAttributes;
		this.lifeExpectancy = new LifeExpectancy(this);
	}
	
	public abstract Gender getGender();
	
	public void addPersonalAttribute(PersonalAttribute personalAttribute) {
		this.personalAttributes.add(personalAttribute);
		this.lifeExpectancy = new LifeExpectancy(this);
	}

	public List<PersonalAttribute> getPersonalAttributes() {
		return personalAttributes;
	}
	
	public LifeExpectancy getLifeExpectancy() {
		return lifeExpectancy;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Calendar getBirthday() {
		return birthday;
	}
}
