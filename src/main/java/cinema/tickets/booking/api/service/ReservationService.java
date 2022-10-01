package cinema.tickets.booking.api.service;

import cinema.tickets.booking.api.dao.ReservationDao;
import cinema.tickets.booking.api.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationDao reservationDao;

    @Transactional
    public List<Reservation> getAll() {
        return reservationDao.getAll();
    }

    @Transactional
    public Reservation getById(int id) {
        return reservationDao.getById(id);
    }

    @Transactional
    public void save(Reservation reservation) {
        reservationDao.save(reservation);
    }

    @Transactional
    public void deleteById(int id) {
        reservationDao.deleteById(id);
    }

}
