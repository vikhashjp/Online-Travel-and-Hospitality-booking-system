package com.example.demo.service;

import com.example.demo.dto.PaymentDTO;
import com.example.demo.model.Payment;
import com.example.demo.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public void processPayment(PaymentDTO paymentDTO) {
        Payment paymentEntity = new Payment();
        paymentEntity.setUserId(paymentDTO.getUserId());
        paymentEntity.setBookingId(paymentDTO.getBookingId());
        paymentEntity.setAmount(paymentDTO.getAmount());
        paymentEntity.setStatus(paymentDTO.getStatus());
        paymentEntity.setPaymentMethod(paymentDTO.getPaymentMethod());
        paymentRepository.save(paymentEntity);
    }

    public List<PaymentDTO> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        List<PaymentDTO> paymentDTOs = new ArrayList<>();

        for (Payment paymentEntity : payments) {
            PaymentDTO dto = new PaymentDTO();
            dto.setId(paymentEntity.getId());
            dto.setUserId(paymentEntity.getUserId());
            dto.setBookingId(paymentEntity.getBookingId());
            dto.setAmount(paymentEntity.getAmount());
            dto.setStatus(paymentEntity.getStatus());
            dto.setPaymentMethod(paymentEntity.getPaymentMethod());
            paymentDTOs.add(dto);
        }
        return paymentDTOs;
    }
}
