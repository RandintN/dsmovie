package software.robsoncassiano.learn.dsmovie.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import software.robsoncassiano.learn.dsmovie.dto.MovieDTO;
import software.robsoncassiano.learn.dsmovie.entities.Movie;
import software.robsoncassiano.learn.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAll(Pageable pageable) {
        Page<Movie> result = movieRepository.findAll(pageable);
        return result.map(MovieDTO::new);
    }

    @Transactional(readOnly = true)
    public MovieDTO findById(Long id) {
        if (movieRepository.findById(id).isPresent()) {
            Movie result = movieRepository.findById(id).get();
            return new MovieDTO(result);
        }
        else return null;
    }

}
