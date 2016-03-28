package com.feng.enums;

/**
 * Created by FQ.CHINA on 2016/3/25.
 * 枚举类
 */
public enum Season {
    SPRING(1), SUMMER(2), AUTUMN(3), WINTER(4);

    private int code;
    private Season(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }
}
