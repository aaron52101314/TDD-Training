package com.fuxl.tdd.day1.parkinglot;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {

	private ParkingLot parkingLot;
	
	@Before
	public void setUp() {
		parkingLot = new ParkingLot(2);
	}
	
	@Test
	public void should_get_token_when_park_a_car() {
		//then
		assertNotNull(parkingLot.parkCar("abc001"));
	}
	
	@Test(expected = NoAvailableParkingspaceException.class)
	public void should_throw_exception_when_no_available_space() {
		parkingLot.parkCar("abc001");
		parkingLot.parkCar("abc002");
		parkingLot.parkCar("abc003");
	}

	@Test(expected = NoThisCarException.class)
	public void should_throw_exception_when_pickup_car_from_a_empty_parkinglot() {
		parkingLot.pickupCar("abc001");
	}
	
	
	@Test
	public void should_have_one_car_when_pickup_a_car_form_parkinglot(){
		parkingLot.parkCar("abc001");
		parkingLot.parkCar("abc002");
		
		parkingLot.pickupCar("abc001");
		
		assertEquals(1, parkingLot.showParkingSpace());
	}
	
	@Test(expected = NoThisCarException.class)
	public void should_throw_exception_when_pickup_same_car_twice(){
		parkingLot.parkCar("abc001");
		
		parkingLot.pickupCar("abc001");
		parkingLot.pickupCar("abc001");
	}
	
	
	@Test
	public void should_have_2_parking_space_with_a_empty_parkinglot(){
		assertEquals(2, parkingLot.showParkingSpace());
	}
	
	@Test
	public void should_have_no_parking_space_when_park_two_car(){
		parkingLot.parkCar("abc001");
		parkingLot.parkCar("abc002");
		
		assertEquals(0, parkingLot.showParkingSpace());
	}
}
