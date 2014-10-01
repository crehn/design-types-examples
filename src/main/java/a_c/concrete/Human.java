package a_c.concrete;

import java.util.Calendar;
import java.util.List;

public class Human {
	private String firstName;
	private String lastName;
	private boolean male;
	private Calendar birthday;
	private List<PersonalAttribute> personalAttributes;
	
	public List<PersonalAttribute> getPersonalAttributes() {
		return personalAttributes;
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
}
