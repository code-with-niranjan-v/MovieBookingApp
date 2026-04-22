package com.example.demo.Service;

import com.example.demo.Entity.Booking;
import com.example.demo.Repository.BookingRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    public Booking bookMovie(@Valid Booking booking) {
        return bookingRepo.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

    public Booking getBookingById(int id) {
        return bookingRepo.findById(id).orElse(null);
    }

    public Booking cancelBooking(int id) {
        Booking booking = getBookingById(id);
        if(booking!=null){
            booking.setBookingStatus("Canceled");
        }
        return booking;
    }

    public List<Booking> getBookingsByMemberId(int id) {
        return bookingRepo.getBookingsByMemberId(id);
    }
}
