package net.designtypes.examples.technologic.model;

import lombok.Value;

@Value
public class InsureeNumber {
	String value;
	
	@Override
	public String toString() {
		return value;
	}
}
