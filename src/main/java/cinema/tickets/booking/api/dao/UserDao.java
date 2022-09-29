package cinema.tickets.booking.api.dao;

import cinema.tickets.booking.api.entity.Movie;
import cinema.tickets.booking.api.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao implements Dao<User>{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getById(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(User.class, id);
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(user);
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();

        session.createQuery("delete from User where id=:id").setParameter("id",id).executeUpdate();
    }
}
