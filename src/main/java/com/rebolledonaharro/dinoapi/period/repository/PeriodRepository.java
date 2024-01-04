package com.rebolledonaharro.dinoapi.period.repository;

import com.rebolledonaharro.dinoapi.period.model.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface PeriodRepository extends JpaRepository<Period, UUID> {

    @Query("""
            select p from Period p
            Where (?1 between p.started and p.finished) 
            or (?2 between p.started and p.finished)
            """)
    List<Period> findPeriodsFromDinoAge(double liveSince, double liliveUntil);

}
