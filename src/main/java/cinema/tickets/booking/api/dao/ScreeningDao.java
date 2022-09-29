package cinema.tickets.booking.api.dao;

import cinema.tickets.booking.api.entity.Screening;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ScreeningDao implements Dao<Screening> {

    @Autowired
    private SessionFactory sessionFactory;

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
}
