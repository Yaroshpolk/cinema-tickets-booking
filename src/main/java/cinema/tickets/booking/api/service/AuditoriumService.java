package cinema.tickets.booking.api.service;

import cinema.tickets.booking.api.dao.AuditoriumDao;
import cinema.tickets.booking.api.entity.Auditorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AuditoriumService {

    private final AuditoriumDao auditoriumDao;

    public AuditoriumService(@Autowired AuditoriumDao auditoriumDao) {
        this.auditoriumDao = auditoriumDao;
    }

    @Transactional
    public List<Auditorium> getAll() {
        return auditoriumDao.getAll();
    }

    @Transactional
    public Auditorium getById(int id) {
        return auditoriumDao.getById(id);
    }

    @Transactional
    public Auditorium save(Auditorium auditorium) {
        auditoriumDao.save(auditorium);

        return auditorium;
    }

    @Transactional
    public void deleteById(int id) {
        auditoriumDao.deleteById(id);
    }

}
