package com.example.movie.config;

import com.example.movie.model.Movie;
import com.example.movie.model.Person;
import com.example.movie.repository.MovieRepository;
import com.example.movie.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class MongoRunner implements ApplicationRunner {

    private final PersonRepository personRepository;
    private final MovieRepository movieRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

//        personRepository.insert(new Person(UUID.randomUUID().toString(), "Joe", 34));
//
//        System.out.println(personRepository.findAll());
//
//        List<Movie> movies = movieRepository.findAll();
//
//        Map<String, List<Movie>> filter = movies.stream().filter(movie -> movie.year() >= 2015)
//                .sorted(Comparator.comparing(Movie::name)).limit(10)
//                .collect(Collectors.groupingBy(Movie::rating));
//
//        System.out.println(filter);

    }
}
