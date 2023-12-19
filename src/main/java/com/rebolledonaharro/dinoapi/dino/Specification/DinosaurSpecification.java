package com.rebolledonaharro.dinoapi.dino.Specification;

import com.rebolledonaharro.dinoapi.criteria.SearchCriteria;
import com.rebolledonaharro.dinoapi.criteria.SpecSearchCriteria;
import com.rebolledonaharro.dinoapi.dino.model.Dinosaur;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class DinosaurSpecification implements Specification<Dinosaur> {

    private SpecSearchCriteria criteria;

    public DinosaurSpecification(final SpecSearchCriteria criteria) {
        super();
        this.criteria = criteria;
    }


    public SpecSearchCriteria  getCriteria() {
        return criteria;
    }

    @Override
    public Predicate toPredicate(final Root<Dinosaur> root, final CriteriaQuery<?> query, final CriteriaBuilder builder) {
        switch (criteria.getOperation()) {
            case EQUALITY:
                return builder.equal(root.get(criteria.getKey()), criteria.getValue());
            case NEGATION:
                return builder.notEqual(root.get(criteria.getKey()), criteria.getValue());
            case GREATER_THAN:
                return builder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString());
            case LESS_THAN:
                return builder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString());
            case LIKE:
                return builder.like(root.get(criteria.getKey()), criteria.getValue().toString());
            case STARTS_WITH:
                return builder.like(root.get(criteria.getKey()), criteria.getValue() + "%");
            case ENDS_WITH:
                return builder.like(root.get(criteria.getKey()), "%" + criteria.getValue());
            case CONTAINS:
                return builder.like(root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
            default:
                return null;
        }
    }


    @Override
    public Specification<Dinosaur> and(Specification<Dinosaur> other) {
        return Specification.super.and(other);
    }

    @Override
    public Specification<Dinosaur> or(Specification<Dinosaur> other) {
        return Specification.super.or(other);
    }

}
