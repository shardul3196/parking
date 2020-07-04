package parking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import exception.ParkException;
import model.Car;
import model.Slot;
import processor.ProcessParking;
import processor.processorImpl.ProcessParkingImpl;

public class UnitTests {

//	@Test
//	public void createParking() throws ParkException {
//		ProcessParking processParking = new ProcessParkingImpl();
//		processParking.destroyParking();
//		Integer output = processParking.createParking(6);
//		assertTrue(output.equals(6));
//	}
//
//	@Test
//	public void alreadyExistParkingLot() throws Exception {
//		ProcessParking processParking = new ProcessParkingImpl();
//		processParking.destroyParking();
//		Integer output = processParking.createParking(6);
//		output = processParking.createParking(6);
//		assertTrue(output.equals(0));
//	}
//
//	@Test
//	public void parkCars() throws Exception {
//		ProcessParking processParking = new ProcessParkingImpl();
//		processParking.destroyParking();
//		Integer output = processParking.createParking(6);
//
//		output = processParking.park("KA-01", "White");
//		assertTrue(output.equals(1));
//
//	}
//
//	@Test
//	public void testLeave() throws Exception {
//		ProcessParking processParking = new ProcessParkingImpl();
//		processParking.destroyParking();
//		Integer output = processParking.createParking(6);
//
//		output = processParking.park("KA-01", "White");
//
//		output = processParking.leave(1);
//		assertTrue(output.equals(1));
//
//	}
//
//	@Test
//	public void testLeaveEmpty() throws Exception {
//		ProcessParking processParking = new ProcessParkingImpl();
//		processParking.destroyParking();
//		Integer output = processParking.createParking(6);
//
//		output = processParking.park("KA-01", "White");
//
//		output = processParking.leave(2);
//		assertTrue(output.equals(0));
//
//	}
//
//	@Test
//	public void testGetRegNoByColor() throws Exception {
//		ProcessParking processParking = new ProcessParkingImpl();
//		processParking.destroyParking();
//		processParking.createParking(6);
//
//		processParking.park("KA-01", "White");
//		processParking.park("KA-02", "White");
//
//		processParking.park("KA-03", "Black");
//		processParking.park("KA-04", "Red");
//		processParking.park("KA-05", "Red");
//
//		List<String> output = processParking.findRegistrationByColor("white");
//
//		assertEquals(Arrays.asList("KA-01", "KA-02"), output);
//
//	}
//
//	@Test
//	public void testGetSlotNoByColor() throws Exception {
//		ProcessParking processParking = new ProcessParkingImpl();
//		processParking.destroyParking();
//		processParking.createParking(6);
//
//		processParking.park("KA-01", "White");
//		processParking.park("KA-02", "White");
//
//		processParking.park("KA-03", "Black");
//		processParking.park("KA-04", "Red");
//		processParking.park("KA-05", "Red");
//
//		List<Integer> output = processParking.findSlotNoByColor("white");
//
//		assertEquals(Arrays.asList(1, 2), output);
//
//	}
//
//	@Test
//	public void testGetSlotNoByRegisNo() throws Exception {
//		ProcessParking processParking = new ProcessParkingImpl();
//		processParking.destroyParking();
//		processParking.createParking(6);
//
//		processParking.park("KA-01", "White");
//		processParking.park("KA-02", "White");
//
//		processParking.park("KA-03", "Black");
//		processParking.park("KA-04", "Red");
//		processParking.park("KA-05", "Red");
//
//		Integer output = processParking.findSlotByRegistrationNo("KA-01");
//
//		assertEquals(Integer.valueOf(1), output);
//
//
//	}
//
//	@Test
//	public void testStatus() throws Exception {
//		ProcessParking processParking = new ProcessParkingImpl();
//		processParking.destroyParking();
//		processParking.createParking(6);
//
//		processParking.park("KA-01", "White");
//		processParking.park("KA-02", "White");
//
//		List<Slot> output = processParking.status();
//
//		Car c1 = new Car("KA-01", "White");
//		Car c2 = new Car("KA-02", "White");
//		Slot s1 = new Slot();
//		s1.setIsOccupied(true);
//		s1.addCar(c1);
//		s1.setSlotNo(1);
//		Slot s2 = new Slot();
//		s2.setIsOccupied(true);
//		s2.addCar(c2);
//		s2.setSlotNo(2);
//
//		List<Slot> expected = new ArrayList<>();
//		expected.add(s1);
//		expected.add(s2);
//
//		assertEquals(expected, output);
//
//	}

}
