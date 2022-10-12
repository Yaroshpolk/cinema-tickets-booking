package cinema.tickets.booking.api.controller;

import cinema.tickets.booking.api.dto.AudSeatReqDto;
import cinema.tickets.booking.api.entity.Seat;
import cinema.tickets.booking.api.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping("/")
    public ResponseEntity<List<Seat>> getAllSeats() {
        return new ResponseEntity<>(seatService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seat> getSeatById(@PathVariable int id) {
        return new ResponseEntity<>(seatService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Seat> addSeatToAuditorium(@RequestBody AudSeatReqDto reqDto) {
        return new ResponseEntity<>(seatService.addSeat(reqDto), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Seat> updateSeat(@RequestBody Seat seat) {
        return new ResponseEntity<>(seatService.save(seat), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSeat(@PathVariable int id) {
        seatService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
