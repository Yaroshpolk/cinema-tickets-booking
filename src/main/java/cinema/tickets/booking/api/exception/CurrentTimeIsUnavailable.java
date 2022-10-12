package cinema.tickets.booking.api.exception;

public class CurrentTimeIsUnavailable extends RuntimeException{

    public CurrentTimeIsUnavailable(String message) {
        super(message);
    }
}
