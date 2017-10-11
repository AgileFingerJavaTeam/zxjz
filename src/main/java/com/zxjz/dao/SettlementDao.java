package com.zxjz.dao;

import com.zxjz.entity.Settlement;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/11 0011.
 */
public interface SettlementDao {
    /**
     * 显示数据
     * @param rows
     * @param offset
     * @return
     */
    public List<Settlement> findListSettlement(@Param("rows")int rows,@Param("offset")int offset);
    /**
     * 显示总数
     */
    public int findSettlementCount(String search);

    /**
     * 模糊查询
     * @param rows
     * @param offset
     * @param search
     * @return
     */
    public List<Settlement> findSearch(@Param("rows")int rows,@Param("offset") int offset,@Param("search")String search);

    /**
     *查看
     * @param id
     * @param ob
     * @param uid
     * @return
     */
    public Settlement getSettlementData(@Param("id")int id,@Param("ob")int ob,@Param("uid")int uid);

    /**
     * 添加窗口查流水号+1
     * @param id
     * @return
     */
    public Map findMaxNumber(int id);

    /**
     * 查询商户名称
     * @param rows
     * @param offset
     * @param q
     * @return
     */
    public List<Settlement> findMerchantsName (@Param("rows")int rows,@Param("offset") int offset,@Param("q")String q);
}
