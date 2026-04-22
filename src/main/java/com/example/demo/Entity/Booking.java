package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    @NotBlank
    private String bookingDate;
    @Min(1)
    private int noOfSeats;
    @Positive
    private double totalAmount;
    @NotBlank
    private String bookingStatus;
    @ManyToOne
    @JoinColumn(name = "member_id")
    @JsonBackReference
    private Member member;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;


    public Booking(String bookingDate, int noOfSeats, double totalAmount, String bookingStatus, Member member, int movieId) {
        this.bookingDate = bookingDate;
        this.noOfSeats = noOfSeats;
        this.totalAmount = totalAmount;
        this.bookingStatus = bookingStatus;
        this.member = member;
    }

    public Booking(int bookingId, String bookingDate, int noOfSeats, double totalAmount, String bookingStatus, Member member, int movieId) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.noOfSeats = noOfSeats;
        this.totalAmount = totalAmount;
        this.bookingStatus = bookingStatus;
        this.member = member;
    }

    public Booking() {
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", bookingDate='" + bookingDate + '\'' +
                ", noOfSeats=" + noOfSeats +
                ", totalAmount=" + totalAmount +
                ", bookingStatus='" + bookingStatus + '\'' +
                ", member=" + member +
                '}';
    }
}
