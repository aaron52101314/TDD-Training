package com.fuxl.tdd.oobootcamp.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

	private int parkingSpace;
	
	private Map<String, Car> parkedCars = new HashMap<String, Car>();
	
	public ParkingLot(int parkingSpace) {
		this.parkingSpace = parkingSpace;
	}

	public String parkCar(Car car) {
		if(parkedCars.size() == parkingSpace){
			throw new NoAvailableParkingspaceException("No Available Parkingspace..");
		}
		parkedCars.put(car.getCarNo(), car);
		return car.getCarNo();
	}

	public Car pickupCar(String token) {
		if(!parkedCars.containsKey(token)){
			throw new NoThisCarException("No This Car in the ParkingLot!!");
		}
		return parkedCars.remove(token);
	}

	public int getParkingSpace() {
		return parkingSpace;
	}

	public void setParkingSpace(int parkingSpace) {
		this.parkingSpace = parkingSpace;
	}

	public int showParkingSpace() {
		return parkingSpace - parkedCars.size();
	}

	public boolean contains(String token) {
		return parkedCars.containsKey(token);
	}

}
