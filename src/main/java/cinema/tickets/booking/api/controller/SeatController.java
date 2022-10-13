package cinema.tickets.booking.api.controller;

import cinema.tickets.booking.api.dto.AudSeatReqDto;
import cinema.tickets.booking.api.entity.Seat;
import cinema.tickets.booking.api.exception.ResourceNotFoundException;
import cinema.tickets.booking.api.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController {

    private final SeatService seatService;

    public SeatController(@Autowired SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Seat>> getAllSeats() {
        return new ResponseEntity<>(seatService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seat> getSeatById(@PathVariable int id) {
        Seat res = seatService.getById(id);

        if (res != null) {
            return new ResponseEntity<>(seatService.getById(id), HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException(String.format("Seat with id:%d not found", id));
        }
    }

    @PostMapping("/")
    public ResponseEntity<Seat> addSeatToAuditorium(@RequestBody AudSeatReqDto reqDto) {
        return new ResponseEntity<>(seatService.addSeat(reqDto), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Seat> updateSeat(@RequestBody Seat seat) {
        if (seatService.getById(seat.getId()) != null) {
            return new ResponseEntity<>(seatService.save(seat), HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException(String.format("Seat with id:%d not found", seat.getId()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSeat(@PathVariable int id) {
        Seat res = seatService.getById(id);

        if (res != null) {
            seatService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            throw new ResourceNotFoundException(String.format("Seat with id:%d not found", id));
        }
    }
}
