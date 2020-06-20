package config;

import org.apache.log4j.Logger;

import processor.processorImpl.InputProcessorImpl;

/**
 * @author shardul
 *
 */
public class ParkingApplication {

	static Logger log = Logger.getLogger(ParkingApplication.class);

	public static void main(String[] args) {
		log.debug("App init");
		InputProcessorImpl inputManager = new InputProcessorImpl();
		inputManager.activateListner();
		log.debug("App exit");
	}

}
