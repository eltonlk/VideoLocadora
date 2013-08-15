package framework.dao;

public class UpdateDaoException extends RuntimeException {

    public UpdateDaoException() {
    }

    public UpdateDaoException(String message) {
        super(message);
    }

    public UpdateDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateDaoException(Throwable cause) {
        super(cause);
    }

    public UpdateDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
