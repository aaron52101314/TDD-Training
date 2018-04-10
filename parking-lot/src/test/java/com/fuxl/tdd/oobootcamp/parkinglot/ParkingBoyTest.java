package com.fuxl.tdd.oobootcamp.parkinglot;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ParkingBoyTest {
	
	private List<ParkingLot> parkingLots;
	
	@Before
	public void setUp() {
		this.parkingLots = Arrays.asList(new ParkingLot[]{
				new ParkingLot(2), new ParkingLot(2)
		});
	}
	
	@Test
	public void should_park_car_when_two_parkinglot_is_empty() {
		//given
		ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
		//when
		Car car1 = new Car("abc001");
		String token = parkingBoy.parkCar(car1);
		//then
		assertNotNull(token);
	}
	
	@Test
	public void should_park_car_to_parkinglot2_when_parkinglot1_is_full() {
		//given
		ParkingLot parkingLot1 = new ParkingLot(2);
		ParkingLot parkingLot2 = new ParkingLot(2);
		
		List<ParkingLot> oneFullParkingLots = new ArrayList<ParkingLot>();
		oneFullParkingLots.add(parkingLot1);
		oneFullParkingLots.add(parkingLot2);
		
		ParkingBoy parkingBoy = new ParkingBoy(oneFullParkingLots);
		parkingBoy.parkCar(new Car("abc001"));
		parkingBoy.parkCar(new Car("abc002"));
		
		//when
		Car parkCar = new Car("abc003");
		String token = parkingBoy.parkCar(parkCar);
		
		//then
		Car pickupCar = parkingLot2.pickupCar(token);
		assertEquals(parkCar.getCarNo(), pickupCar.getCarNo());
	}
	
	@Test
	public void should_park_car_to_parkinglot1_when_parkinglot2_have_car_and_parkinglot1_have_car_pickup() {
		//given
		ParkingLot parkingLot1 = new ParkingLot(2);
		ParkingLot parkingLot2 = new ParkingLot(2);
		
		List<ParkingLot> carParkingLots = new ArrayList<ParkingLot>();
		carParkingLots.add(parkingLot1);
		carParkingLots.add(parkingLot2);
		
		ParkingBoy parkingBoy = new ParkingBoy(carParkingLots);
		parkingBoy.parkCar(new Car("abc001"));
		parkingBoy.parkCar(new Car("abc002"));
		parkingBoy.parkCar(new Car("abc003"));
		
		//when
		parkingLot1.pickupCar("abc002");
		Car parkCar = new Car("abc004");
		parkingBoy.parkCar(parkCar);
		
		//then
		Car pickupCar = parkingLot1.pickupCar("abc004");
		assertEquals(parkCar.getCarNo(), pickupCar.getCarNo());
	}
	
	@Test(expected=NoAvailableParkingspaceException.class)
	public void should_fail_to_park_car_when_two_parkinglots_is_full() {
		//given
		ParkingLot parkingLot1 = new ParkingLot(2);
		ParkingLot parkingLot2 = new ParkingLot(2);
		
		List<ParkingLot> oneFullParkingLots = new ArrayList<ParkingLot>();
		oneFullParkingLots.add(parkingLot1);
		oneFullParkingLots.add(parkingLot2);
		
		ParkingBoy parkingBoy = new ParkingBoy(oneFullParkingLots);
		parkingBoy.parkCar(new Car("abc001"));
		parkingBoy.parkCar(new Car("abc002"));
		parkingBoy.parkCar(new Car("abc003"));
		parkingBoy.parkCar(new Car("abc004"));
		//then
		parkingBoy.parkCar(new Car("abc005"));
	}
	
	@Test
	public void should_pickup_car_form_parkinglots() {
		//given
		ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
		Car parkCar = new Car("abc001");
		String token = parkingBoy.parkCar(parkCar);
		
		//when
		Car pickupCar = parkingBoy.pickupCar(token);
		
		//then
		assertEquals(parkCar.getCarNo(), pickupCar.getCarNo());
	}

	@Test(expected=NoThisCarException.class)
	public void should_fail_to_pickup_not_existing_car_form_parkinglots() {
		//given
		ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
		parkingBoy.parkCar(new Car("abc001"));
		
		//when
		parkingBoy.pickupCar("abc002");
	}


}
