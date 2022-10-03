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
    public List<Auditorium> getAllAuditoriums() {
        return auditoriumService.getAll();
    }

    @GetMapping("/{id}")
    public Auditorium getAuditoriumById(@PathVariable int id) {
        return auditoriumService.getById(id);
    }

    @PostMapping("/")
    public Auditorium createAuditorium(@RequestBody Auditorium auditorium) {
        return auditoriumService.save(auditorium);
    }

    @PutMapping("/")
    public Auditorium updateAuditorium(@RequestBody Auditorium auditorium) {
        return auditoriumService.save(auditorium);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAuditorium(@PathVariable int id) {
        auditoriumService.deleteById(id);

        return new ResponseEntity(HttpStatus.OK);
    }
}
