package cinema.tickets.booking.api.service;

import cinema.tickets.booking.api.dao.SeatDao;
import cinema.tickets.booking.api.dto.AudSeatReqDto;
import cinema.tickets.booking.api.entity.Auditorium;
import cinema.tickets.booking.api.entity.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SeatService {

    @Autowired
    private SeatDao seatDao;

    @Autowired
    private AuditoriumService auditoriumService;

    @Transactional
    public List<Seat> getAll() {
        return seatDao.getAll();
    }

    @Transactional
    public Seat getById(int id) {
        return seatDao.getById(id);
    }

    @Transactional
    public Seat save(Seat seat) {
        seatDao.save(seat);

        return seat;
    }

    @Transactional
    public void deleteById(int id) {
        seatDao.deleteById(id);
    }

    @Transactional
    public Seat addSeat(AudSeatReqDto reqDto) {
        Auditorium auditorium = auditoriumService.getById(reqDto.getAuditoriumId());
        Seat seat = new Seat(reqDto.getSeatNumber(), reqDto.getSeatLine(), auditorium);
        save(seat);

        return seat;
    }

}
