package com.fuxl.tdd.oobootcamp.parkinglot;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SuperParkingBoyTest {
	
	@Test
	public void should_park_car_to_parkinglot2_when_parkinglot2_has_higher_vacancyrate() {
		//given
		ParkingLot parkingLot1 = new ParkingLot(2);
		ParkingLot parkingLot2 = new ParkingLot(3);
		
		ParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(parkingLot1, parkingLot2));
		parkingLot1.parkCar(new Car("abc001"));
		parkingLot2.parkCar(new Car("abc002"));
		
		//when
		Car parkCar = new Car("abc003");
		String token = superParkingBoy.parkCar(parkCar);

		//then
		Car pickupCar = parkingLot2.pickupCar(token);
		assertEquals(parkCar.getCarNo(), pickupCar.getCarNo());
	}
	
}
