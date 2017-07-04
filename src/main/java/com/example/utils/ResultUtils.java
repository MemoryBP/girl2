package com.example.utils;

import com.example.model.Result;

/**
 * Created by CGQ-PC on 2017/7/3.
 */
public class ResultUtils {
    public static Result success(Object object){
        Result result=new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result error(Integer code,String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
