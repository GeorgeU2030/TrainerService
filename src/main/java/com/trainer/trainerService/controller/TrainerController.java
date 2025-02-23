package com.trainer.trainerService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainer.trainerService.model.Trainer;
import com.trainer.trainerService.service.TrainerService;

@RestController
@RequestMapping("/api/trainers")
public class TrainerController {
    @Autowired
    private TrainerService trainerService;

    @PostMapping
    public Trainer addTrainer(@RequestBody Trainer trainer) {
        return trainerService.addTrainer(trainer);
    }

    @GetMapping
    public List<Trainer> getAllTrainers() {
        return trainerService.getAllTrainers();
    }
}
