package com.rebolledonaharro.dinoapi.dino.specification;

import com.rebolledonaharro.dinoapi.dino.model.Dinosaur;
import com.rebolledonaharro.dinoapi.util.GenericSpecificationBuilder;
import com.rebolledonaharro.dinoapi.util.SearchCriteria;

import java.util.List;

public class DinosaurSpecificationBuilder extends GenericSpecificationBuilder<Dinosaur> {
    public DinosaurSpecificationBuilder(List<SearchCriteria> params) {
        super(params);
    }
}
