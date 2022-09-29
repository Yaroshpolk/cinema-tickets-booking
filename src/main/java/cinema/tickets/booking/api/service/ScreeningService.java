package cinema.tickets.booking.api.service;

import cinema.tickets.booking.api.dao.ScreeningDao;
import cinema.tickets.booking.api.entity.Screening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ScreeningService {

    @Autowired
    private ScreeningDao screeningDao;


    @Transactional
    public List<Screening> getAll() {
        return screeningDao.getAll();
    }


    @Transactional
    public Screening getById(int id) {
        return screeningDao.getById(id);
    }


    @Transactional
    public void save(Screening screening) {
        screeningDao.save(screening);
    }


    @Transactional
    public void deleteById(int id) {
        screeningDao.deleteById(id);
    }

}
