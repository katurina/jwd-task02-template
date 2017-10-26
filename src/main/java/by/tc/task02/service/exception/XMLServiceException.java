package by.tc.task02.service.exception;

public class XMLServiceException extends Exception {
    public XMLServiceException() {
    }

    public XMLServiceException(String message) {
        super(message);
    }

    public XMLServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public XMLServiceException(Throwable cause) {
        super(cause);
    }
}
