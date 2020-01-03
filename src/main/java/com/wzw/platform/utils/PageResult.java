package com.wzw.platform.utils;

import java.util.List;

public class   PageResult<T> {

private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    private Integer totalCount;

public PageResult() {
        }

public PageResult(List<T> data, Integer totalCount) {
        this.data = data;
        this.totalCount = totalCount;
        }
        }
