package com.rebolledonaharro.dinoapi.dino.service;

import com.rebolledonaharro.dinoapi.dino.error.DinosaurNotFoundException;
import com.rebolledonaharro.dinoapi.dino.model.Dinosaur;
import com.rebolledonaharro.dinoapi.dino.repository.DinosaurRepository;
import com.rebolledonaharro.dinoapi.dino.specification.DinosaurSpecificationBuilder;
import com.rebolledonaharro.dinoapi.util.SearchCriteria;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Log
@Service
@RequiredArgsConstructor
public class DinosaurService {

    private final DinosaurRepository repository;


    public List<Dinosaur> findAll(){

        List<Dinosaur> list = repository.findAll();

        if(list.isEmpty())
            throw new DinosaurNotFoundException();

        return list;

    }

    public List<Dinosaur> findAllSpec (String search){
        List<SearchCriteria> params = new ArrayList<SearchCriteria>();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            params.add(new SearchCriteria(matcher.group(1), matcher.group(2),matcher.group(3)));
        }

        List<Dinosaur> list= search(params);

        if(list.isEmpty())
            throw new DinosaurNotFoundException("Can´t find a dinosaur with those specifications "+ params.toString());

        return list;

    }


    public List<Dinosaur> search(List<SearchCriteria> searchCriteriaList){

        DinosaurSpecificationBuilder dinosaurSpecificationBuilder = new DinosaurSpecificationBuilder(searchCriteriaList);

        return repository.findAll(dinosaurSpecificationBuilder.build());

    }


}
