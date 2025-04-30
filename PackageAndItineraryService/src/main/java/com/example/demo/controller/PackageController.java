package com.example.demo.controller;

import com.example.demo.dto.PackageDTO;
import com.example.demo.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packages")
public class PackageController {

    @Autowired
    private PackageService packageService;

    @PostMapping
    public ResponseEntity<String> createPackage(@RequestBody PackageDTO packageDTO) {
        packageService.createPackage(packageDTO);
        return ResponseEntity.ok("Package created successfully!");
    }

    @GetMapping
    public ResponseEntity<List<PackageDTO>> getAllPackages() {
        List<PackageDTO> packages = packageService.getAllPackages();
        return ResponseEntity.ok(packages);
    }
}
