package cinema.tickets.booking.api.dto;

public class ScreeningReqDto {

    private int movieId;

    private int auditoriumId;

    private int startTime;

    public ScreeningReqDto() {
    }

    public ScreeningReqDto(int movieId, int auditoriumId, int startTime) {
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

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }
}
