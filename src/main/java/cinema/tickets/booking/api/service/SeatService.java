package cinema.tickets.booking.api.service;

import cinema.tickets.booking.api.dao.SeatDao;
import cinema.tickets.booking.api.entity.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SeatService {

    @Autowired
    private SeatDao seatDao;

    @Transactional
    public List<Seat> getAll() {
        return seatDao.getAll();
    }

    @Transactional
    public Seat getById(int id) {
        return seatDao.getById(id);
    }

    @Transactional
    public void save(Seat seat) {
        seatDao.save(seat);
    }

    @Transactional
    public void deleteById(int id) {
        seatDao.deleteById(id);
    }

}
