package com.example.demo.controller;

import com.example.demo.dto.ReviewDTO;
import com.example.demo.dto.SupportTicketDTO;
import com.example.demo.service.ReviewAndSupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review-support")
public class ReviewAndSupportController {

    @Autowired
    private ReviewAndSupportService reviewAndSupportService;

    // Review Endpoints
    @PostMapping("/reviews")
    public ResponseEntity<String> submitReview(@RequestBody ReviewDTO reviewDTO) {
        reviewAndSupportService.submitReview(reviewDTO);
        return ResponseEntity.ok("Review submitted successfully!");
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<ReviewDTO>> getAllReviews() {
        List<ReviewDTO> reviews = reviewAndSupportService.getAllReviews();
        return ResponseEntity.ok(reviews);
    }

    // Support Ticket Endpoints
    @PostMapping("/support-tickets")
    public ResponseEntity<String> submitSupportTicket(@RequestBody SupportTicketDTO ticketDTO) {
        reviewAndSupportService.submitSupportTicket(ticketDTO);
        return ResponseEntity.ok("Support ticket submitted successfully!");
    }

    @GetMapping("/support-tickets")
    public ResponseEntity<List<SupportTicketDTO>> getAllSupportTickets() {
        List<SupportTicketDTO> tickets = reviewAndSupportService.getAllSupportTickets();
        return ResponseEntity.ok(tickets);
    }
}
