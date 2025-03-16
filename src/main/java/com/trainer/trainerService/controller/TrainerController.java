package com.trainer.trainerService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainer.trainerService.model.Trainer;
import com.trainer.trainerService.service.TrainerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/trainers")
public class TrainerController {
    @Autowired
    private TrainerService trainerService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(
        summary = "Add a new trainer",
        description = "This endpoint allows an ADMIN to add a new trainer to the system. " +
                      "The trainer details must be provided in the request body."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Trainer added successfully"),
        @ApiResponse(responseCode = "401", description = "Unauthorized"),
        @ApiResponse(responseCode = "403", description = "Forbidden, ADMIN role required"),
        @ApiResponse(responseCode = "404", description = "Resource not found")
    })
    public Trainer addTrainer(@RequestBody Trainer trainer) {
        return trainerService.addTrainer(trainer);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TRAINER','ROLE_MEMBER')")
    @Operation(
        summary = "Get all trainers",
        description = "This endpoint retrieves a list of all trainers. " +
                      "It can be accessed by users with the ADMIN, TRAINER, or MEMBER role."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of trainers retrieved successfully"),
        @ApiResponse(responseCode = "401", description = "Unauthorized"),
        @ApiResponse(responseCode = "403", description = "Forbidden, ADMIN, TRAINER, or MEMBER role required"),
        @ApiResponse(responseCode = "404", description = "Resource not found")
    })
    public List<Trainer> getAllTrainers() {
        return trainerService.getAllTrainers();
    }
    
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(
        summary = "Get a trainer by ID",
        description = "This endpoint retrieves a specific trainer by their ID. " +
                      "Only users with the ADMIN role can access this endpoint."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Trainer retrieved successfully"),
        @ApiResponse(responseCode = "401", description = "Unauthorized"),
        @ApiResponse(responseCode = "403", description = "Forbidden, ADMIN role required"),
        @ApiResponse(responseCode = "404", description = "Trainer not found")
    })
    public Trainer getTrainerById(@PathVariable Long id) {
        return trainerService.getTrainerById(id);
    }
}
