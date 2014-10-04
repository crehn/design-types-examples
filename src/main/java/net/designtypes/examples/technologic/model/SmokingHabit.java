package net.designtypes.examples.technologic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SmokingHabit {
	NON_SMOKER(0.0),
	STOPPED_SMOKING(2.0),
	LESS_THAN_5_CIGARETTES_PER_DAY(4.7),
	LESS_THAN_20_CIGARETTES_PER_DAY(8.3),
	MORE_THAN_20_CIGARETTES_PER_DAY(10.1);

	private final double lifeExpectancyReduction;
}
