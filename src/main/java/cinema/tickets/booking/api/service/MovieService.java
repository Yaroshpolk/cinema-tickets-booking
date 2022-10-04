package cinema.tickets.booking.api.service;

import cinema.tickets.booking.api.dao.MovieDao;
import cinema.tickets.booking.api.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieDao movieDao;

    @Transactional
    public List<Movie> getAll() {
        return movieDao.getAll();
    }

    @Transactional
    public Movie getById(int id) {
        return movieDao.getById(id);
    }

    @Transactional
    public Movie save(Movie movie) {
        movieDao.save(movie);

        return movie;
    }

    @Transactional
    public void deleteById(int id) {
        movieDao.deleteById(id);
    }

}
