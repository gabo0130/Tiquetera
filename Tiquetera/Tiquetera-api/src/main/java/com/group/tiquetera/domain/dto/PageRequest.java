package com.group.tiquetera.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;


@Data
public class PageRequest implements Pageable, Serializable {

	public static final int PAGE_SIZE_DEFAULT = 50;
	private static final long serialVersionUID = 1L;

	private Integer size;
	private Integer page;
	private String order;
	private String direction;

	public PageRequest() {
		this.page = 0;
		this.size = PAGE_SIZE_DEFAULT;
	}

	public PageRequest(Pageable pageable) {
		this.page = pageable.getPageNumber();
		this.size = pageable.getPageSize();
		this.order = pageable.getSort().iterator().next().getProperty();
		this.direction = pageable.getSort().iterator().next().getDirection().name().toLowerCase();
	}

	public PageRequest(int i, Integer size, String order, String direction) {
	}

	public Pageable getPageable() {
		return this;
	}

	@Override
	public int getPageNumber() {
		return this.page == null ? 0 : this.page;
	}

	@Override
	public int getPageSize() {
		return this.size == null ? PageRequest.PAGE_SIZE_DEFAULT : this.size;
	}

	@Override
	public long getOffset() {
		return (long) getPageNumber() * getPageSize();
	}

	@Override
	public Sort getSort() {
		if (this.order != null && this.direction != null) {
			Sort.Direction sortDirection = isAsc() ? Sort.Direction.ASC : Sort.Direction.DESC;
			return Sort.by(new Sort.Order(sortDirection, this.order));
		}
		return Sort.unsorted();
	}

	@Override
	public Pageable next() {
		return new PageRequest(this.page + 1, this.size, this.order, this.direction);
	}

	@Override
	public Pageable previousOrFirst() {
		return hasPrevious() ? new PageRequest(this.page - 1, this.size, this.order, this.direction) : first();
	}

	@Override
	public Pageable first() {
		return hasPrevious() ? new PageRequest(this.page - 1, this.size, this.order, this.direction) : first();
	}

	@Override
	public Pageable withPage(int pageNumber) {
		return new PageRequest(pageNumber, this.size, this.order, this.direction);
	}

	@Override
	public boolean hasPrevious() {
		return this.page != null && this.page > 0;
	}

	public int getFirstResult() {
		return getPageNumber() * getPageSize();
	}

	@JsonIgnore
	public boolean isAsc(){
		return this.direction != null && this.direction.equals("asc");
	}

}
