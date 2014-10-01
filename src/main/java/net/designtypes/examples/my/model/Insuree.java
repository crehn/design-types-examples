package net.designtypes.examples.my.model;

import lombok.Data;
import lombok.experimental.Builder;

import org.joda.time.LocalDate;
import org.joda.time.Years;

@Data
@Builder
public class Insuree {
	private InsureeNumber insureeNumber;
	private Gender gender;
	private LocalDate birthday;
	private SmokingHabit smokingHabit;
	
	public Years getAge(LocalDate now) {
		if (birthday == null)
			return null;

		return Years.yearsBetween(birthday, now);
	}
}
