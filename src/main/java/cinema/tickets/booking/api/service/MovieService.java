package cinema.tickets.booking.api.service;

import cinema.tickets.booking.api.dao.MovieDao;
import cinema.tickets.booking.api.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements ServiceInterface<Movie> {

    @Autowired
    private MovieDao movieDao;

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }

    @Override
    public Movie getById(int id) {
        return movieDao.getById(id);
    }

    @Override
    public void save(Movie movie) {
        movieDao.save(movie);
    }

    @Override
    public void deleteById(int id) {
        movieDao.deleteById(id);
    }

}
