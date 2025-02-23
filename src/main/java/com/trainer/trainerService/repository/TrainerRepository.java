package com.trainer.trainerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainer.trainerService.model.Trainer;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {}
