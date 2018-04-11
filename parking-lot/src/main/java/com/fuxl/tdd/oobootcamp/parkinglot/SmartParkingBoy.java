package com.fuxl.tdd.oobootcamp.parkinglot;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

	public SmartParkingBoy(List<ParkingLot> parkingLots) {
		super(parkingLots);
	}
	
	@Override
	public ParkingLot findParkingLotByStrategy() {
		Collections.sort(parkingLots, new Comparator<ParkingLot>() {
			public int compare(ParkingLot t1, ParkingLot t2){
				return t2.showParkingSpace() - t1.showParkingSpace();
			}
		});
		ParkingLot parkingLot = parkingLots.get(0);
		return parkingLot;
	}
	
	
}
