package com.example.movie.dto;

import com.example.movie.model.MovieCloud;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

public record CommentWithMovie(
        ObjectId id,
        String name,
        String email,
        String text,
        LocalDateTime date,
        MovieCloud movie
) {
}
