package com.fuxl.tdd.oobootcamp.parkinglot;

import java.math.BigDecimal;
import java.util.List;

public class SuperParkingBoy extends ParkingBoy {

	public SuperParkingBoy(List<ParkingLot> parkingLots) {
		super(parkingLots);
	}

	@Override
	public ParkingLot findParkingLotByStrategy() {
		double vacancyRate = 0;
		ParkingLot higherParkingLot = null;
		for (ParkingLot parkingLot : parkingLots) {
			if(isVacancyRateHigher(parkingLot, vacancyRate)){
				higherParkingLot = parkingLot;
			}
		}
		return higherParkingLot;
	}

	private boolean isVacancyRateHigher(ParkingLot parkingLot, double vacancyRate) {
		double result = new BigDecimal((float)parkingLot.showParkingSpace() / parkingLot.getParkingSpace())
		.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		return  result - vacancyRate > 0;
	}	
}
