package com.fuxl.tdd.day1.parkinglot;

public class NoAvailableParkingspaceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7592531659203484590L;

	public NoAvailableParkingspaceException(String errorMsg) {
		super(errorMsg);
	}

}
