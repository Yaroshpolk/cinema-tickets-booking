package cinema.tickets.booking.api.dao;

import cinema.tickets.booking.api.entity.Auditorium;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuditoriumDao implements Dao<Auditorium> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Auditorium> getAll() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from Auditorium", Auditorium.class).getResultList();
    }

    @Override
    public Auditorium getById(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Auditorium.class, id);
    }

    @Override
    public void save(Auditorium auditorium) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(auditorium);
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();

        session.createQuery("delete from Auditorium where id=:id").setParameter("id", id).executeUpdate();
    }
}
