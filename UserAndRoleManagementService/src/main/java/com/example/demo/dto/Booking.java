package com.example.demo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Booking {

    
    private Long bookingId;

    private Long userId;
    private String type; // Hotel or Flight
    private String status; // Pending, Confirmed, Canceled
    private Long paymentId;
    private Long hotelId; // Optional for Hotel bookings
    private Long flightId; // Optional for Flight bookings
    
    private Date bookingDate;
}
