package com.zxjz.dto.in;

public class FindParemeterDto {
    private int page;
    private int rows;
    private String srt_search_content;

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

    public String getSrt_search_content() {
        return srt_search_content;
    }

    public void setSrt_search_content(String srt_search_content) {
        this.srt_search_content = srt_search_content;
    }

    @Override
    public String toString() {
        return "FindParemeterDto{" +
                "page=" + page +
                ", rows=" + rows +
                ", srt_search_content='" + srt_search_content + '\'' +
                '}';
    }
}
