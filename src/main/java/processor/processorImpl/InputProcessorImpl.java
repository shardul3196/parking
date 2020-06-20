package processor.processorImpl;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import constants.CommonConstants;
import constants.EnumConstants.Commands;
import constants.EnumConstants.ErrorCodes;
import exception.ParkException;
import model.Slot;
import processor.InputProcessor;
import processor.ProcessParking;

/**
 * @author shardul
 *
 */
public class InputProcessorImpl implements InputProcessor {

	final ProcessParking processParking = new ProcessParkingImpl();

	public void activateListner() {

		String input = null;
		Scanner s = new Scanner(System.in);
		System.out.println("\n\n");
		System.out.println("====================================================");
		System.out.println("=================== PARKING LOT ====================");
		System.out.println("====================================================");
		printInstructions();
		System.out.println("Input:");
		while (true) {
			try {
				input = s.nextLine().trim();
				if (input.equalsIgnoreCase("exit")) {
					break;
				} else {
					String[] parameters = input.split(" ");
					String command = parameters[0];
					try {
						if (command.equalsIgnoreCase(Commands.CREATE_SLOT.getCommand())) {
							outputHandler(Commands.CREATE_SLOT,
									processParking.createParking(Integer.valueOf(parameters[1].trim())));
						} else if (command.equalsIgnoreCase(Commands.PARK.getCommand())) {
							outputHandler(Commands.PARK,
									processParking.park(parameters[1].trim(), parameters[2].trim()));
						} else if (command.equalsIgnoreCase(Commands.LEAVE.getCommand())) {
							outputHandler(Commands.LEAVE, processParking.leave(Integer.valueOf(parameters[1].trim())));
						} else if (command.equalsIgnoreCase(Commands.STATUS.getCommand())) {
							outputHandler(Commands.STATUS, processParking.status());
						} else if (command.equalsIgnoreCase(Commands.FIND_REGISTRATION_BY_COLOR.getCommand())) {
							outputHandler(Commands.FIND_REGISTRATION_BY_COLOR,
									processParking.findRegistrationByColor(parameters[1].trim()));
						} else if (command.equalsIgnoreCase(Commands.FIND_SLOT_BY_COLOR.getCommand())) {
							outputHandler(Commands.FIND_SLOT_BY_COLOR,
									processParking.findSlotNoByColor(parameters[1].trim()));
						} else if (command.equalsIgnoreCase(Commands.FIND_SLOT_BY_REGISTRATION.getCommand())) {
							outputHandler(Commands.FIND_SLOT_BY_REGISTRATION,
									processParking.findSlotByRegistrationNo(parameters[1].trim()));
						} else {
							throw new ParkException(ErrorCodes.INVALID_INPUT, ErrorCodes.INVALID_INPUT.getMessage(),
									new Object[0]);
						}
					} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
						throw new ParkException(ErrorCodes.INVALID_INPUT, ErrorCodes.INVALID_INPUT.getMessage(),
								e.getCause());
					}
				}

			} catch (ParkException e) {
				System.out.println(e.getErrorCode().getMessage());
			}
		}

		s.close();
	}

	private void printInstructions() {

		StringBuilder instructionCompiled = new StringBuilder();
		instructionCompiled.append("--------------Please Enter one of the below commands.-----------------------")
				.append("\n");
		instructionCompiled.append("A) For creating parking lot ---> ").append(Commands.CREATE_SLOT.getCommand())
				.append(" <capacity>").append("\n");
		instructionCompiled.append("B) To park a car ---> ").append(Commands.PARK.getCommand())
				.append(" <registration_number> <car_color>").append("\n");
		instructionCompiled.append("C) Unpark car from parking ---> ").append(Commands.LEAVE.getCommand())
				.append(" <slot_number").append("\n");
		instructionCompiled.append("D) Print status of parking slot ---> ").append(Commands.STATUS.getCommand())
				.append("\n");
		instructionCompiled.append("E) Find car registration number by car color ---> ")
				.append(Commands.FIND_REGISTRATION_BY_COLOR.getCommand()).append(" <car_color>").append("\n");
		instructionCompiled.append("F) Find slot numbers by car color ---> ")
				.append(Commands.FIND_SLOT_BY_COLOR.getCommand()).append(" <car_color>").append("\n");
		instructionCompiled.append("G) Find slot number by registration number ---> ")
				.append(Commands.FIND_SLOT_BY_REGISTRATION.getCommand()).append(" <registration_number>").append("\n");
		instructionCompiled.append("H) To exit parking system ---> exit").append("\n");
		System.out.println(instructionCompiled.toString());
	}

	private void outputHandler(Commands commands, Object response) {
		switch (commands) {
		case CREATE_SLOT:
			if (((Integer) response).equals(0)) {
				System.out.println(CommonConstants.SLOT_ALREADY_EXISTS);
			} else {
				System.out.println(String.format(CommonConstants.CREATE_SLOT_RESP, (Integer) response));
			}
			break;
		case PARK:
			if (((Integer) response).equals(0)) {
				System.out.println(CommonConstants.PARK_FULL);
			} else {
				System.out.println(String.format(CommonConstants.PARK_SUCCESS, (Integer) response));
			}
			break;
		case LEAVE:
			if (((Integer) response).equals(0)) {
				System.out.println(String.format(CommonConstants.LEAVE_EMPTY, (Integer) response));
			} else {
				System.out.println(String.format(CommonConstants.LEAVE_SUCCESS, (Integer) response));
			}
			break;
		case STATUS:
			List<Slot> resp = (List<Slot>) response;
			if (resp.isEmpty()) {
				System.out.println(CommonConstants.STATUS_PARK_EMPTY);
			} else {
				System.out.println(CommonConstants.STATUS_SUCCESS);
				for (Slot slot : resp) {
					System.out.print(slot.getSlotNo());
					System.out.println("                 ");
					System.out.print(slot.getCar().getRegistrationNo());
					System.out.println("                 ");
					System.out.println(slot.getCar().getColor());
				}
			}
			break;
		case FIND_REGISTRATION_BY_COLOR:

			if (((List<String>) response).isEmpty()) {
				System.out.println(CommonConstants.NOT_FOUND);
			} else {
				System.out.println(String.join(",", (List<String>) response));
			}
			break;
		case FIND_SLOT_BY_COLOR:
			if (((List<Integer>) response).isEmpty()) {
				System.out.println(CommonConstants.NOT_FOUND);
			} else {
				System.out.println(
						((List<Integer>) response).stream().map(String::valueOf).collect(Collectors.joining(",")));
			}
			break;
		case FIND_SLOT_BY_REGISTRATION:
			if (((Integer) response).equals(0)) {
				System.out.println(CommonConstants.NOT_FOUND);
			} else {
				System.out.println((Integer) response);
			}
			break;
		}
	}

}
