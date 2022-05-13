package software.robsoncassiano.learn.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import software.robsoncassiano.learn.dsmovie.entities.Score;
import software.robsoncassiano.learn.dsmovie.entities.ScorePK;

@Repository
public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
}
