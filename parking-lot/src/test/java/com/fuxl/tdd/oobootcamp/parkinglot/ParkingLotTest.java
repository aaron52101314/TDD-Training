package com.fuxl.tdd.oobootcamp.parkinglot;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.fuxl.tdd.oobootcamp.parkinglot.NoAvailableParkingspaceException;
import com.fuxl.tdd.oobootcamp.parkinglot.NoThisCarException;
import com.fuxl.tdd.oobootcamp.parkinglot.ParkingLot;

public class ParkingLotTest {

	private ParkingLot parkingLot;
	
	@Before
	public void setUp() {
		parkingLot = new ParkingLot(2);
	}
	
	@Test
	public void should_get_token_when_park_a_car() {
		Car car = new Car("abc001");
		//then
		assertNotNull(parkingLot.parkCar(car));
	}
	
	@Test(expected = NoAvailableParkingspaceException.class)
	public void should_throw_exception_when_no_available_space() {
		Car car1 = new Car("abc001");
		Car car2 = new Car("abc002");
		Car car3 = new Car("abc003");
		
		parkingLot.parkCar(car1);
		parkingLot.parkCar(car2);
		parkingLot.parkCar(car3);
	}

	@Test(expected = NoThisCarException.class)
	public void should_throw_exception_when_pickup_car_from_a_empty_parkinglot() {
		parkingLot.pickupCar("abc001");
	}
	
	@Test
	public void should_have_one_car_when_pickup_a_car_form_parkinglot(){
		Car car1 = new Car("abc001");
		Car car2 = new Car("abc002");
		
		parkingLot.parkCar(car1);
		parkingLot.parkCar(car2);
		
		parkingLot.pickupCar("abc001");
		
		assertEquals(1, parkingLot.showParkingSpace());
	}
	
	@Test(expected = NoThisCarException.class)
	public void should_throw_exception_when_pickup_a_not_existing_car(){
		
		parkingLot.pickupCar("abc001");
	}
	
	@Test(expected = NoThisCarException.class)
	public void should_throw_exception_when_pickup_same_car_twice(){
		Car car1 = new Car("abc001");
		parkingLot.parkCar(car1);
		
		parkingLot.pickupCar("abc001");
		parkingLot.pickupCar("abc001");
	}
	
	
	@Test
	public void should_have_2_parking_space_with_a_empty_parkinglot(){
		assertEquals(2, parkingLot.showParkingSpace());
	}
	
	@Test
	public void should_have_no_parking_space_when_park_two_car(){
		Car car1 = new Car("abc001");
		Car car2 = new Car("abc002");
		
		parkingLot.parkCar(car1);
		parkingLot.parkCar(car2);
		
		
		assertEquals(0, parkingLot.showParkingSpace());
	}
	
}
