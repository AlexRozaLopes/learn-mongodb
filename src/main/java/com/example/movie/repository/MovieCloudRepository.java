package com.example.movie.repository;

import com.example.movie.dto.TitleOnly;
import com.example.movie.model.MovieCloud;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieCloudRepository extends MongoRepository<MovieCloud, ObjectId> {

    @Query(value = "{}", fields = "{title:1,_id:0}")
    List<TitleOnly> findTitle();

    MovieCloud findByTitle(String title);

    @Query("{'title':?0}")
    MovieCloud encontrePeloTitulo(String title);

    List<MovieCloud> findByGenresAndYear(String genre, int year);

}
