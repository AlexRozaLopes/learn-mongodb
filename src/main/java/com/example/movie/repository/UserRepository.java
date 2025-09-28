package com.example.movie.repository;

import com.example.movie.dto.UserWithComments;
import com.example.movie.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

    @Aggregation(pipeline = {
            "{ $lookup: { from: 'comments', localField: 'email', foreignField: 'email', as: 'comments' } }",
            "{ $match: { 'comments.0': { $exists: true } } }"
    })
    List<UserWithComments> findAllUserWithComments();
}
