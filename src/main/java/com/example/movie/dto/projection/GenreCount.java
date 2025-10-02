package com.example.movie.dto.projection;

import lombok.Data;

@Data
public class GenreCount {
    String id;
    int total_filmes;
}
