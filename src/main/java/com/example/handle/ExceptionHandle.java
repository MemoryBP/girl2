package com.example.handle;

import com.example.execption.GirlException;
import com.example.model.Result;
import com.example.utils.ResultUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by CGQ-PC on 2017/7/3.
 */
@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof GirlException){
            GirlException girlException=(GirlException)e;
            return ResultUtils.error(girlException.getCode(),girlException.getMessage());
        }else {
            return ResultUtils.error(-1,"未知错误");
        }

    }
}
