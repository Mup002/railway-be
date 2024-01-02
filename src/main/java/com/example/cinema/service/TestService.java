package com.example.cinema.service;

import com.example.cinema.dto.response.CinemaCustomeResponse;
import com.example.cinema.entity.Showtime;
import com.example.cinema.entity.Site;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TestService {
    List<String> findSiteByIdMovie(Long id);
    CinemaCustomeResponse findShowtimeByIdSite(Long id);
    List<Showtime> findByDay(String date);
    Showtime findShowtimeById(Long id);

}
