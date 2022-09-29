package cinema.tickets.booking.api.service;

import cinema.tickets.booking.api.dao.UserDao;
import cinema.tickets.booking.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements ServiceInterface<User> {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void deleteById(int id) {
        userDao.deleteById(id);
    }

}
