package cinema.tickets.booking.api.controller;

import cinema.tickets.booking.api.entity.Auditorium;
import cinema.tickets.booking.api.service.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auditoriums")
public class AuditoriumController {

    @Autowired
    private AuditoriumService auditoriumService;

    @GetMapping("/")
    public ResponseEntity<List<Auditorium>> getAllAuditoriums() {
        return new ResponseEntity<>(auditoriumService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Auditorium> getAuditoriumById(@PathVariable int id) {
        return new ResponseEntity<>(auditoriumService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Auditorium> createAuditorium(@RequestBody Auditorium auditorium) {
        return new ResponseEntity<>(auditoriumService.save(auditorium), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Auditorium> updateAuditorium(@RequestBody Auditorium auditorium) {
        return new ResponseEntity<>(auditoriumService.save(auditorium), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuditorium(@PathVariable int id) {
        auditoriumService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
