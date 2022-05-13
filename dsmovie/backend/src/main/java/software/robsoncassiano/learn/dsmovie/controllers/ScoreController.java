package software.robsoncassiano.learn.dsmovie.controllers;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.robsoncassiano.learn.dsmovie.dto.MovieDTO;
import software.robsoncassiano.learn.dsmovie.dto.ScoreDTO;
import software.robsoncassiano.learn.dsmovie.services.ScoreService;

@RestController
@RequestMapping(path = "/scores")
public class ScoreController {

    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @PutMapping
    public MovieDTO saveScore(@RequestBody ScoreDTO scoreDTO) {
        return scoreService.saveScore(scoreDTO);
    }
}
