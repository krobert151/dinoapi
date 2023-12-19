package com.rebolledonaharro.dinoapi.criteria;


public record SearchCriteria(
        String key,

        String operation,

        Object value

) {
}
