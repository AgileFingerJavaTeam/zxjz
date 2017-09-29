package com.zxjz.enums;

/**
 * Created by Administrator on 2017/9/22 0022.
 */
public enum  CollectionEnum {

    COLLECTION_SUCCESS(1,"添加收藏成功"),
    DELETE_COLLECTION_SUCCESS(2,"删除收藏成功"),
    FIND_COLLECTIONLIST_SUCCESS(3,"查询收藏列表成功"),
    COLLECTION_NOT_STATE(-1,"添加收藏失败"),
    DELETE_COLLECTION_NOT_STATE(-2,"删除收藏失败"),
    FIND_COLLECTIONLIST_NOT_STATE(-3,"查询收藏列表失败"),
    NO_PRAM(-99,"缺少参数"),
    INNER_ERROR(-100,"数据库内部错误");

    private int code;

    private String codeInfo;

    CollectionEnum(int code, String codeInfo) {
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

    public static CollectionEnum stateof(int index) {
        for (CollectionEnum state : values())
        {
            if (state.getCode()==index)
            {
                return state;
            }
        }
        return null;
    }
}