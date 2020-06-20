package processor.processorImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import model.Slot;
import processor.DataManager;

/**
 * @author shardul
 *
 */
public class DataManagerImpl implements DataManager {

	static Logger log = Logger.getLogger(DataManagerImpl.class);

	private DataManagerImpl() {

	}

	public static DataManagerImpl getDataManager() {
		log.debug("Getting datamanager instance");
		if (dataManager == null)
			dataManager = new DataManagerImpl();
		return dataManager;
	}

	private static DataManagerImpl dataManager = null;

	private Map<Integer, Slot> slots = new HashMap<Integer, Slot>();
	private SortedSet<Integer> emptySlotIds = new TreeSet<Integer>();
	private Integer capacity = null;

	@Override
	public SortedSet<Integer> getEmpltySlotIds() {
		log.debug("Getting empty slot id set");
		return this.emptySlotIds;
	}

	@Override
	public Map<Integer, Slot> getSlots() {
		log.debug("Getting slots map");
		return this.slots;
	}

	protected Integer setCapacity(Integer capacity) {
		log.debug("setting capacity");
		this.capacity = capacity;
		return this.capacity;
	}

	@Override
	public Integer getCapacity() {
		log.debug("Getting capacity");
		return this.capacity;
	}

}
