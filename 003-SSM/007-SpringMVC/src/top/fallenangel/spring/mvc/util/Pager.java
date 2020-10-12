package top.fallenangel.spring.mvc.util;

import java.util.Objects;

public class Pager {
    private int pageStart;
    private int pageSize;
    private Integer page;
    private int pages;
    private int totalRecord;
    private boolean hasPrev;
    private boolean hasNext;

    public Pager() {
    }

    public int getPageStart() {
        return pageStart;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageStart;
    }

    public int getPageSize() {
        if (pageSize == 0) {
            setPageSize(5);
        }
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = Objects.requireNonNullElse(page, 1);
        setPageStart(this.page == 0 ? 0 : (this.page - 1) * pageSize);

        hasNext = this.page < pages;
        hasPrev = this.page > 1;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
        if (page == null) {
            page = 1;
        }
        setPage(page > pages ? pages : page);
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
        setPages((int) Math.ceil(totalRecord * 1.0 / getPageSize()));
    }

    public boolean getHasPrev() {
        return hasPrev;
    }

    public void setHasPrev(boolean hasPrev) {
        this.hasPrev = hasPrev;
    }

    public boolean getHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }
}