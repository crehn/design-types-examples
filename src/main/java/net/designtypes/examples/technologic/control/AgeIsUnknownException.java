package net.designtypes.examples.technologic.control;

public class AgeIsUnknownException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public AgeIsUnknownException(String message) {
		super(message);
	}
}
