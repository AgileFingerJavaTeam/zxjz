package com.zxjz.dao;

import com.zxjz.entity.MerchantStatusOne;
import com.zxjz.entity.MerchantStatusThree;
import com.zxjz.entity.MerchantStatusTwo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
public interface MerchantStatusDao {


      public List<MerchantStatusOne> findMerchantStatusOne(int user_id);

      public List<MerchantStatusTwo> findMerchantStatusTwo(int user_id);

      public List<MerchantStatusThree> findMerchantStatusThree(int user_id);
}
