package com.zxjz.dto.in;

public class CheckStudentsDto {
    private int user_id;
    private String srt_searchStu_content;
    private int offset;
    private int rows;
    private String srt_filtrate;
    private int check_state;

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
                ", offset=" + offset +
                ", rows=" + rows +
                ", srt_filtrate='" + srt_filtrate + '\'' +
                ", check_state=" + check_state +
                '}';
    }
}
