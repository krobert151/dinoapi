package com.rebolledonaharro.dinoapi.period.repository;

import com.rebolledonaharro.dinoapi.period.model.Period;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PeriodRepository extends JpaRepository<Period, UUID> {
}
