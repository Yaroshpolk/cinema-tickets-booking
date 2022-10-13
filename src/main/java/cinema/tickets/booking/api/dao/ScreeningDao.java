package cinema.tickets.booking.api.dao;

import cinema.tickets.booking.api.entity.Auditorium;
import cinema.tickets.booking.api.entity.Screening;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScreeningDao implements Dao<Screening> {

    private final SessionFactory sessionFactory;

    public ScreeningDao(@Autowired SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Screening> getAll() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from Screening", Screening.class).getResultList();
    }

    @Override
    public Screening getById(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Screening.class, id);
    }

    @Override
    public void save(Screening screening) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(screening);
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();

        session.createQuery("delete from Screening where id=:id").setParameter("id", id).executeUpdate();
    }

    public List<Screening> getScreeningsByAuditorium(Auditorium auditorium) {
        Session session = sessionFactory.getCurrentSession();

        return (List<Screening>) session.createQuery("from Screening where auditorium=:auditorium")
                .setParameter("auditorium", auditorium).getResultList();
    }
}