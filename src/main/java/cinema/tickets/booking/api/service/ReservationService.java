package cinema.tickets.booking.api.service;

import cinema.tickets.booking.api.dao.ReservationDao;
import cinema.tickets.booking.api.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService implements ServiceInterface<Reservation> {

    @Autowired
    private ReservationDao reservationDao;

    @Override
    public List<Reservation> getAll() {
        return reservationDao.getAll();
    }

    @Override
    public Reservation getById(int id) {
        return reservationDao.getById(id);
    }

    @Override
    public void save(Reservation reservation) {
        reservationDao.save(reservation);
    }

    @Override
    public void deleteById(int id) {
        reservationDao.deleteById(id);
    }

}
