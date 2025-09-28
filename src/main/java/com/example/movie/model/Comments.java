package com.example.movie.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@Document(collection = "comments")
public record Comments(
        @MongoId ObjectId id,
        String name,
        String email,
        @Field("movie_id")
        ObjectId movie,
        String text,
        LocalDateTime date
) {}
