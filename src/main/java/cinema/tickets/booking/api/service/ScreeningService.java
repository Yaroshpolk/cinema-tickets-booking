package cinema.tickets.booking.api.service;

import cinema.tickets.booking.api.dao.ScreeningDao;
import cinema.tickets.booking.api.dto.ScreeningReqDto;
import cinema.tickets.booking.api.entity.Auditorium;
import cinema.tickets.booking.api.entity.Movie;
import cinema.tickets.booking.api.entity.Screening;
import cinema.tickets.booking.api.exception.CurrentTimeIsUnavailable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Service
public class ScreeningService {

    private final ScreeningDao screeningDao;

    private final MovieService movieService;

    private final AuditoriumService auditoriumService;

    public ScreeningService(@Autowired ScreeningDao screeningDao,
                            @Autowired MovieService movieService,
                            @Autowired AuditoriumService auditoriumService) {
        this.screeningDao = screeningDao;
        this.movieService = movieService;
        this.auditoriumService = auditoriumService;
    }

    @Transactional
    public List<Screening> getAll() {
        return screeningDao.getAll();
    }

    @Transactional
    public Screening getById(int id) {
        return screeningDao.getById(id);
    }

    @Transactional
    public Screening save(ScreeningReqDto screeningDto) {
        Movie movie = movieService.getById(screeningDto.getMovieId());
        Auditorium auditorium = auditoriumService.getById(screeningDto.getAuditoriumId());
        Timestamp endTime = Timestamp.from(screeningDto.getStartTime().toInstant()
                .plusSeconds(movie.getDurationMin() * 60L));

        Screening screening = new Screening(movie, auditorium, screeningDto.getStartTime(), endTime);

        if (checkForTimeAvailability(screening)) {
            screeningDao.save(screening);
        } else {
            throw new CurrentTimeIsUnavailable(
                    String.format("Current time is unavailable for auditory with id:%d", screeningDto.getAuditoriumId()));
        }

        return screening;
    }

    @Transactional
    public void deleteById(int id) {
        screeningDao.deleteById(id);
    }

    @Transactional
    public boolean checkForTimeAvailability(Screening screening) {
        List<Screening> screenings = screeningDao.getScreeningsByAuditorium(screening.getAuditorium());

        long count = screenings.stream()
                .filter(i -> !(screening.getEndTime().toInstant().isBefore(i.getStartTime().toInstant())
                        || i.getEndTime().toInstant().isBefore(screening.getStartTime().toInstant()))
                )
                .count();

        return count < 1;
    }

}
