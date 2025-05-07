package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "payment") // Ensure it maps to the correct table name
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Matches database column name
    private Long paymentId;

    @Column(name = "amount") // Matches database column name
    private Double amount;

    @Column(name = "booking_id") // Matches database column name
    private Long bookingId;

    @Column(name = "payment_method") // Matches database column name
    private String paymentMethod;

    @Column(name = "status") // Matches database column name
    private String status;

    @Column(name = "user_id") // Matches database column name
    private Long userId;

    // Getters and Setters
    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
