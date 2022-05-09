package com.example.warungbahari.utils;

import org.springframework.data.domain.Page;

import java.util.List;

public class PageResponseWrapper<T> {
    private List<T> content;
    private Long countAllData;
    private Integer totalPages;
    private Integer page;
    private Integer limit;

    public PageResponseWrapper(Page<T> page) {
        this.content = page.getContent();
        this.countAllData = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.page = page.getNumber();
        this.limit = page.getSize();
    }

    public PageResponseWrapper() {
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public Long getCountAllData() {
        return countAllData;
    }

    public void setCountAllData(Long countAllData) {
        this.countAllData = countAllData;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}