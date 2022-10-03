package cinema.tickets.booking.api.dto;

public class ReservationReqDto {

    private int userId;

    private int screeningId;

    private int seatId;

    public ReservationReqDto() {
    }

    public ReservationReqDto(int userId, int screeningId, int seatId) {
        this.userId = userId;
        this.screeningId = screeningId;
        this.seatId = seatId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int user_id) {
        this.userId = user_id;
    }

    public int getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(int screening_id) {
        this.screeningId = screening_id;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seat_id) {
        this.seatId = seat_id;
    }
}
