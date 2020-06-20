package processor;

import java.util.List;

import exception.ParkException;
import model.Slot;

/**
 * @author shardul
 *
 */
public interface ProcessParking {

	public Integer createParking(Integer capacity) throws ParkException;

	public Integer park(String registrationNo, String color) throws ParkException;

	public Integer leave(Integer slotNo) throws ParkException;

	public List<Slot> status() throws ParkException;

	public List<String> findRegistrationByColor(String color) throws ParkException;

	public List<Integer> findSlotNoByColor(String color) throws ParkException;

	public Integer findSlotByRegistrationNo(String registrationNo) throws ParkException;

	public void destroyParking() throws ParkException;

}
