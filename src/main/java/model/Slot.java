package model;

/**
 * @author shardul
 *
 */
public class Slot {

	private Integer slotNo;

	private Car car;

	private Boolean isOccupied;

	private Integer slotType;

	public Slot addCar(Car car) {
		this.car = car;
		this.isOccupied = true;
		return this;
	}

	public Slot removeCar() {
		this.car = null;
		this.isOccupied = false;
		return this;
	}

	public Car getCar() {
		return this.car;
	}

	public Boolean isOccupied() {
		return this.isOccupied;
	}

	public Slot setIsOccupied(Boolean value) {
		this.isOccupied = value;
		return this;
	}

	public Integer getSlotNo() {
		return this.slotNo;
	}

	public Slot setSlotNo(Integer slotNo) {
		this.slotNo = slotNo;
		return this;
	}

	public Slot setSlotType(Integer slotType) {
		this.slotType = slotType;
		return this;
	}

	public Integer getSlotType() {
		return this.slotType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((car == null) ? 0 : car.hashCode());
		result = prime * result + ((isOccupied == null) ? 0 : isOccupied.hashCode());
		result = prime * result + ((slotNo == null) ? 0 : slotNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Slot other = (Slot) obj;
		if (car == null) {
			if (other.car != null)
				return false;
		} else if (!car.equals(other.car))
			return false;
		if (isOccupied == null) {
			if (other.isOccupied != null)
				return false;
		} else if (!isOccupied.equals(other.isOccupied))
			return false;
		if (slotNo == null) {
			if (other.slotNo != null)
				return false;
		} else if (!slotNo.equals(other.slotNo))
			return false;
		return true;
	}

}
