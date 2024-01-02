package com.example.cinema.controller;

import com.example.cinema.dto.request.ShowtimeCustomRequest;
import com.example.cinema.dto.response.SiteCustomResponse;
import com.example.cinema.entity.Site;
import com.example.cinema.service.SiteService;
import com.example.cinema.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/site")
@RequiredArgsConstructor
public class SiteController {
    private final SiteService siteService;
    @GetMapping("/findSite")
    public ResponseEntity<List<SiteCustomResponse>> find(@RequestBody ShowtimeCustomRequest request){
        List<SiteCustomResponse> responses = siteService.getAllSiteByMovie(request);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

}
