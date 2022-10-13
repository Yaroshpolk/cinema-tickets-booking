package cinema.tickets.booking.api.service;

import cinema.tickets.booking.api.dao.UserDao;
import cinema.tickets.booking.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;

    public UserService(@Autowired UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Transactional
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Transactional
    public User save(User user) {
        userDao.save(user);

        return user;
    }

    @Transactional
    public void deleteById(int id) {
        userDao.deleteById(id);
    }

}
