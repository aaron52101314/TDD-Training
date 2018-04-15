package com.fuxl.tdd.oobootcamp.parkinglot;

import java.util.List;

public class ParkingManager {

	private List<ParkingBoy> parkingBoys;
	private List<ParkingLot> parkingLots;
	
	public ParkingManager(List<ParkingLot> parkingLots, List<ParkingBoy> parkingBoys) {
		this.parkingLots = parkingLots;
		this.parkingBoys = parkingBoys;
	}

	public String parkCar(Car car) {
		for (ParkingLot parkingLot : parkingLots) {
			if(parkingLot.showParkingSpace() > 0){
				return parkingLot.parkCar(car);
			}
		}
		for (ParkingBoy parkingBoy : parkingBoys) {
			return parkingBoy.parkCar(car);
		}
		
		throw new NoAvailableParkingspaceException("No Available Parkingspace..");
	}

}
