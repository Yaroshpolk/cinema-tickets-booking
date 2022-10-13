package cinema.tickets.booking.api.controller;

import cinema.tickets.booking.api.entity.Movie;
import cinema.tickets.booking.api.exception.ResourceAlreadyExist;
import cinema.tickets.booking.api.exception.ResourceNotFoundException;
import cinema.tickets.booking.api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(@Autowired MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<>(movieService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id) {
        Movie res = movieService.getById(id);

        if (res != null) {
            return new ResponseEntity<>(res, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException(String.format("Movie with id:%d not found", id));
        }
    }

    @PostMapping("/")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        if (movieService.getById(movie.getId()) == null) {
            return new ResponseEntity<>(movieService.save(movie), HttpStatus.CREATED);
        } else {
            throw new ResourceAlreadyExist(String.format("Movie with id:%d already exist", movie.getId()));
        }
    }

    @PutMapping("/")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie) {
        if (movieService.getById(movie.getId()) != null) {
            return new ResponseEntity<>(movieService.save(movie), HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException(String.format("Movie with id:%d not found", movie.getId()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovieById(@PathVariable int id) {
        Movie res = movieService.getById(id);

        if (res != null) {
            movieService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            throw new ResourceNotFoundException(String.format("Movie with id:%d not found", id));
        }
    }

}
