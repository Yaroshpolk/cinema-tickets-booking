package cinema.tickets.booking.api.controller;


import cinema.tickets.booking.api.dto.ReservationReqDto;
import cinema.tickets.booking.api.entity.Reservation;
import cinema.tickets.booking.api.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping("/")
    public List<Reservation> getAllReservations() {
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable int id) {
        return reservationService.getById(id);
    }

    @PostMapping("/")
    public Reservation createReservation(@RequestBody ReservationReqDto reservationDto) {
        return reservationService.save(reservationDto);
    }

    @PutMapping("/")
    public Reservation updateReservation(@RequestBody ReservationReqDto reservationDto) {
        return reservationService.save(reservationDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteReservation(@PathVariable int id) {
        reservationService.deleteById(id);

        return new ResponseEntity(HttpStatus.OK);
    }
}
