package com.fuxl.tdd.oobootcamp.parkinglot;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SmartParkingBoyTest {
	
	@Test
	public void should_park_car_to_parkinglot2_when_parkinglot2_has_more_parkingspace() {
		//given
		ParkingLot oneSpaceParkinglot = new ParkingLot(1);
		ParkingLot twoSpaceParkingLot = new ParkingLot(2);
		
		ParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(oneSpaceParkinglot, twoSpaceParkingLot));

		//when
		Car parkCar = new Car("abc001");
		String token = smartParkingBoy.parkCar(parkCar);

		//then
		Car pickupCar = twoSpaceParkingLot.pickupCar(token);
		assertEquals(parkCar.getCarNo(), pickupCar.getCarNo());
	}
	
	@Test
	public void should_park_car_to_parkinglot1_when_two_parkinglots_has_same_parkingspace() {
		//given
		ParkingLot oneSpaceParkinglot = new ParkingLot(1);
		ParkingLot twoSpaceParkingLot = new ParkingLot(2);
		
		ParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(oneSpaceParkinglot, twoSpaceParkingLot));

		//when
		Car parkCar = new Car("abc001");
		String token = smartParkingBoy.parkCar(parkCar);

		//then
		Car pickupCar = twoSpaceParkingLot.pickupCar(token);
		assertEquals(parkCar.getCarNo(), pickupCar.getCarNo());
	}

}
