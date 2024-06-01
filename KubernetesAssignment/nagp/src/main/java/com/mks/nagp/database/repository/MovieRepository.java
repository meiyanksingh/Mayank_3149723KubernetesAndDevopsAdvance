package com.mks.nagp.database.repository;
import com.mks.nagp.database.document.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

    Movie findByName(String name);
}
