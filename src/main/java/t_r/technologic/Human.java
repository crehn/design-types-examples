package t_r.technologic;

import java.util.List;

import javolution.util.FastTable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import org.joda.time.DateTime;

@ToString
public class Human {
	@Getter private String firstName;
	@Getter private String lastName;
	@Getter private boolean male;
	@Getter private DateTime birthday;
	@Getter @Setter(AccessLevel.PROTECTED) @NonNull private FastTable<PersonalAttribute> personalAttributes;

	public Human(String firstName, String lastName, boolean male, DateTime birthday,
			List<PersonalAttribute> personalAttributes) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.male = male;
		this.birthday = birthday;
	}

	protected List<PersonalAttribute> getPersonalAttributes() {
		return personalAttributes.unmodifiable();
	}
}
