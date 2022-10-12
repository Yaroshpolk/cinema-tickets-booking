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
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return new ResponseEntity<>(reservationService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable int id) {
        return new ResponseEntity<>(reservationService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationReqDto reservationDto) {
        return new ResponseEntity<>(reservationService.save(reservationDto), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Reservation> updateReservation(@RequestBody ReservationReqDto reservationDto) {
        return new ResponseEntity<>(reservationService.save(reservationDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable int id) {
        reservationService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
