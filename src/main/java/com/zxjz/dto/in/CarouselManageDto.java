package com.zxjz.dto.in;

/**
 * Created by Administrator on 2017/10/20 0020.
 */
public class CarouselManageDto {

     private int page;
     private int rows;
     private String xzf_search_content;

     private int carousel_figure_id;


    public int getCarousel_figure_id() {
        return carousel_figure_id;
    }

    public void setCarousel_figure_id(int carousel_figure_id) {
        this.carousel_figure_id = carousel_figure_id;
    }

    public String getXzf_search_content() {
        return xzf_search_content;
    }

    public void setXzf_search_content(String xzf_search_content) {
        this.xzf_search_content = xzf_search_content;
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
        return "CarouselManageDto{" +
                "page=" + page +
                ", rows=" + rows +
                ", xzf_search_content='" + xzf_search_content + '\'' +
                '}';
    }
}
