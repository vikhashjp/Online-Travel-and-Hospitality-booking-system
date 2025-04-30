package com.example.demo.service;

import com.example.demo.exceptions.BookingNotFoundException;
import com.example.demo.model.Booking;
import com.example.demo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking createBooking(Booking booking) {
        booking.setBookingDate(new Date());
        booking.setStatus("Pending");
        return bookingRepository.save(booking);
    }

    public List<Booking> getBookingsByUser(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    public Booking updateBookingStatus(Long bookingId, String status) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new BookingNotFoundException("Booking not found with ID: " + bookingId));
        booking.setStatus(status);
        return bookingRepository.save(booking);
    }
}
