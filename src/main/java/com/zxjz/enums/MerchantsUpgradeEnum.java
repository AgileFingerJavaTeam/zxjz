package com.zxjz.enums;


    public enum MerchantsUpgradeEnum {


        /**
         * Created by sunzhongyuan on 2017/9/20.
         */

            APPLY_SUCCESS(1),//申请成功
            FIND_SUCCESS(1),//查询申请VIP商户申请详情成功
            FIND_FAIL(-3),//查询申请VIP商户申请详情失败
            APPLY_REPEAT(-1),//申请重复
            CONFIRM_CHECK_SUCCESS(1),//确认审核成功
            CONFIRM_CHECK_FAIL(-4),//确认审核失败
            FIND_CHECK_EMPLOYER_FAIL(-5),//查询受理员工失败
            APPLY_ERROR(-2);//数据库内部错误


            private int code;


        MerchantsUpgradeEnum(int code) {
            this.code = code;
        }

        public int getCode() {
                return code;
            }

            public void setCode(int code) {
                this.code = code;
            }


            @Override
            public String toString() {
                return "merchantsUpgradeEnum{" +
                        "code=" + code +
                        '}';
            }

    }


