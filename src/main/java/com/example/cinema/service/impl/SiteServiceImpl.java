package com.example.cinema.service.impl;

import com.example.cinema.dto.request.ShowtimeCustomRequest;
import com.example.cinema.dto.response.CinemaCustomeResponse;
import com.example.cinema.dto.response.SiteCustomResponse;
import com.example.cinema.entity.*;
import com.example.cinema.repository.*;
import com.example.cinema.service.SiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RequiredArgsConstructor
@Service
public class SiteServiceImpl implements SiteService {
    private final SiteRepository siteRepository;
    private final MovieRepository movieRepository;
    private final ShowtimeSiteRepository showtimeSiteRepository;
    private final ShowtimeRepository showtimeRepository;
    private final AddressRepository addressRepository;


    @Override
    public List<SiteCustomResponse> getAllSiteByMovie(ShowtimeCustomRequest request) {
        Movie movie = movieRepository.findMovieById(request.getIdMovie());
        Address address =  addressRepository.findAddressByName(request.getAddress());

        List<Site> sites = siteRepository.findSiteByMovies_Id(request.getIdMovie());
        Map<String , List<Object>> map = new HashMap<>();
        List<SiteCustomResponse> responseList = new ArrayList<>();

        for(Site site : sites){
            if(site.getAddress().getName() == address.getName()){
                List<Object> cinemaLst = new ArrayList<>();
                List<Showtime_site> showtimeSites = showtimeSiteRepository.findShowtime_siteBySiteId(site.getId());
                CinemaCustomeResponse cinema = new CinemaCustomeResponse();
                if(map.isEmpty() || !map.containsKey(site.getName())){
                    cinema.setName(site.getCinema());
                    List<String> showTime =  new ArrayList<>();
                    for(Showtime_site s : showtimeSites){
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        String formatted = format.format(s.getShowtime().getDay());
                        if(formatted.equals(request.getDay())){
                            showTime.add(s.getShowtime().getTime());
                        }
                    }
                    cinema.setShowtimes(showTime);
                    cinemaLst.add(cinema);
                    map.put(site.getName(), cinemaLst);
                }else if(map.containsKey(site.getName())){
                    cinemaLst = map.get(site.getName());
//                    CinemaCustomeResponse cinema = new CinemaCustomeResponse();
//                    List<Showtime_site> showtimeSites = showtimeSiteRepository.findShowtime_siteBySiteId(site.getId());
                    cinema.setName(site.getCinema());
                    List<String> showTime = new ArrayList<>();
                    for(Showtime_site s: showtimeSites){
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        String formatted = format.format(s.getShowtime().getDay());
                        if(formatted.equals(request.getDay())){
                            showTime.add(s.getShowtime().getTime());
                        }
                    }
                    cinema.setShowtimes(showTime);
                    cinemaLst.add(cinema);
                    map.put(site.getName(),cinemaLst);
                 }

            }

        }
        for(Map.Entry<String, List<Object>> entry : map.entrySet()){
            SiteCustomResponse customResponse = new SiteCustomResponse();
            String key = entry.getKey();
            customResponse.setAddress(address.getName());
            customResponse.setName(key);

            List<Object> objects = entry.getValue();
            customResponse.setList(objects);
            responseList.add(customResponse);
        }
        return responseList;
//        return null;
    }
}
