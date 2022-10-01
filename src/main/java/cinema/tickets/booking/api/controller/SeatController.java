package cinema.tickets.booking.api.controller;

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
    public List<Seat> getAllSeats() {
        return seatService.getAll();
    }

    @GetMapping("/{id}")
    public Seat getSeatById(@PathVariable int id) {
        return seatService.getById(id);
    }

    @PutMapping("/")
    public Seat updateSeat(@RequestBody Seat seat) {
        seatService.save(seat);

        return seat;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSeat(@PathVariable int id) {
        seatService.deleteById(id);

        return new ResponseEntity(HttpStatus.OK);
    }
}
