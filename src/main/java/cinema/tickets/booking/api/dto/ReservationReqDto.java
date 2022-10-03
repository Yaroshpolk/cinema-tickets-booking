package cinema.tickets.booking.api.dto;

public class ReservationReqDto {

    private int user_id;

    private int screening_id;

    private int seat_id;

    public ReservationReqDto() {
    }

    public ReservationReqDto(int user_id, int screening_id, int seat_id) {
        this.user_id = user_id;
        this.screening_id = screening_id;
        this.seat_id = seat_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getScreening_id() {
        return screening_id;
    }

    public void setScreening_id(int screening_id) {
        this.screening_id = screening_id;
    }

    public int getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }
}
