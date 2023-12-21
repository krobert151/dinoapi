package com.rebolledonaharro.dinoapi.util;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
@AllArgsConstructor
public abstract class GenericSpecificationBuilder <U>{

    private List<SearchCriteria> params;

    public Specification<U> build(){

        if (params.isEmpty()){
            return null;
        }

        Specification<U> result = build(params.get(0));

        for (int i = 1; i<params.size(); i++){
            result = result.and(build(params.get(i)));
        }

        return result;

    }

    private Specification<U> build (SearchCriteria params){

        return new Specification<U>() {
            @Override
            public Predicate toPredicate(Root<U> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (params.operation().equalsIgnoreCase(">")) {
                    return criteriaBuilder.greaterThanOrEqualTo(
                            root.<String> get(params.key()), params.value().toString());
                }
                else if (params.operation().equalsIgnoreCase("<")) {
                    return criteriaBuilder.lessThanOrEqualTo(
                            root.<String> get(params.key()), params.value().toString());
                }
                else if (params.operation().equalsIgnoreCase(":")) {
                    if (root.get(params.key()).getJavaType() == String.class) {
                        return criteriaBuilder.like(
                                root.<String>get(params.key()), "%" + params.value() + "%");
                    } else {
                        return criteriaBuilder.equal(root.get(params.key()), params.value());
                    }
                }
                return null;
            }
        };
    }

}
