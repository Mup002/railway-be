package com.example.cinema.service;

import com.example.cinema.dto.request.ShowtimeCustomRequest;
import com.example.cinema.dto.response.SiteCustomResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SiteService {
    List<SiteCustomResponse> getAllSiteByMovie(ShowtimeCustomRequest request);
}
