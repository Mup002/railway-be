package com.example.cinema.service.impl;

import com.example.cinema.dto.response.CinemaCustomeResponse;
import com.example.cinema.entity.Movie;
import com.example.cinema.entity.Showtime;
import com.example.cinema.entity.Showtime_site;
import com.example.cinema.entity.Site;
import com.example.cinema.repository.MovieRepository;
import com.example.cinema.repository.ShowtimeRepository;
import com.example.cinema.repository.ShowtimeSiteRepository;
import com.example.cinema.repository.SiteRepository;
import com.example.cinema.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {
    private final SiteRepository siteRepository;
    private final MovieRepository movieRepository;
    private final ShowtimeSiteRepository showtimeSiteRepository;
    private final ShowtimeRepository showtimeRepository;
    @Override
    public List<String> findSiteByIdMovie(Long id) {
//        Movie movie = movieRepository.findMovieById(id);
//        List<Site> sites = movie.getSites();
        List<Site> sites = siteRepository.findSiteByMovies_Id(id);
        List<String> result = new ArrayList<>();
        for(Site s : sites){
            result.add(s.getName());
        }
        return result;
    }

    @Override
    public CinemaCustomeResponse findShowtimeByIdSite(Long id) {
        List<Showtime_site> showtimesites = showtimeSiteRepository.findShowtime_siteBySiteId(id);
        CinemaCustomeResponse cinemaCustomeResponse = new CinemaCustomeResponse();
        cinemaCustomeResponse.setName(siteRepository.findSiteById(id).getName());
        List<String> show = new ArrayList<>();
        for(Showtime_site ss : showtimesites){
            show.add(ss.getShowtime().getTime());
        }
        cinemaCustomeResponse.setShowtimes(show);
        return cinemaCustomeResponse;
//        return null;
    }

    @Override
    public List<Showtime> findByDay(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date formatted = new Date();
        try {
            formatted = format.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return showtimeRepository.findShowtimeByDay(formatted).stream().collect(Collectors.toList());
    }
    @Override
    public Showtime findShowtimeById(Long id) {
        return showtimeRepository.findShowtimeById(id);
    }
}
