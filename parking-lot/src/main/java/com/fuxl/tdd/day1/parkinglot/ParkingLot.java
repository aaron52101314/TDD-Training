package com.fuxl.tdd.day1.parkinglot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParkingLot {

	private int parkingSpace;
	
	private List<String> cardList = new ArrayList<String>();
	
	public ParkingLot(int parkingSpace) {
		this.parkingSpace = parkingSpace;
	}

	public Object parkCar(String cardNo) {
		if(cardList.size() == parkingSpace){
			throw new NoAvailableParkingspaceException("No Available Parkingspace..");
		}
		cardList.add(cardNo);
		return cardNo;
	}

	public void pickupCar(String cardNo) {
		if(!cardList.contains(cardNo)){
			throw new NoThisCarException("No This Car in the ParkingLot!!");
		}
		Iterator<String> iter = cardList.iterator();
		while (iter.hasNext()) {
			String item = iter.next();
			if (item.equals(cardNo)) {
				iter.remove();
			}
		}
	}

	public int showParkingSpace() {
		return parkingSpace - cardList.size();
	}

}
