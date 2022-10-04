package cinema.tickets.booking.api.dto;

import java.sql.Timestamp;

public class ScreeningReqDto {

    private int movieId;

    private int auditoriumId;

    private Timestamp startTime;

    public ScreeningReqDto() {
    }

    public ScreeningReqDto(int movieId, int auditoriumId, Timestamp startTime) {
        this.movieId = movieId;
        this.auditoriumId = auditoriumId;
        this.startTime = startTime;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getAuditoriumId() {
        return auditoriumId;
    }

    public void setAuditoriumId(int auditoriumId) {
        this.auditoriumId = auditoriumId;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }
}
