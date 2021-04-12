package com.mangomanagement.demo.util.query;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class SpecificationImpl<T> implements Specification<T> {
    private SearchCriteria criteria;

    public SpecificationImpl(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Specification<T> and(Specification<T> other) {
        return null;
    }

    @Override
    public Specification<T> or(Specification<T> other) {
        return null;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (criteria.getOperation().equalsIgnoreCase("=")) {
            return criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue());
        }
        return null;
    }
}
