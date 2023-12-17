package com.rebolledonaharro.dinoapi.dino.service;

import com.rebolledonaharro.dinoapi.dino.model.Dinosaur;
import com.rebolledonaharro.dinoapi.dino.repository.DinosaurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DinosaurService {

    private final DinosaurRepository repository;


    public List<Dinosaur> findAll(){

        List<Dinosaur> list = repository.findAll();

        if(list.isEmpty())
            throw new RuntimeException();

        return list;

    }


}
