package com.rebolledonaharro.dinoapi.clasification.service;

import com.rebolledonaharro.dinoapi.clasification.model.Classification;
import com.rebolledonaharro.dinoapi.clasification.repository.ClasificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClasificationService {

    private final ClasificationRepository repository;

    public Classification findByName(String name){

        Optional<Classification> classification = repository.findFirstByName(name);

        if(classification.isEmpty()){
            throw new  RuntimeException();
        }

        return classification.get();

    }


}
