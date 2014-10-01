package t_r.robust;

import java.util.Calendar;
import java.util.List;

public class Human {
	private String firstName;
	private String lastName;
	private boolean male;
	private Calendar birthday;
	private List<PersonalAttribute> personalAttributes;

	public Human(String firstName, String lastName, boolean male, Calendar birthday,
			List<PersonalAttribute> personalAttributes) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.male = male;
		this.birthday = birthday;
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
	
	public List<PersonalAttribute> getPersonalAttributes() {
		return personalAttributes;
	}
}
