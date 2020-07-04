package processor.processorImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

import constants.EnumConstants.SlotType;
import exception.ParkException;
import model.Car;
import model.Slot;
import processor.ProcessParking;

/**
 * @author shardul
 *
 */
public class ProcessParkingImpl implements ProcessParking {

	public Integer createParking(String parameters[]) throws ParkException {
		Integer capacity = Integer.parseInt(parameters[1]);
		Integer lMVCapacity = Integer.parseInt(parameters[2]);
		Integer hMVcapacity = Integer.parseInt(parameters[3]);
		Integer tWcapacity = Integer.parseInt(parameters[4]);

		if (capacity.compareTo(lMVCapacity + hMVcapacity + tWcapacity) != 0) {
			return 0;
		}

		Map<Integer, Slot> slots = DataManagerImpl.getDataManager().getSlots();
		SortedSet<Integer> emptySlotIds = DataManagerImpl.getDataManager().getEmpltySlotIds();
		if (!slots.isEmpty()) {
			return 0;
		}
		DataManagerImpl.getDataManager().setCapacity(capacity);
		int i = 1;
		for (; i <= lMVCapacity; i++) {
			slots.put(i, createSlot(i, SlotType.LIGHT_MOTOR_VEHICLE.getSlotCode()));
			emptySlotIds.add(i);
		}
		for (; i <= hMVcapacity + lMVCapacity; i++) {
			slots.put(i, createSlot(i, SlotType.HEAVY_MOTOR_VEHICLE.getSlotCode()));
			emptySlotIds.add(i);
		}
		for (; i <= capacity; i++) {
			slots.put(i, createSlot(i, SlotType.TWO_WHEELER.getSlotCode()));
			emptySlotIds.add(i);
		}
		return capacity;
	}

	public Integer park(String registrationNo, String color, Integer slotType) throws ParkException {
		SortedSet<Integer> emptySlotIds = DataManagerImpl.getDataManager().getEmpltySlotIds();
		if (emptySlotIds.isEmpty()) {
			return 0;
		}
		Integer response = 0;
		for (Integer slotId : emptySlotIds) {
			Slot slot = DataManagerImpl.getDataManager().getSlots().get(slotId);
			if (slot.getSlotType().equals(slotType)) {
				slot.addCar(createCar(registrationNo, color));
				response = slotId;
				break;
			}
		}

		if (response != 0) {
			emptySlotIds.remove(response);
		}

		return response;
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

	private Slot createSlot(Integer slotNo, Integer slotType) throws ParkException {
		Slot slot = new Slot();
		slot.setIsOccupied(false);
		slot.setSlotNo(slotNo);
		slot.setSlotType(slotType);
		return slot;
	}

	private Car createCar(String registrationNo, String color) throws ParkException {
		return new Car(registrationNo, color);
	}

}
