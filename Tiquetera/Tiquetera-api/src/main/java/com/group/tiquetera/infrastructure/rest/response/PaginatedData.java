package com.group.tiquetera.infrastructure.rest.response;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Data
public class PaginatedData<T> {
    private List<T> items;
    private long total;
    private int totalPages;
    private int size;
    private int page;

    public PaginatedData(List<T> items, long total, int totalPages, int size, int page) {
        this.items = items;
        this.total = total;
        this.totalPages = totalPages;
        this.size = size;
        this.page = page;
    }

    public PaginatedData(Page<T> page) {
        this.items = page.getContent();
        this.total = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.size = page.getSize();
        this.page = page.getNumber();
    }

    public PaginatedData(List<T> content) {
        this.items = content;
        this.total = content.size();
        this.totalPages = 1;
        this.size = content.size();
        this.page = 0;
    }

    public PaginatedData(List<T> content, Pageable pageable, long total) {
        this.items = content;
        this.total = total;
        this.totalPages = (int) Math.ceil((double) total / pageable.getPageSize());
        this.size = pageable.getPageSize();
        this.page = pageable.getPageNumber();
    }

}