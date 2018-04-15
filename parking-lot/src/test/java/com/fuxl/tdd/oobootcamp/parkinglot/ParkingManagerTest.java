package com.fuxl.tdd.oobootcamp.parkinglot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingManagerTest {

	@Test
	public void should_success_when_parking_car_to_parkinglot_which_has_parking_space() {
		ParkingLot parkingLot = new ParkingLot(1);
		ParkingManager manager = new ParkingManager(Arrays.asList(parkingLot), emptyList(ParkingBoy.class));
		
		String token = manager.parkCar(new Car("abc001"));
		
		assertNotNull(token);
		
	}
	
	@Test(expected=NoAvailableParkingspaceException.class)
	public void should_failed_to_parking_car_when_parkinglot_is_full() {
		ParkingLot parkingLot = new ParkingLot(1);
		parkingLot.parkCar(new Car("abc001"));
		ParkingManager manager = new ParkingManager(Arrays.asList(parkingLot), emptyList(ParkingBoy.class));
		
		String token = manager.parkCar(new Car("abc002"));
		
		assertNotNull(token);
	}
	
	@Test
	public void should_success_parking_car_to_parkinglots_for_both_parkinglots_has_parking_space() {
		ParkingLot parkingLot1 = new ParkingLot(1);
		ParkingLot parkingLot2 = new ParkingLot(1);
		
		ParkingManager manager = new ParkingManager(Arrays.asList(parkingLot1, parkingLot2), emptyList(ParkingBoy.class));
		
		String token = manager.parkCar(new Car("abc001"));
		
		assertNotNull(token);
	}
	
	@Test
	public void should_success_parking_car_to_parkinglots_for_one_of_them_has_parking_space() {
		ParkingLot parkingLot1 = new ParkingLot(1);
		ParkingLot parkingLot2 = new ParkingLot(1);
		parkingLot1.parkCar(new Car("abc001"));
		ParkingManager manager = new ParkingManager(Arrays.asList(parkingLot1, parkingLot2), emptyList(ParkingBoy.class));
		
		String token = manager.parkCar(new Car("abc002"));
		
		assertNotNull(token);
	}
	
	@Test(expected=NoAvailableParkingspaceException.class)
	public void should_failed_when_parking_car_to_parkinglots_for_both_parkinglots_full() {
		ParkingLot parkingLot1 = new ParkingLot(1);
		ParkingLot parkingLot2 = new ParkingLot(1);
		parkingLot1.parkCar(new Car("abc001"));
		parkingLot1.parkCar(new Car("abc002"));
		ParkingManager manager = new ParkingManager(Arrays.asList(parkingLot1, parkingLot2), emptyList(ParkingBoy.class));
		
		manager.parkCar(new Car("abc003"));
	}
	
	@Test
	public void should_success_to_park_car_when_manage_ParkingBoy_who_has_parkinglot() {
		ParkingLot parkingLot = new ParkingLot(1);
		ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot));
		
		ParkingManager manager = new ParkingManager(emptyList(ParkingLot.class), Arrays.asList(parkingBoy));
		
		manager.parkCar(new Car("abc001"));
	}
	@Test
	public void should_success_to_park_car_when_manage_SmartParkingBoy_who_has_parkinglot() {
		ParkingLot parkingLot = new ParkingLot(1);
		ParkingBoy parkingBoy = new SmartParkingBoy(Arrays.asList(parkingLot));
		
		ParkingManager manager = new ParkingManager(emptyList(ParkingLot.class), Arrays.asList(parkingBoy));
		
		manager.parkCar(new Car("abc001"));
	}
	@Test
	public void should_success_to_park_car_when_manage_SuperParkingBoy_who_has_parkinglot() {
		ParkingLot parkingLot = new ParkingLot(1);
		ParkingBoy parkingBoy = new SuperParkingBoy(Arrays.asList(parkingLot));
		
		ParkingManager manager = new ParkingManager(emptyList(ParkingLot.class), Arrays.asList(parkingBoy));
		
		manager.parkCar(new Car("abc001"));
	}
	@Test
	public void should_success_to_park_car_when_manage_ParkingBoy_and_SmartParkingBoy_both_has_parkinglot() {
		ParkingLot parkingLot1 = new ParkingLot(1);
		ParkingLot parkingLot2 = new ParkingLot(1);
		ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot1));
		ParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(parkingLot2));
		
		ParkingManager manager = new ParkingManager(emptyList(ParkingLot.class), Arrays.asList(parkingBoy, smartParkingBoy));
		
		manager.parkCar(new Car("abc001"));
	}
	
	@Test
	public void should_success_to_park_car_when_manage_ParkingBoy_and_SmartParkingBoy_both_has_parkinglot_but_smart_is_full() {
		ParkingLot parkingLot1 = new ParkingLot(1);
		ParkingLot parkingLot2 = new ParkingLot(1);
		parkingLot2.parkCar(new Car("abc001"));
		ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot1));
		ParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(parkingLot2));
		
		ParkingManager manager = new ParkingManager(emptyList(ParkingLot.class), Arrays.asList(parkingBoy, smartParkingBoy));
		
		manager.parkCar(new Car("abc002"));
	}

	@Test(expected=NoAvailableParkingspaceException.class)
	public void should_failed_to_park_car_when_manage_ParkingBoy_and_his_parkinglot_full() {
		ParkingLot parkingLot1 = new ParkingLot(1);
		parkingLot1.parkCar(new Car("abc001"));
		ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot1));
		
		ParkingManager manager = new ParkingManager(emptyList(ParkingLot.class), Arrays.asList(parkingBoy));
		
		manager.parkCar(new Car("abc002"));
	}
	
	@Test(expected=NoAvailableParkingspaceException.class)
	public void should_failed_to_park_car_when_manage_ParkingBoy_and_SmartParkingBoy_both_parkinglot_full(){
		ParkingLot parkingLot1 = new ParkingLot(1);
		ParkingLot parkingLot2 = new ParkingLot(1);
		parkingLot2.parkCar(new Car("abc001"));
		parkingLot2.parkCar(new Car("abc002"));
		ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot1));
		ParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(parkingLot2));
		
		ParkingManager manager = new ParkingManager(emptyList(ParkingLot.class), Arrays.asList(parkingBoy, smartParkingBoy));
		
		manager.parkCar(new Car("abc003"));
	}
	
	@Test
	public void should_success_to_park_car_when_parkinglot_has_parking_space_and_manage_ParkingBoy_has_parking_space() {
		ParkingLot parkingLot1 = new ParkingLot(1);
		ParkingLot parkingLot2 = new ParkingLot(1);
		ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot1));
		ParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(parkingLot2));
		
		ParkingManager manager = new ParkingManager(emptyList(ParkingLot.class), Arrays.asList(parkingBoy, smartParkingBoy));
		
		manager.parkCar(new Car("abc001"));
	}

	
	public static <T> List<T> emptyList(Class<T> classes){
		return new ArrayList<T>();
	}
	
	
}


