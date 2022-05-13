package software.robsoncassiano.learn.dsmovie.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private Double score;
    private Integer count;

    @OneToMany(mappedBy = "id.movie")
    private final Set<Score> scores = new HashSet<>();

    public Movie() {
    }

    public Movie(Long id, String title, String image, Double score, Integer count) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.score = score;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Set<Score> getScores() {
        return scores;
    }
}
