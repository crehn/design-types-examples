package net.designtypes.examples.my.model;

import lombok.Value;

@Value
public class InsureeNumber {
	String value;
	
	@Override
	public String toString() {
		return value;
	}
}
