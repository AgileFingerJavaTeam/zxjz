package com.zxjz.enums;


    public enum MerchantsUpgradeEnum {


        /**
         * Created by sunzhongyuan on 2017/9/20.
         */

            APPLY_SUCCESS(1,"申请成功"),
            APPLY_REPEAT(-1,"申请重复"),
            APPLY_ERROR(-2,"数据库内部错误");

            private int code;

            private String codeInfo;

        MerchantsUpgradeEnum(int code, String codeInfo) {
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
                return "merchantsUpgradeEnum{" +
                        "code=" + code +
                        ", codeInfo='" + codeInfo + '\'' +
                        '}';
            }

    }


