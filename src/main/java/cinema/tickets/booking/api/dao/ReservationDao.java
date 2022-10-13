package cinema.tickets.booking.api.dao;

import cinema.tickets.booking.api.entity.Reservation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservationDao implements Dao<Reservation> {

    private final SessionFactory sessionFactory;

    public ReservationDao(@Autowired SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Reservation> getAll() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from Reservation", Reservation.class).getResultList();
    }

    @Override
    public Reservation getById(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Reservation.class, id);
    }

    @Override
    public void save(Reservation reservation) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(reservation);
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();

        session.createQuery("delete from Reservation where id=:id").setParameter("id", id).executeUpdate();
    }
}
