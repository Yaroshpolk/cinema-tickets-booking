package cinema.tickets.booking.api.dao;

import cinema.tickets.booking.api.entity.Seat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SeatDao implements Dao<Seat> {

    private final SessionFactory sessionFactory;

    public SeatDao(@Autowired SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Seat> getAll() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from Seat", Seat.class).getResultList();
    }

    @Override
    public Seat getById(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Seat.class, id);
    }

    @Override
    public void save(Seat seat) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(seat);
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();

        session.createQuery("delete from Seat where id=:id").setParameter("id", id).executeUpdate();
    }
}
