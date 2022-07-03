package com.example.sms_spring_boot_asses.model;



import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private Long movieid;
    private Long rating;
    private Long votes;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movieid",insertable = false,updatable = false)
    private Movies movie;


}
