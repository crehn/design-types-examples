package s_p.powerful;

import java.util.Calendar;
import java.util.List;

public abstract class Human {
	private String firstName;
	private String lastName;
	private boolean male;
	private Calendar birthday;
	private List<PersonalAttribute> personalAttributes;
	
	public float calculateLifeExpectancy(ILifeExpectancyTable lifeExpTable, CalculationContext calcCtx) {
		float lifeExpectancy;
		lifeExpectancy = lifeExpTable.getStatisticalLifeExpectancy(this.birthday, this.male);
		lifeExpectancy += calculateLifeExpectancyOffset(this.personalAttributes);
		lifeExpectancy = lifeExpectancy * calcCtx.getSpecificCalulationFactor();
		return lifeExpectancy;
	}
	
	protected abstract float calculateLifeExpectancyOffset(List<PersonalAttribute> personalAttributes);

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
