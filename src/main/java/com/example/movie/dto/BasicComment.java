package com.example.movie.dto;

import java.time.LocalDateTime;

public record BasicComment(String text, LocalDateTime date) {
}
