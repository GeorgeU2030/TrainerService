package com.trainer.trainerService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainer.trainerService.model.Trainer;
import com.trainer.trainerService.repository.TrainerRepository;

@Service
public class TrainerService {
    @Autowired
    private TrainerRepository trainerRepository;

    public Trainer addTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }
    
    public Trainer getTrainerById(Long id) {
        return trainerRepository.findById(id).orElse(null);
    }
}
