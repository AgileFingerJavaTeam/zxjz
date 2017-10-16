package com.zxjz.dao;

import com.zxjz.entity.AuthRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/10/14 0014.
 */
public interface AuthRoleDao {

       public List<AuthRole> findAuthRole(@Param("id") String id);
}
