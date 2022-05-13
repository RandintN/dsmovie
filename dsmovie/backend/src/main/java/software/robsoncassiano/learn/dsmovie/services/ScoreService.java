package software.robsoncassiano.learn.dsmovie.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import software.robsoncassiano.learn.dsmovie.dto.MovieDTO;
import software.robsoncassiano.learn.dsmovie.dto.ScoreDTO;
import software.robsoncassiano.learn.dsmovie.entities.Movie;
import software.robsoncassiano.learn.dsmovie.entities.Score;
import software.robsoncassiano.learn.dsmovie.entities.User;
import software.robsoncassiano.learn.dsmovie.repositories.MovieRepository;
import software.robsoncassiano.learn.dsmovie.repositories.ScoreRepository;
import software.robsoncassiano.learn.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {

    private final MovieRepository movieRepository;
    private final ScoreRepository scoreRepository;
    private final UserRepository userRepository;


    public ScoreService(MovieRepository movieRepository, ScoreRepository scoreRepository, UserRepository userRepository) {
        this.movieRepository = movieRepository;
        this.scoreRepository = scoreRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public MovieDTO saveScore(ScoreDTO scoreDTO) {
        User user = userRepository.findByEmail(scoreDTO.getEmail());
        if (user == null) {
            user = new User();
            user.setEmail(scoreDTO.getEmail());
            user = userRepository.saveAndFlush(user);
        }
        Movie movie = movieRepository.findById(scoreDTO.getMovieId()).get();

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(scoreDTO.getScore());

        score = scoreRepository.saveAndFlush(score);

        double sum = 0.0;
        for (Score eachScore : movie.getScores()) {
            sum = eachScore.getValue();
        }

        double avg = sum / movie.getScores().size();
        movie.setScore(avg);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.save(movie);

        return new MovieDTO(movie);
    }
}
