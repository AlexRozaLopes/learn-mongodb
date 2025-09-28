package com.example.movie.dto;

import com.example.movie.model.Comments;

import java.util.List;

public record UserWithComments(String id, String name, List<BasicComment> comments) {
}
