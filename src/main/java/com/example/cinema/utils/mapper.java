package com.example.cinema.utils;

import com.example.cinema.dto.response.MovieResponse;
import com.example.cinema.entity.Category;
import com.example.cinema.entity.Movie;
import org.springframework.util.ObjectUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class mapper {
    public static MovieResponse mapperToMovieResponse(Movie movie){
        MovieResponse response = new MovieResponse();
        response.setId(movie.getId());
        response.setName(movie.getName());
        response.setImg(movie.getImg());
        response.setActor(movie.getActor());
        response.setDirector(movie.getDirector());
        response.setLanguage(movie.getLanguage());
        response.setDescription(movie.getDescription());
        if(movie.getRating() != null){
            response.setRating(movie.getRating());
        }else{
            response.setRating("Chưa có đánh giá");
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        response.setStartTime(String.valueOf(format.format(movie.getStartTime())));
        response.setTiming(movie.getTiming());
        List<String> categoriesName = new ArrayList<>();
        if(!ObjectUtils.isEmpty(movie.getCategories())){
            List<Category> categories = movie.getCategories();
            for(Category c : categories){
                categoriesName.add(c.getName());
            }
        }
        response.setCategoriesName(categoriesName);
        return response;
    }

    public static List<MovieResponse> mapperToLstMovieResponse(List<Movie> movielist){
        List<MovieResponse> movieResponseList = new ArrayList<>();
        for(Movie m : movielist){
            movieResponseList.add(mapperToMovieResponse(m));
        }
        return movieResponseList;
    }
}
