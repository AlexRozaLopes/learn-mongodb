package com.example.movie.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "movies")
public record MovieCloud(
        @MongoId ObjectId id,
        String title,
        String plot,
        String year) {}
