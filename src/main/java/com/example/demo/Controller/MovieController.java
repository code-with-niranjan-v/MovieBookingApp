package com.example.demo.Controller;

import com.example.demo.Entity.Member;
import com.example.demo.Entity.Movie;
import com.example.demo.Service.MovieService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@Validated
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/add")
    public Movie addMovie(@Valid @RequestBody Movie m){
        return movieService.addMovie(m);
    }

    @GetMapping("/all")
    public List<Movie> getAllMovie(){
        return movieService.getAllMovie();
    }

    @GetMapping("/search/language/{language}")
    public List<Movie> getMoviesByLanguage(@NotBlank @NotNull @PathVariable String language){
        return movieService.getMoviesByLanguage(language);
    }

    @GetMapping("/search/genre/{genre}")
    public List<Movie> getMoviesByGenre(@NotBlank @NotNull @PathVariable String genre){
        return movieService.getMoviesByGenre(genre);
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@Positive @PathVariable int id){
        return movieService.getMovieById(id);
    }

    @PutMapping("/update/{id}")
    public Movie updateMovie(@Valid @RequestBody Movie m){
        return movieService.updateMovie(m);
    }

    @PutMapping("/update/price/{id}/{price}")
    public String updateMovie(@Positive  @PathVariable int id, @NotBlank @NotNull @PathVariable double price){
        return movieService.updateMoviePrice(id,price);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMovieById(@Positive @PathVariable int id){
        return movieService.deleteMovieById(id);
    }


}
