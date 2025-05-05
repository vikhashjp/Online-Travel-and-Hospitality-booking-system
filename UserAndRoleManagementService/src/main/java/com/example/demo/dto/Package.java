package com.example.demo.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Package {
	private Long id;

    private String name;

   
    private List<String> includedHotels;

    
    private List<String> includedFlights;

    
    private List<String> activities;

    private Double price;
}
