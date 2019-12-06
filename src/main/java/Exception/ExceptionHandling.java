package Exception;

import java.util.Date;

public class ExceptionHandling {
    private Date timestamp;
    private String message;
    private String details;

    public ExceptionHandling(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
