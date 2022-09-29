package cinema.tickets.booking.api.service;

import cinema.tickets.booking.api.dao.SeatDao;
import cinema.tickets.booking.api.entity.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService implements ServiceInterface<Seat> {

    @Autowired
    private SeatDao seatDao;

    @Override
    public List<Seat> getAll() {
        return seatDao.getAll();
    }

    @Override
    public Seat getById(int id) {
        return seatDao.getById(id);
    }

    @Override
    public void save(Seat seat) {
        seatDao.save(seat);
    }

    @Override
    public void deleteById(int id) {
        seatDao.deleteById(id);
    }

}
