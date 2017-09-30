package com.zxjz.enums;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
public enum MerchantStatusEnum {

        COLLECTION_SUCCESS(1,"查询成功"),
        DELETE_COLLECTION_SUCCESS(2,"asd"),
        FIND_COLLECTIONLIST_SUCCESS(3,"fs"),
        COLLECTION_NOT_STATE(-1,"查询失败"),
        DELETE_COLLECTION_NOT_STATE(-2,"fdb"),
        FIND_COLLECTIONLIST_NOT_STATE(-3,"dfb"),
        NO_PRAM(-99,"缺少参数"),
        INNER_ERROR(-100,"数据库内部错误");

        private int code;
        private String codeInfo;

        MerchantStatusEnum(int code, String codeInfo) {
            this.code = code;
            this.codeInfo = codeInfo;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getCodeInfo() {
            return codeInfo;
        }

        public void setCodeInfo(String codeInfo) {
            this.codeInfo = codeInfo;
        }

        @Override
        public String toString() {
            return "EnrollJobStatusEnum{" +
                    "code=" + code +
                    ", codeInfo='" + codeInfo + '\'' +
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
