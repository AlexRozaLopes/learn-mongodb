package com.example.movie.repository;

import com.example.movie.dto.CommentWithMovie;
import com.example.movie.model.Comments;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends MongoRepository<Comments, ObjectId> {

    @Aggregation(pipeline = {
            "{ $lookup: { from: 'movies', localField: 'movie_id', foreignField: '_id', as: 'movie' } }",
            "{ $unwind: '$movie' }"
    })
    List<CommentWithMovie> findAllWithMovie();
}
