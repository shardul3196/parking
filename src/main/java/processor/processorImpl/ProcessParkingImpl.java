package processor.processorImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

import exception.ParkException;
import model.Car;
import model.Slot;
import processor.ProcessParking;

/**
 * @author shardul
 *
 */
public class ProcessParkingImpl implements ProcessParking {

	public Integer createParking(Integer capacity) throws ParkException {
		Map<Integer, Slot> slots = DataManagerImpl.getDataManager().getSlots();
		SortedSet<Integer> emptySlotIds = DataManagerImpl.getDataManager().getEmpltySlotIds();
		if (!slots.isEmpty()) {
			return 0;
		}
		DataManagerImpl.getDataManager().setCapacity(capacity);
		for (int i = 1; i <= capacity; i++) {
			slots.put(i, createSlot(i));
			emptySlotIds.add(i);
		}
		return capacity;
	}

	public Integer park(String registrationNo, String color) throws ParkException {
		SortedSet<Integer> emptySlotIds = DataManagerImpl.getDataManager().getEmpltySlotIds();
		if (emptySlotIds.isEmpty()) {
			return 0;
		}
		Integer slotId = emptySlotIds.first();
		emptySlotIds.remove(slotId);
		Slot slot = DataManagerImpl.getDataManager().getSlots().get(slotId);
		slot.addCar(createCar(registrationNo, color));
		return slotId;
	}

	public Integer leave(Integer slotNo) throws ParkException {
		if (slotNo > DataManagerImpl.getDataManager().getCapacity()
				|| DataManagerImpl.getDataManager().getEmpltySlotIds().contains(slotNo)) {
			return 0;
		}

		DataManagerImpl.getDataManager().getEmpltySlotIds().add(slotNo);
		Map<Integer, Slot> leaveMap = DataManagerImpl.getDataManager().getSlots();
		leaveMap.get(slotNo).addCar(null).setIsOccupied(false);
		return slotNo;
	}

	public List<Slot> status() throws ParkException {
		Map<Integer, Slot> slots = DataManagerImpl.getDataManager().getSlots();
		List<Slot> response = new ArrayList<Slot>();
		for (Integer key : slots.keySet()) {
			if (slots.get(key).isOccupied()) {
				response.add(slots.get(key));
			}
		}
		return response;

	}

	public List<String> findRegistrationByColor(String color) throws ParkException {
		Map<Integer, Slot> slots = DataManagerImpl.getDataManager().getSlots();
		List<String> response = new ArrayList<String>();
		for (Integer key : slots.keySet()) {
			if (slots.get(key).isOccupied() && slots.get(key).getCar().getColor().equalsIgnoreCase(color)) {
				response.add(slots.get(key).getCar().getRegistrationNo());
			}
		}
		return response;
	}

	public List<Integer> findSlotNoByColor(String color) throws ParkException {

		Map<Integer, Slot> slots = DataManagerImpl.getDataManager().getSlots();
		List<Integer> response = new ArrayList<Integer>();
		for (Integer key : slots.keySet()) {
			if (slots.get(key).isOccupied() && slots.get(key).getCar().getColor().equalsIgnoreCase(color)) {
				response.add(key);
			}
		}
		return response;
	}

	public Integer findSlotByRegistrationNo(String registrationNo) throws ParkException {
		Map<Integer, Slot> slots = DataManagerImpl.getDataManager().getSlots();
		Integer response = 0;
		for (Integer key : slots.keySet()) {
			if (slots.get(key).isOccupied()
					&& slots.get(key).getCar().getRegistrationNo().equalsIgnoreCase(registrationNo)) {
				response = key;
			}
		}
		return response;
	}

	public void destroyParking() throws ParkException {
		DataManagerImpl.getDataManager().setCapacity(0);
		DataManagerImpl.getDataManager().getSlots().clear();
		DataManagerImpl.getDataManager().getEmpltySlotIds().clear();
	}

	private Slot createSlot(Integer slotNo) throws ParkException {
		Slot slot = new Slot();
		slot.setIsOccupied(false);
		slot.setSlotNo(slotNo);
		return slot;
	}

	private Car createCar(String registrationNo, String color) throws ParkException {
		return new Car(registrationNo, color);
	}

}
