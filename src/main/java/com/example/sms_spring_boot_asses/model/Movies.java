package com.example.sms_spring_boot_asses.model;

//takes care of the getters and setters
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "movies")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    private String title;
    private Date year;
    @Column(unique = true)
    private BigDecimal ratings;
    private String url;

    @OneToMany(mappedBy = "movies",cascade = CascadeType.ALL)
    private List<Rating> ratingList = new ArrayList<Rating>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "directors",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "person_id")})
    private List<Director> directorList = new ArrayList<Director>();



    @Override
    public int hashCode() {

        return Objects.hash(id, title, year, url,  ratings);
    }




    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", url='" + url + '\'' +
                ", ratings=" + ratings +
                '}';
    }
}
