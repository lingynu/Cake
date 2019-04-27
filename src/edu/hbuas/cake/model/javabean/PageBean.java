package edu.hbuas.cake.model.javabean;

public class PageBean {
    private  int allCount;
    private int allPages;
    private int nowPage;
    private int firstPage;
    private int previousPage;
    private int nextPage;
    private int lastPage;

    public int getAllCount() {
        return allCount;
    }

    public void setAllCount(int allCount) {
        this.allCount = allCount;
    }

    public int getAllPages() {
        return allPages;
    }

    public void setAllPages(int allPages) {
        this.allPages = allPages;
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    public int getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(int previousPage) {
        this.previousPage = previousPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "allCount=" + allCount +
                ", allPages=" + allPages +
                ", nowPage=" + nowPage +
                ", firstPage=" + firstPage +
                ", previousPage=" + previousPage +
                ", nextPage=" + nextPage +
                ", lastPage=" + lastPage +
                '}';
    }
}
