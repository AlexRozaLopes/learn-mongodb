package com.example.movie.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
public record Person(@MongoId() String id, String name, int age) {
}
