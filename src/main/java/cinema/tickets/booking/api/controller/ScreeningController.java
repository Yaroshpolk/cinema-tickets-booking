package cinema.tickets.booking.api.controller;

import cinema.tickets.booking.api.dto.ScreeningReqDto;
import cinema.tickets.booking.api.entity.Screening;
import cinema.tickets.booking.api.exception.ResourceNotFoundException;
import cinema.tickets.booking.api.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/screenings")
public class ScreeningController {

    @Autowired
    ScreeningService screeningService;

    @GetMapping("/")
    public ResponseEntity<List<Screening>> getAllScreenings() {
        return new ResponseEntity<>(screeningService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Screening> getScreeningById(@PathVariable int id) {
        Screening res = screeningService.getById(id);

        if (res != null) {
            return new ResponseEntity<>(screeningService.getById(id), HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException(String.format("Screening with id:%d not found", id));
        }
    }

    @PostMapping("/")
    public ResponseEntity<Screening> createScreening(@RequestBody ScreeningReqDto screeningDto) {
        return new ResponseEntity<>(screeningService.save(screeningDto), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Screening> updateScreening(@RequestBody ScreeningReqDto screeningReqDto) {
        return new ResponseEntity<>(screeningService.save(screeningReqDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteScreening(@PathVariable int id) {
        Screening res = screeningService.getById(id);

        if (res != null) {
            screeningService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            throw new ResourceNotFoundException(String.format("Screening with id:%d not found", id));
        }
    }

}
