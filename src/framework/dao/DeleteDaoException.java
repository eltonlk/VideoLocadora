package framework.dao;

public class DeleteDaoException extends RuntimeException {

    public DeleteDaoException() {
    }

    public DeleteDaoException(String message) {
        super(message);
    }

    public DeleteDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteDaoException(Throwable cause) {
        super(cause);
    }

    public DeleteDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
