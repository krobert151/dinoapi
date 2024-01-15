package com.rebolledonaharro.dinoapi.dino.service;

import com.rebolledonaharro.dinoapi.clasification.model.Classification;
import com.rebolledonaharro.dinoapi.clasification.service.ClasificationService;
import com.rebolledonaharro.dinoapi.dino.dto.DinoBasicGET;
import com.rebolledonaharro.dinoapi.dino.dto.DinoPOST;
import com.rebolledonaharro.dinoapi.dino.dto.SimpleDinoGET;
import com.rebolledonaharro.dinoapi.dino.error.DinosaurNotFoundException;
import com.rebolledonaharro.dinoapi.dino.model.Dinosaur;
import com.rebolledonaharro.dinoapi.dino.repository.DinosaurRepository;
import com.rebolledonaharro.dinoapi.dino.specification.DinosaurSpecificationBuilder;
import com.rebolledonaharro.dinoapi.period.model.Period;
import com.rebolledonaharro.dinoapi.period.service.PeriodService;
import com.rebolledonaharro.dinoapi.util.SearchCriteria;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Log
@Service
@RequiredArgsConstructor
public class DinosaurService {

    private final DinosaurRepository repository;
    private final ClasificationService clasificationService;
    private final PeriodService periodService;

    @Transactional
    public List<DinoBasicGET> findAll(){

        List<Dinosaur> list = repository.findAll();

        if(list.isEmpty())
            throw new DinosaurNotFoundException();

        return list.stream().map(x->
                {


                    return new DinoBasicGET(x.getName(),
                            x.getScientificName(),
                            x.getClassification().getName(),
                            ""+x.getHeight(),
                            ""+x.getWeight(),
                            ""+x.getLength(),
                            "to " +x.getLiveSince()+ " mill ago, form "+x.getLiveUntil()+" mill ago",
                            ""+x.getNumTheeth(),
                            x.getPeriods()
                                    .stream()
                                    .sorted((a, b) -> (int) (a.getStarted() - b.getStarted()))
                                    .map(Period::getName)
                                    .collect(Collectors.joining(" ")));
                }
        ).toList();



    }

    public Dinosaur addDino2 (Dinosaur dinosaur){
        return repository.save(dinosaur);
    }

    public DinoBasicGET addDino(DinoPOST post){

        Dinosaur dinosaur = Dinosaur.builder()
                .scientificName(post.scientificName())
                .name(post.name())
                .height( post.height())
                .weight(post.weight())
                .length(post.lenght())
                .liveSince(post.liveSince())
                .liveUntil(post.liveUntil())
                .numTheeth(post.numTheeth())
                .periods(periodService.findPeriodFromTo(post.liveSince(), post.liveUntil()))
                .classification(clasificationService.findByName(post.family()))
                .build();

        repository.save(dinosaur);




        return new DinoBasicGET(
                dinosaur.getName(),
                dinosaur.getScientificName(),
                dinosaur.getClassification().getName(),
                ""+dinosaur.getHeight(),
                ""+dinosaur.getWeight(),
                ""+dinosaur.getLength(),
                "to " +dinosaur.getLiveSince()+ " mill ago, form "+dinosaur.getLiveUntil()+" mill ago",
                ""+dinosaur.getNumTheeth(),
                dinosaur.getPeriods()
                        .stream()
                        .sorted((x, y) -> (int) (x.getStarted() - y.getStarted()))
                        .map(Period::getName)
                        .collect(Collectors.joining(" ")));





    }

    @Transactional
    public List<DinoBasicGET> findAllSpec (String search){
        List<SearchCriteria> params = new ArrayList<SearchCriteria>();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            params.add(new SearchCriteria(matcher.group(1), matcher.group(2),matcher.group(3)));
        }

        List<Dinosaur> list= search(params);

        if(list.isEmpty())
            throw new DinosaurNotFoundException("Can´t find a dinosaur with those specifications "+ params.toString());

        return list.stream().map(x->
            {

                Hibernate.initialize(x.getPeriods());

                return new DinoBasicGET(x.getName(),
                x.getScientificName(),
                x.getClassification().getName(),
                ""+x.getHeight(),
                ""+x.getWeight(),
                ""+x.getLength(),
                "to " +x.getLiveSince()+ " mill ago, form "+x.getLiveUntil()+" mill ago",
                ""+x.getNumTheeth(),
                x.getPeriods()
                        .stream()
                        .sorted((a, b) -> (int) (a.getStarted() - b.getStarted()))
                        .map(Period::getName)
                        .collect(Collectors.joining(" ")));
            }
        ).toList();

    }


    public List<Dinosaur> search(List<SearchCriteria> searchCriteriaList){

        DinosaurSpecificationBuilder dinosaurSpecificationBuilder = new DinosaurSpecificationBuilder(searchCriteriaList);

        return repository.findAll(dinosaurSpecificationBuilder.build());

    }


}
