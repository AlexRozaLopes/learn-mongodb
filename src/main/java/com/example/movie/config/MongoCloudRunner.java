package com.example.movie.config;

import com.example.movie.model.Comments;
import com.example.movie.repository.CommentsRepository;
import com.example.movie.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class MongoCloudRunner implements ApplicationRunner {

    private final CommentsRepository commentsRepository;
    private final UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("Total docs comments: " + commentsRepository.count());
        System.out.println("Total docs users: " + userRepository.count());
//        List<Comments> comments = commentsRepository.findAll();
//        System.out.println(comments);

    }
}
