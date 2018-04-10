package com.fuxl.tdd.oobootcamp.parkinglot;

import java.util.List;

public class ParkingBoy {

	private List<ParkingLot> parkingLots;
	
	public ParkingBoy(List<ParkingLot> parkingLots) {
		this.parkingLots = parkingLots;
	}

	public String parkCar(Car car) {
		for (ParkingLot parkingLot : parkingLots) {
			if(parkingLot.showParkingSpace() > 0){
				String token = parkingLot.parkCar(car);
				if(token != null) {
					return token;
				}
			}
		}
		throw new NoAvailableParkingspaceException("No Available Parkingspace..");
	}

	public Car pickupCar(String token) {
		for (ParkingLot parkingLot : parkingLots) {
			if(parkingLot.contains(token)){
				return parkingLot.pickupCar(token);
			}
		}
		throw new NoThisCarException("No This Car in the ParkingLot!!");
	}

}
