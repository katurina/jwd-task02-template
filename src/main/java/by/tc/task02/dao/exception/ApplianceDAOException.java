package by.tc.task02.dao.exception;

import java.io.IOException;

public class ApplianceDAOException extends IOException {
	public ApplianceDAOException() {
		super();
	}

	public ApplianceDAOException(String message) {
		super(message);
	}

	public ApplianceDAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplianceDAOException(Throwable cause) {
		super(cause);
	}
}
