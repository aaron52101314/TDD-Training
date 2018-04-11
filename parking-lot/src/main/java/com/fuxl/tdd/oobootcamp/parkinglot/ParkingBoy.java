package com.fuxl.tdd.oobootcamp.parkinglot;

import java.util.List;

public class ParkingBoy {

	protected List<ParkingLot> parkingLots;
	
	public ParkingBoy(List<ParkingLot> parkingLots) {
		this.parkingLots = parkingLots;
	}

	public String parkCar(Car car) {
		ParkingLot parkingLot = this.findParkingLotByStrategy();
		return parkingLot.parkCar(car);
	}

	public ParkingLot findParkingLotByStrategy(){
		ParkingLot matchParkingLot = null;
		for (ParkingLot parkingLot : parkingLots) {
			if(parkingLot.showParkingSpace() > 0){
				matchParkingLot = parkingLot;
			}
		}
		if(matchParkingLot == null){
			throw new NoAvailableParkingspaceException("No Available Parkingspace..");
		}
		return matchParkingLot;
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
