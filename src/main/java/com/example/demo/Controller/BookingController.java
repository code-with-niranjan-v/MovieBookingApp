package com.example.demo.Controller;

import com.example.demo.Entity.Booking;
import com.example.demo.Service.BookingService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
@Validated
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/add")
    public Booking bookMovie(@Valid @RequestBody Booking booking){
        return bookingService.bookMovie(booking);
    }

    @GetMapping("/all")
    public List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@Positive @PathVariable int id){
        return bookingService.getBookingById(id);
    }

    @PutMapping("/cancel/{id}")
    public Booking cancelBooking(@Positive @PathVariable int id){
        return bookingService.cancelBooking(id);
    }

    @GetMapping("/member/{id}")

    public List<Booking> getBookingsByMemberId(@Positive @PathVariable int id){
        return bookingService.getBookingsByMemberId(id);
    }
}
