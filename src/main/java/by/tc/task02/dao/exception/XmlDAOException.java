package by.tc.task02.dao.exception;

public class XmlDAOException extends Exception {
    public XmlDAOException() {
        super();
    }

    public XmlDAOException(String message) {
        super(message);
    }

    public XmlDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public XmlDAOException(Throwable cause) {
        super(cause);
    }
}
