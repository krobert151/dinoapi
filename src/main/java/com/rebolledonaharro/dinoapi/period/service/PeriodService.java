package com.rebolledonaharro.dinoapi.period.service;

import com.rebolledonaharro.dinoapi.period.model.Period;
import com.rebolledonaharro.dinoapi.period.repository.PeriodRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.*;

@Log
@Service
@RequiredArgsConstructor
public class PeriodService {

    private final PeriodRepository repository;


    public List<Period> findPeriodFromTo(double from, double to){

        List<Period> periods = repository.findAll();
        List<Period> myPeriods = new ArrayList<>();

        periods.forEach(
                x->{
                    if ((to <= x.getStarted() && to >= x.getFinished()) ||
                            (from >= x.getStarted() && from >= x.getFinished())) {
                        myPeriods.add(x);
                    }
                }
        );

        return myPeriods;


    }



}
