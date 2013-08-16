package framework;

public class ConnectionFailureException extends RuntimeException {

    public ConnectionFailureException() {
    }

    public ConnectionFailureException(String message) {
        super(message);
    }

    public ConnectionFailureException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionFailureException(Throwable cause) {
        super(cause);
    }

    public ConnectionFailureException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
