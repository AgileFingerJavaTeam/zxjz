package com.zxjz.enums;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
public enum MerchantStatusEnum {

        COLLECTION_SUCCESS(1),//查询成功
        COLLECTION_NOT_STATE(-1),//查询失败
        NO_PRAM(-99),//缺少参数
        INNER_ERROR(-100);//数据库内部错误

        private int code;

        MerchantStatusEnum(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }


    @Override
    public String
    toString() {
        return "MerchantStatusEnum{" +
                "code=" + code +
                '}';
    }

    public static MerchantStatusEnum stateof(int index) {
            for (MerchantStatusEnum state : values())
            {
                if (state.getCode()==index)
                {
                    return state;
                }
            }
            return null;
        }
}
