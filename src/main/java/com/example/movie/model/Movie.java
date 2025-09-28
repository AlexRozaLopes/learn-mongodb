package com.example.movie.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
public record Movie(@MongoId String id, String name, String rating, String genre, int year) {
}
