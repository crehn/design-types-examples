package net.designtypes.examples.powerful.core.impl;

public class AgeIsUnknownException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public AgeIsUnknownException(String message) {
		super(message);
	}
}
