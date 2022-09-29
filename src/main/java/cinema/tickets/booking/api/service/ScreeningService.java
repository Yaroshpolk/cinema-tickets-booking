package cinema.tickets.booking.api.service;

import cinema.tickets.booking.api.dao.ScreeningDao;
import cinema.tickets.booking.api.dao.SeatDao;
import cinema.tickets.booking.api.entity.Screening;
import cinema.tickets.booking.api.entity.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreeningService implements ServiceInterface<Screening> {

    @Autowired
    private ScreeningDao screeningDao;

    @Override
    public List<Screening> getAll() {
        return screeningDao.getAll();
    }

    @Override
    public Screening getById(int id) {
        return screeningDao.getById(id);
    }

    @Override
    public void save(Screening screening) {
        screeningDao.save(screening);
    }

    @Override
    public void deleteById(int id) {
        screeningDao.deleteById(id);
    }

}
