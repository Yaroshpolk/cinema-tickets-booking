package cinema.tickets.booking.api.service;

import cinema.tickets.booking.api.dao.AuditoriumDao;
import cinema.tickets.booking.api.entity.Auditorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditoriumService implements ServiceInterface<Auditorium> {

    @Autowired
    private AuditoriumDao auditoriumDao;


    @Override
    public List<Auditorium> getAll() {
        return auditoriumDao.getAll();
    }

    @Override
    public Auditorium getById(int id) {
        return auditoriumDao.getById(id);
    }

    @Override
    public void save(Auditorium auditorium) {
        auditoriumDao.save(auditorium);
    }

    @Override
    public void deleteById(int id) {
        auditoriumDao.deleteById(id);
    }

}
