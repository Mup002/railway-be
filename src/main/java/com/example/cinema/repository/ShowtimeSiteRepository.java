package com.example.cinema.repository;

import com.example.cinema.entity.Showtime_site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ShowtimeSiteRepository extends JpaRepository<Showtime_site, Long> {
    Showtime_site findShowtime_siteById(Long id);
    List<Showtime_site> findShowtime_siteBySiteId(Long id);
}
