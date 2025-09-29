package com.example.movie.controller;

import com.example.movie.dto.CommentWithMovie;
import com.example.movie.dto.TitleOnly;
import com.example.movie.dto.UserWithComments;
import com.example.movie.model.Comments;
import com.example.movie.model.MovieCloud;
import com.example.movie.model.User;
import com.example.movie.repository.CommentsRepository;
import com.example.movie.repository.MovieCloudRepository;
import com.example.movie.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@RestController
@AllArgsConstructor
public class MongoController {

    private final CommentsRepository commentsRepository;
    private final UserRepository userRepository;
    private final MovieCloudRepository movieCloudRepository;

    @GetMapping("/movie/{title}")
    public ResponseEntity<MovieCloud> getMovieByName(@PathVariable String title) {
//        return ResponseEntity.ok(movieCloudRepository.findByTitle(title));
        return ResponseEntity.ok(movieCloudRepository.encontrePeloTitulo(title));
    }

    @GetMapping("/comments")
    public ResponseEntity<List<Comments>> getComments() {
        return ResponseEntity.ok(commentsRepository
                .findAll().stream().limit(20)
                .sorted(Comparator.comparing(Comments::name)).toList());
    }

    @GetMapping("/comments-with-movie")
    public ResponseEntity<List<CommentWithMovie>> getCommentsWithMovie() {
        return ResponseEntity.ok(commentsRepository
                .findAllWithMovie().stream()
                .sorted(Comparator.comparing(CommentWithMovie::name)).toList());
    }


    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userRepository.findAll().stream().limit(20)
                .sorted(Comparator.comparing(User::name))
                .toList());
    }

    @GetMapping("/users-with-comments")
    public ResponseEntity<List<UserWithComments>> getUsersWithComments() {
        return ResponseEntity.ok(userRepository.findAllUserWithComments().stream().limit(20)
                .sorted(Comparator.comparing(UserWithComments::name))
                .toList());
    }

    @GetMapping("/title")
    public ResponseEntity<List<TitleOnly>> getTitle() {
        return ResponseEntity.ok(movieCloudRepository.findTitle());
    }
}
