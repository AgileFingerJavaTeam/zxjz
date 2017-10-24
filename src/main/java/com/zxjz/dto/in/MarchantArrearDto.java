package com.zxjz.dto.in;

/**
 * Created by Administrator on 2017/10/20 0020.
 */
public class MarchantArrearDto {
     private String at_search;
     private String at_searchs;
     private int page;
     private int rows;

     private int id;

    public String getAt_searchs() {
        return at_searchs;
    }

    public void setAt_searchs(String at_searchs) {
        this.at_searchs = at_searchs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAt_search() {
        return at_search;
    }

    public void setAt_search(String at_search) {
        this.at_search = at_search;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "MarchantArrearDto{" +
                "at_search='" + at_search + '\'' +
                ", at_searchs='" + at_searchs + '\'' +
                ", page=" + page +
                ", rows=" + rows +
                ", id=" + id +
                '}';
    }
}
