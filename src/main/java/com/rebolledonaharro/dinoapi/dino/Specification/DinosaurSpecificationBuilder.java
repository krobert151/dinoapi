package com.rebolledonaharro.dinoapi.dino.Specification;

import com.rebolledonaharro.dinoapi.criteria.SearchOperation;
import com.rebolledonaharro.dinoapi.criteria.SpecSearchCriteria;
import com.rebolledonaharro.dinoapi.dino.model.Dinosaur;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class DinosaurSpecificationBuilder {

    private final List<SpecSearchCriteria> params;

    public DinosaurSpecificationBuilder(){
        params = new ArrayList<>();
    }

    public final DinosaurSpecificationBuilder with(String key, String operation, Object value,
    String prefix, String sufix){
        return with( key,operation,value,prefix,sufix);
    }

    public final DinosaurSpecificationBuilder with(boolean orPredicate, String key, String operation, Object value
    ,String prefix, String suffix){

        SearchOperation op = SearchOperation.getSimpleOperation(operation.charAt(0));
        if(op != null){
            if (op == SearchOperation.EQUALITY) { // the operation may be complex operation
                final boolean startWithAsterisk = prefix != null && prefix.contains(SearchOperation.ZERO_OR_MORE_REGEX);
                final boolean endWithAsterisk = suffix != null && suffix.contains(SearchOperation.ZERO_OR_MORE_REGEX);

                if (startWithAsterisk && endWithAsterisk) {
                    op = SearchOperation.CONTAINS;
                } else if (startWithAsterisk) {
                    op = SearchOperation.ENDS_WITH;
                } else if (endWithAsterisk) {
                    op = SearchOperation.STARTS_WITH;
                }
            }
            params.add(new SpecSearchCriteria(key,op, value, orPredicate));

        }
            return this;


    }

    public Specification build(){
        if(params.isEmpty())
            return null; //manage exception

        Specification result = new DinosaurSpecification(params.get(0));


        for (int i = 1; i<params.size(); i++){
            result = params.get(i).isOrPredicate()
                    ? Specification.where(result).or(new DinosaurSpecification(params.get(i)))
                    : Specification.where(result).and(new DinosaurSpecification(params.get(i)));
        }

        return result;

    }


}
