package cinema.tickets.booking.api.controller;

import cinema.tickets.booking.api.entity.Auditorium;
import cinema.tickets.booking.api.exception.ResourceAlreadyExist;
import cinema.tickets.booking.api.exception.ResourceNotFoundException;
import cinema.tickets.booking.api.service.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auditoriums")
public class AuditoriumController {

    private final AuditoriumService auditoriumService;

    public AuditoriumController(@Autowired AuditoriumService auditoriumService) {
        this.auditoriumService = auditoriumService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Auditorium>> getAllAuditoriums() {
        return new ResponseEntity<>(auditoriumService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Auditorium> getAuditoriumById(@PathVariable int id) {
        Auditorium res = auditoriumService.getById(id);

        if (res != null) {
            return new ResponseEntity<>(res, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException(String.format("Auditorium with id:%d not found", id));
        }
    }

    @PostMapping("/")
    public ResponseEntity<Auditorium> createAuditorium(@RequestBody Auditorium auditorium) {
        if (auditoriumService.getById(auditorium.getId()) == null) {
            return new ResponseEntity<>(auditoriumService.save(auditorium), HttpStatus.CREATED);
        } else {
            throw new ResourceAlreadyExist(String.format("Auditorium with id:%d already exist", auditorium.getId()));
        }
    }

    @PutMapping("/")
    public ResponseEntity<Auditorium> updateAuditorium(@RequestBody Auditorium auditorium) {
        if (auditoriumService.getById(auditorium.getId()) != null) {
            return new ResponseEntity<>(auditoriumService.save(auditorium), HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException(String.format("Auditorium with id:%d not found", auditorium.getId()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuditorium(@PathVariable int id) {
        Auditorium res = auditoriumService.getById(id);

        if (res != null) {
            auditoriumService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            throw new ResourceNotFoundException(String.format("Auditorium with id:%d not found", id));
        }
    }
}
