package software.robsoncassiano.learn.dsmovie.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import software.robsoncassiano.learn.dsmovie.dto.MovieDTO;
import software.robsoncassiano.learn.dsmovie.services.MovieService;

@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(path = "/movies")
    public Page<MovieDTO> findAllMovies(Pageable pageable) {
        return movieService.findAll(pageable);
    }

    @GetMapping(path = "/movies/{id}")
    public MovieDTO findById(@PathVariable Long id) {
        return movieService.findById(id);
    }
}
