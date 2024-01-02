package com.example.cinema.dto.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CinemaCustomeResponse {
    private String name;
    private List<String> showtimes = new ArrayList<>();
}
