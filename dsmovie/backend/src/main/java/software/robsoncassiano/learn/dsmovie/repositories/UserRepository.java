package software.robsoncassiano.learn.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import software.robsoncassiano.learn.dsmovie.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
