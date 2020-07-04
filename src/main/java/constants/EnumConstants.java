package constants;

/**
 * @author shardul
 *
 */
public class EnumConstants {

	public enum Commands {

		CREATE_SLOT("create_parking_lot"), PARK("park"), LEAVE("leave"), STATUS("status"),
		FIND_REGISTRATION_BY_COLOR("registration_numbers_for_cars_with_colour"),
		FIND_SLOT_BY_COLOR("slot_numbers_for_cars_with_colour"),
		FIND_SLOT_BY_REGISTRATION("slot_number_for_registration_number");

		private String commands;

		private Commands(String commands) {
			this.commands = commands;
		}

		public String getCommand() {
			return this.commands;
		}

	}

	public enum ErrorCodes {
		INVALID_INPUT("Please enter a valid instruction.");

		private String message;

		private ErrorCodes(String message) {
			this.message = message;
		}

		public String getMessage() {
			return this.message;
		}
	}

	public enum SlotType {
		LIGHT_MOTOR_VEHICLE(1), HEAVY_MOTOR_VEHICLE(2), TWO_WHEELER(3);

		private Integer slotCode;

		private SlotType(Integer slotCode) {
			this.slotCode = slotCode;
		}

		public Integer getSlotCode() {
			return this.slotCode;
		}

	}

}
