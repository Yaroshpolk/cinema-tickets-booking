package cinema.tickets.booking.api.service;

import cinema.tickets.booking.api.dao.ReservationDao;
import cinema.tickets.booking.api.dao.UserDao;
import cinema.tickets.booking.api.dto.ReservationReqDto;
import cinema.tickets.booking.api.entity.Reservation;
import cinema.tickets.booking.api.entity.Screening;
import cinema.tickets.booking.api.entity.Seat;
import cinema.tickets.booking.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationDao reservationDao;

    @Autowired
    UserService userService;

    @Autowired
    ScreeningService screeningService;

    @Autowired
    SeatService seatService;

    @Transactional
    public List<Reservation> getAll() {
        return reservationDao.getAll();
    }

    @Transactional
    public Reservation getById(int id) {
        return reservationDao.getById(id);
    }

    @Transactional
    public Reservation save(ReservationReqDto reservationDto) {
        User user = userService.getById(reservationDto.getUser_id());
        Screening screening = screeningService.getById(reservationDto.getScreening_id());
        Seat seat = seatService.getById(reservationDto.getSeat_id());

        Reservation reservation = new Reservation(user, screening, seat);
        reservationDao.save(reservation);

        return reservation;
    }

    @Transactional
    public void deleteById(int id) {
        reservationDao.deleteById(id);
    }

}
