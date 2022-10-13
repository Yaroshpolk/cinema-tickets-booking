package cinema.tickets.booking.api.dao;

import cinema.tickets.booking.api.entity.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieDao implements Dao<Movie> {

    private final SessionFactory sessionFactory;

    public MovieDao(@Autowired SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Movie> getAll() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from Movie", Movie.class).getResultList();
    }

    @Override
    public Movie getById(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Movie.class, id);
    }

    @Override
    public void save(Movie movie) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(movie);
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();

        session.createQuery("delete from Movie where id=:id").setParameter("id", id).executeUpdate();
    }
}
