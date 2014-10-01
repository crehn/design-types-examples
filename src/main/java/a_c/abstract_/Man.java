package a_c.abstract_;

import java.util.Calendar;
import java.util.List;

public class Man extends Human {

	private Gender gender;
	
	public Man(String firstName, String lastName, Calendar birthday,
			List<PersonalAttribute> personalAttributes) {
		super(firstName, lastName, birthday, personalAttributes);
		this.gender = Gender.male;
	}

	@Override
	public Gender getGender() {
		return this.gender;
	}

}
