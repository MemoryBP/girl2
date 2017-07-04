package com.example.execption;

/**
 * Created by CGQ-PC on 2017/7/3.
 */
public class GirlException extends RuntimeException{
    public Integer getCode() {
        return code;
    }

    public GirlException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    private Integer code;

}
