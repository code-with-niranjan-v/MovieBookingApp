package com.example.demo.Service;

import com.example.demo.Entity.Member;
import com.example.demo.Entity.Movie;
import com.example.demo.Repository.BookingRepo;
import com.example.demo.Repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepo movieRepo;

    @Autowired
    private BookingRepo bookingRepo;

    public Movie addMovie(Movie m){
        return movieRepo.save(m);
    }

    public List<Movie> getAllMovie() {
        return movieRepo.findAll();
    }

    public List<Movie> getMoviesByLanguage(String language) {
        return movieRepo.getMoviesByLanguage(language);
    }

    public List<Movie> getMoviesByGenre(String genre) {
        return movieRepo.getMoviesByGenre(genre);
    }

    public Movie getMovieById(int id) {
        return movieRepo.findById(id).orElse(null);
    }

    public Movie updateMovie(Movie m) {
        return movieRepo.save(m);
    }

    public String deleteMovieById(int id) {
        Movie m = getMovieById(id);
        if(m!=null){
            bookingRepo.deleteByMovieMovieId(id);
            movieRepo.delete(m);
            return "Movie Deleted!";
        }else{
            return "Movie Not Found!";
        }
    }

    public String updateMoviePrice(int id, double price) {
        Movie m = getMovieById(id);
        if(m!=null){
            m.setTicketPrice(price);
            return "Ticket Price Updated!";
        }else{
            return "Movie Not Found!";
        }
    }
}
