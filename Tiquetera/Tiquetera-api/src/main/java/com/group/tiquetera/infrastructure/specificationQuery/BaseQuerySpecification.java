package com.group.tiquetera.infrastructure.specificationQuery;

import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BaseQuerySpecification<T> {

	protected static <T> Specification<T> equals(String attribute, Object value) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(attribute), value);
	}

	protected static <T> Specification<T> like(String attribute, String value, boolean isExact) {
		String valueToSearch = isExact ? value : ("%" + value + "%");
		return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get(attribute)),
				valueToSearch.toLowerCase());
	}

	protected static <T> Specification<T> greaterOrEqual(String attribute, LocalDate value) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(attribute), value);
	}
	
	protected static <T> Specification<T> greaterOrEqual(String attribute, LocalDateTime value) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(attribute), value);
	}

	protected static <T> Specification<T> greaterOrEqual(String attribute, Number value) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.ge(root.get(attribute), value);
	}

	protected static <T> Specification<T> lessOrEqual(String attribute, LocalDate value) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(attribute), value);
	}
	
	protected static <T> Specification<T> lessOrEqual(String attribute, LocalDateTime value) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(attribute), value);
	}

	protected static <T> Specification<T> lessOrEqual(String attribute, Number value) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.le(root.get(attribute), value);
	}

	protected static <T> Specification<T> between(String attribute, LocalDate from, LocalDate to) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get(attribute), from, to);
	}
	
	protected static <T> Specification<T> between(String attribute, LocalDateTime from, LocalDateTime to) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get(attribute), from, to);
	}

	protected static <T> Specification<T> between(String attribute, Integer from, Integer to) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get(attribute), from, to);
	}
	
	protected static <T> Specification<T> between(String attribute, Long from, Long to) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get(attribute), from, to);
	}

	protected static <T> Specification<T> in(String attribute, Object[] values) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.in(root.get(attribute).in(values));
	}

	protected static <T> Specification<T> in(String attribute, Iterable<?> values) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.in(root.get(attribute).in(values));
	}


}
