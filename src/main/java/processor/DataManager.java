package processor;

import java.util.Map;
import java.util.SortedSet;

import model.Slot;

public interface DataManager {

	SortedSet<Integer> getEmpltySlotIds();

	Map<Integer, Slot> getSlots();

	Integer getCapacity();

}