package com.fuxl.tdd.day1.parkinglot;

public class NoThisCarException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3290253256534319744L;

	public NoThisCarException(String errorMsg) {
		super(errorMsg);
	}
}
