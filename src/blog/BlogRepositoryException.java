package blog;

/**
 * Created by Administrator on 9/15/2016.
 */
public class BlogRepositoryException extends RuntimeException {
    public BlogRepositoryException() {
    }

    public BlogRepositoryException(String message) {
        super(message);
    }

    public BlogRepositoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public BlogRepositoryException(Throwable cause) {
        super(cause);
    }

    public BlogRepositoryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
