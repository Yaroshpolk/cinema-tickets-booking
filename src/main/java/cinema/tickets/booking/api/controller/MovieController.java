package cinema.tickets.booking.api.controller;

import cinema.tickets.booking.api.entity.Movie;
import cinema.tickets.booking.api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/")
    public List<Movie> getAllMovies() {
       return movieService.getAll();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable int id) {
        return movieService.getById(id);
    }

    @PostMapping("/")
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.save(movie);
    }

    @PutMapping("/")
    public Movie updateMovie(@RequestBody Movie movie) {
        return movieService.save(movie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMovieById(@PathVariable int id) {
        movieService.deleteById(id);

        return new ResponseEntity(HttpStatus.OK);
    }

}
