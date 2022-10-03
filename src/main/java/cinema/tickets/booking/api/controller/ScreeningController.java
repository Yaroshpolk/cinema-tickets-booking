package cinema.tickets.booking.api.controller;

import cinema.tickets.booking.api.dto.ScreeningReqDto;
import cinema.tickets.booking.api.entity.Auditorium;
import cinema.tickets.booking.api.entity.Movie;
import cinema.tickets.booking.api.entity.Screening;
import cinema.tickets.booking.api.service.AuditoriumService;
import cinema.tickets.booking.api.service.MovieService;
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
    public List<Screening> getAllScreenings() {
        return screeningService.getAll();
    }

    @GetMapping("/{id}")
    public Screening getScreeningById(@PathVariable int id) {
        return screeningService.getById(id);
    }

    @PostMapping("/")
    public Screening createScreening(@RequestBody ScreeningReqDto screeningDto) {
        return screeningService.save(screeningDto);
    }

    @PutMapping("/")
    public Screening updateScreening(@RequestBody ScreeningReqDto screeningReqDto) {
        return screeningService.save(screeningReqDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteScreening(@PathVariable int id) {
        screeningService.deleteById(id);

        return new ResponseEntity(HttpStatus.OK);
    }

}
