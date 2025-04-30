package com.example.demo.controller;

import com.example.demo.dto.BookingRequest;
import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody BookingRequest bookingRequest) {
        Booking booking = new Booking();
        booking.setUserId(bookingRequest.getUserId());
        booking.setType(bookingRequest.getType());
        booking.setPaymentId(bookingRequest.getPaymentId());
        booking.setHotelId(bookingRequest.getHotelId());
        booking.setFlightId(bookingRequest.getFlightId());
        Booking newBooking = bookingService.createBooking(booking);
        return new ResponseEntity<>(newBooking, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Booking>> getBookingsByUser(@PathVariable Long userId) {
        List<Booking> bookings = bookingService.getBookingsByUser(userId);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @PatchMapping("/{bookingId}")
    public ResponseEntity<Booking> updateBookingStatus(@PathVariable Long bookingId,
                                                        @RequestParam String status) {
        Booking updatedBooking = bookingService.updateBookingStatus(bookingId, status);
        return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
    }
}
