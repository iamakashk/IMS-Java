package com.ims.helper;

import org.springframework.boot.ExitCodeGenerator;

/**
 * This class is used to shut down the current running service.
 * @author BSABH03
 *
 */
public class ServiceStop	extends RuntimeException implements ExitCodeGenerator {
		public ServiceStop() {
			super();
		}

		public int getExitCode() {
			return 13;
		}
		
}
