package com.example.demo.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.Booking;

//@FeignClient(name = "BOOKINGSERVICE", url = "http://localhost:8082/api/bookings")
@FeignClient(name = "BOOKINGSERVICE", path = "/api/bookings")
public interface BookingClient {

    @PostMapping("/create")
    public String createBooking(@RequestBody Booking booking);

    @GetMapping("/fetchById/{bid}")
    public Booking getBookingById(@PathVariable("bid") Long bookingId);
}
