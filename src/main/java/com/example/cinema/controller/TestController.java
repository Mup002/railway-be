package com.example.cinema.controller;

import com.example.cinema.dto.response.CinemaCustomeResponse;
import com.example.cinema.entity.Showtime;
import com.example.cinema.entity.Site;
import com.example.cinema.service.ShowtimeService;
import com.example.cinema.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;
    private final ShowtimeService showtimeService;
    @GetMapping("/findSite/{id}")
    public ResponseEntity<List<String>> findByIdMovie(@PathVariable("id")Long id){
        List<String> sites = testService.findSiteByIdMovie(id);
        return new ResponseEntity<>(sites, HttpStatus.OK);
    }
    @GetMapping("/findShow/{id}")
    public ResponseEntity<CinemaCustomeResponse> findByIdSite(@PathVariable("id")Long id){
        CinemaCustomeResponse cinemaCustomeResponse = testService.findShowtimeByIdSite(id);
        return new ResponseEntity<>(cinemaCustomeResponse,HttpStatus.OK);
    }
    @GetMapping("/findShowtimeByDate/{date}")
    public ResponseEntity<List<Showtime>> findAllByDate(@PathVariable("date")String date){
        List<Showtime> showtimeList = showtimeService.findByDay(date);
        return new ResponseEntity<>(showtimeList, HttpStatus.OK);
    }
}
