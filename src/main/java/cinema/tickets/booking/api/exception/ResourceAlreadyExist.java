package cinema.tickets.booking.api.exception;

public class ResourceAlreadyExist extends RuntimeException{

    public ResourceAlreadyExist(String message) {
        super(message);
    }
}
