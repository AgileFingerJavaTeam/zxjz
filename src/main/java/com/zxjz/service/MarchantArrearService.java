package com.zxjz.service;

import com.zxjz.dto.excution.MarchantArrearExcution;
import com.zxjz.dto.in.MarchantArrearDto;

/**
 * Created by Administrator on 2017/10/20 0020.
 */
public interface MarchantArrearService {
        /**
         * 页面数据
         * @param marchantArrearDto
         * @return
         */
        public MarchantArrearExcution findMarchantArrear(MarchantArrearDto marchantArrearDto);

        /**
         * 模糊查询
         * @param marchantArrearDto
         * @return
         */
        public MarchantArrearExcution getMarchantListSearch(MarchantArrearDto marchantArrearDto);
        /**
         * 模糊查询
         * @param marchantArrearDto
         * @return
         */
        public MarchantArrearExcution getReceivablesListSearch(MarchantArrearDto marchantArrearDto);

        /**
         * 欠款商户数量
         */
        public MarchantArrearExcution findCountQ();

        /**
         * 欠款总金额
         */
        public MarchantArrearExcution findMoneyQ();
        /**
         * 当前授信商户数量
         */
        public MarchantArrearExcution findVipCount();
        /**
         * 当前授信商户授信总金额:
         */
        public MarchantArrearExcution findVipCountMoney();
        /**
         * 跳转查看，上
         * @param marchantArrearDto
         * @return
         */
        public MarchantArrearExcution findSecurity(MarchantArrearDto marchantArrearDto);
        /**
         * 跳转查看，下
         * @param marchantArrearDto
         * @return
         */
        public MarchantArrearExcution getReceivables(MarchantArrearDto marchantArrearDto);
}
