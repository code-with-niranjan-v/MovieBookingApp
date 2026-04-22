package com.example.demo.Repository;

import com.example.demo.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie,Integer> {

    List<Movie> getMoviesByLanguage(String language);

    List<Movie> getMoviesByGenre(String genre);


}
