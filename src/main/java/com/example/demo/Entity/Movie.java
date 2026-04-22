package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;
    @NotBlank
    private String movieName;
    @NotBlank
    private String language;
    @NotBlank
    private String genre;
    @Positive
    private int duration;
    @Positive
    private double ticketPrice;


    public Movie(String movieName, String language, String genre, int duration, double ticketPrice) {
        this.movieName = movieName;
        this.language = language;
        this.genre = genre;
        this.duration = duration;
        this.ticketPrice = ticketPrice;
    }

    public Movie(int movieId, String movieName, String language, String genre, int duration, double ticketPrice) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.language = language;
        this.genre = genre;
        this.duration = duration;
        this.ticketPrice = ticketPrice;
    }

    public Movie() {
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", language='" + language + '\'' +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
