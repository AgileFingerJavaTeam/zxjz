package com.zxjz.dto.excution;

import com.zxjz.entity.ListCollection;
import com.zxjz.enums.CollectionEnum;

import java.util.List;

/**
 * Created by Administrator on 2017/9/22 0022.
 */
public class CollectionExcution {

    private List<ListCollection> listCollection;
    private int code;
    private String codeInfo;

    public CollectionExcution(CollectionEnum collectionEnum) {
        this.code = collectionEnum.getCode();
        this.codeInfo = collectionEnum.getCodeInfo();
    }
    public CollectionExcution(CollectionEnum collectionEnum , List<ListCollection> listCollection) {
        this.code = collectionEnum.getCode();
        this.codeInfo = collectionEnum.getCodeInfo();
        this.listCollection = listCollection;
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
        return "CollectionExcution{" +
                "listCollection=" + listCollection +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
