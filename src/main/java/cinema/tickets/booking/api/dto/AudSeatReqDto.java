package cinema.tickets.booking.api.dto;

public class AudSeatReqDto {

    private int auditoriumId;

    private int seatLine;

    private int seatNumber;

    public AudSeatReqDto() {
    }

    public AudSeatReqDto(int auditoriumId, int seatLine, int seatNumber) {
        this.auditoriumId = auditoriumId;
        this.seatLine = seatLine;
        this.seatNumber = seatNumber;
    }

    public int getAuditoriumId() {
        return auditoriumId;
    }

    public void setAuditoriumId(int auditoriumId) {
        this.auditoriumId = auditoriumId;
    }

    public int getSeatLine() {
        return seatLine;
    }

    public void setSeatLine(int seatLine) {
        this.seatLine = seatLine;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}
