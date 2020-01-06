package com.wzw.platform.utils;

public class PageWrapper  {

    private int pageSize;
    private  int srart;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getSrart() {
        return srart;
    }

    public void setSrart(int srart) {
        this.srart = srart;
    }

    public PageWrapper(int pageSize, int srart) {
        this.pageSize = pageSize;
        this.srart = srart;
    }
}
