package com.zxjz.dto.in;

/**
 * Created by Administrator on 2017/10/11 0011.
 */
public class HomepageRecommendDto {
     private int recruiting_id;
     private String hzn_recommend_begin_time;
     private String hzn_recommend_end_time;

    public int getRecruiting_id() {
        return recruiting_id;
    }

    public void setRecruiting_id(int recruiting_id) {
        this.recruiting_id = recruiting_id;
    }

    public String getHzn_recommend_begin_time() {
        return hzn_recommend_begin_time;
    }

    public void setHzn_recommend_begin_time(String hzn_recommend_begin_time) {
        this.hzn_recommend_begin_time = hzn_recommend_begin_time;
    }

    public String getHzn_recommend_end_time() {
        return hzn_recommend_end_time;
    }

    public void setHzn_recommend_end_time(String hzn_recommend_end_time) {
        this.hzn_recommend_end_time = hzn_recommend_end_time;
    }

    @Override
    public String toString() {
        return "HomepageRecommendDto{" +
                "recruiting_id=" + recruiting_id +
                ", hzn_recommend_begin_time='" + hzn_recommend_begin_time + '\'' +
                ", hzn_recommend_end_time='" + hzn_recommend_end_time + '\'' +
                '}';
    }
}
