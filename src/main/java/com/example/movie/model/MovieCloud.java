package com.example.movie.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document(collection = "movies")
public record MovieCloud(
        @MongoId ObjectId id,
        String title,
        String plot,
        List<String> genres,
        String year) {}
