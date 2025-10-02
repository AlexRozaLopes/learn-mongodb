package com.example.movie.config;

import com.example.movie.repository.CommentsRepository;
import com.example.movie.repository.MovieCloudRepository;
import com.example.movie.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.StructuredTaskScope;

@Component
@AllArgsConstructor
public class MongoCloudRunner implements ApplicationRunner {

    private final CommentsRepository commentsRepository;
    private final UserRepository userRepository;
    private final MovieCloudRepository movieRepository;

    private static final ScopedValue<List<String>> MOVIE_GENRES = ScopedValue.newInstance();

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<String> genres = List.of(
                "Action", "Adventure", "Animation", "Biography", "Comedy", "Crime", "Documentary", "Drama",
                "Family", "Fantasy", "Film-Noir", "History", "Horror", "Music", "Musical", "Mystery", "News",
                "Romance", "Sci-Fi", "Short", "Sport", "Talk-Show", "Thriller", "War", "Western"
        );

        ScopedValue.where(MOVIE_GENRES, genres).run(() -> {
            try (var scope = StructuredTaskScope.open()) {
                scope.fork(() -> System.out.println("Total docs movie: " + movieRepository.count()));

                MOVIE_GENRES.get().forEach(g -> scope.fork(() ->
                        System.out.println("exist: " + movieRepository.countByGenres(g) + " with genre: " + g)));

                try {
                    scope.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
