package com.zxjz.dto.in;

/**
 * Created by Administrator on 2017/10/11 0011.
 */
public class SettlementDto {
      private String q;
      private int id;
      private int ob;
      private int uid;
      private String search;
      private int page;
      private int offset;
      private int rows;

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOb() {
        return ob;
    }

    public void setOb(int ob) {
        this.ob = ob;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "SettlementDto{" +
                "id=" + id +
                ", ob=" + ob +
                ", uid=" + uid +
                ", search='" + search + '\'' +
                ", page=" + page +
                ", offset=" + offset +
                ", rows=" + rows +
                '}';
    }
}
