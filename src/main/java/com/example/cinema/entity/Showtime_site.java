package com.example.cinema.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "showtime_site")
public class Showtime_site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "showtime_site_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "site_id")
    private Site site;
    @ManyToOne
    @JoinColumn(name = "showtime_id")
    private Showtime showtime;
}
