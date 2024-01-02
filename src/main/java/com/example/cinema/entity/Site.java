package com.example.cinema.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "sites")
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "site_id")
    private Long id;
    @Column(name = "site_name")
    private String name;
    private String cinema;
    @OneToMany(mappedBy = "site",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    private List<Showtime_site> showtimeSiteList = new ArrayList<>();
    public void addSite(Showtime_site site){
        showtimeSiteList.add(site);
    }
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @ManyToMany()
    private List<Movie> movies = new ArrayList<>();
    public void addMovie(Movie movie){
        movies.add(movie);
    }
}
