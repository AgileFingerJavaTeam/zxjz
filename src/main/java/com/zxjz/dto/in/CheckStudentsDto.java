package com.zxjz.dto.in;

public class CheckStudentsDto {
    private int user_id;
    private String srt_searchStu_content;
    private int page;
    private int rows;
    private String srt_filtrate;
    private int check_state;
    private String stat_res;

    public String getStat_res() {
        return stat_res;
    }

    public void setStat_res(String stat_res) {
        this.stat_res = stat_res;
    }

    public int getCheck_state() {
        return check_state;
    }

    public void setCheck_state(int check_state) {
        this.check_state = check_state;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getSrt_searchStu_content() {
        return srt_searchStu_content;
    }

    public void setSrt_searchStu_content(String srt_searchStu_content) {
        this.srt_searchStu_content = srt_searchStu_content;
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

    public String getSrt_filtrate() {
        return srt_filtrate;
    }

    public void setSrt_filtrate(String srt_filtrate) {
        this.srt_filtrate = srt_filtrate;
    }

    @Override
    public String toString() {
        return "CheckStudentsDto{" +
                "user_id=" + user_id +
                ", srt_searchStu_content='" + srt_searchStu_content + '\'' +
                ", page=" + page +
                ", rows=" + rows +
                ", srt_filtrate='" + srt_filtrate + '\'' +
                ", check_state=" + check_state +
                ", stat_res='" + stat_res + '\'' +
                '}';
    }
}
