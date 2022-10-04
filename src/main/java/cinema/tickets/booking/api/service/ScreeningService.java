package cinema.tickets.booking.api.service;

import cinema.tickets.booking.api.dao.ScreeningDao;
import cinema.tickets.booking.api.dto.ScreeningReqDto;
import cinema.tickets.booking.api.entity.Auditorium;
import cinema.tickets.booking.api.entity.Movie;
import cinema.tickets.booking.api.entity.Screening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Service
public class ScreeningService {

    @Autowired
    private ScreeningDao screeningDao;

    @Autowired
    private MovieService movieService;

    @Autowired AuditoriumService auditoriumService;

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
        screeningDao.save(screening);

        return screening;
    }

    @Transactional
    public void deleteById(int id) {
        screeningDao.deleteById(id);
    }

}
