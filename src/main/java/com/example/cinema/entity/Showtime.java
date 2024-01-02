package com.example.cinema.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "showtimes")
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "showtime_id")
    private Long id;
    private String time;
    private Date day;
    @OneToMany(mappedBy = "showtime")
    private List<Showtime_site> showtimeSiteList = new ArrayList<>();
    public void addShowtime(Showtime_site showtime){
        showtimeSiteList.add(showtime);
    }
}
