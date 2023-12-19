package com.rebolledonaharro.dinoapi.dino.service;

import com.rebolledonaharro.dinoapi.criteria.SearchCriteria;
import com.rebolledonaharro.dinoapi.criteria.SearchOperation;
import com.rebolledonaharro.dinoapi.dino.Specification.DinosaurSpecification;
import com.rebolledonaharro.dinoapi.dino.Specification.DinosaurSpecificationBuilder;
import com.rebolledonaharro.dinoapi.dino.model.Dinosaur;
import com.rebolledonaharro.dinoapi.dino.repository.DinosaurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.google.common.base.Joiner;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public List<Dinosaur> findAllSpec (String search){
        DinosaurSpecificationBuilder builder = new DinosaurSpecificationBuilder();
        String operationSetExper = Joiner.on("|")
                .join(SearchOperation.SIMPLE_OPERATION_SET);
        Pattern pattern = Pattern.compile("(\\w+?)(" + operationSetExper + ")(\\p{Punct}?)(\\w+?)(\\p{Punct}?),");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(4), matcher.group(3), matcher.group(5));
        }
        Specification<Dinosaur> spec = builder.build();

        return repository.findAll(spec);

    }



}
