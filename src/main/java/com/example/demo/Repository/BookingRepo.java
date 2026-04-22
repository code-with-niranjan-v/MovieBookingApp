package com.example.demo.Repository;

import com.example.demo.Entity.Booking;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking,Integer> {

    @Query("select b from Booking b where b.member.memberId = ?1")
    List<Booking> getBookingsByMemberId(int id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Booking b WHERE b.movie.movieId = :movieId")
    void deleteByMovieMovieId(@Param("movieId") int movieId);
}
