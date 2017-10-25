package com.zxjz.dao;

import com.zxjz.entity.StarEnterpriseLoGo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface StarEnterpriseLoGoDao {
    /**
     * 查询企业logo列表
     * @return
     */
    public List<StarEnterpriseLoGo> findStarEnterpriseLoGoList();

    /**
     * 查询条数
     * @return
     */
    public int total();

    /**
     * 显示编辑企业logo
     * @param icon_id
     * @return
     */
    public StarEnterpriseLoGo findStarEnterpriseLoGo(@Param("icon_id") int icon_id);

    /**
     * 编辑企业LoGo
     * @param
     * @return
     */
    public int updateStarLoGo(@Param("icon_id") Integer icon_id, @Param("picture_url") String picture_url);
}
