package edu.hbuas.cake.model.javabean;

public class PageBean {
    public int allCount;
    public int allPage;
    public int firstPage;
    public int nowPage;
    public int nextPage;
    public int previousPage;
    public int everyPageCount;
    @Override
    public String toString() {
        return "PageBean{" +
                "allCount=" + allCount +
                ", allPage=" + allPage +
                ", firstPage=" + firstPage +
                ", nowPage=" + nowPage +
                ", nextPage=" + nextPage +
                ", previousPage=" + previousPage +
                ", everyPageCount=" + everyPageCount +
                '}';
    }

    public int getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(int previousPage) {
        this.previousPage = previousPage;
    }



    public int getAllCount() {
        return allCount;
    }

    public void setAllCount(int allCount) {
        this.allCount = allCount;
    }

    public int getAllPage() {
        return allPage;
    }

    public void setAllPage(int allPage) {
        this.allPage = allPage;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getEveryPageCount() {
        return everyPageCount;
    }

    public void setEveryPageCount(int everyPageCount) {
        this.everyPageCount = everyPageCount;
    }


}
