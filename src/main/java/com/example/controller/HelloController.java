package com.example.controller;

import com.example.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by CGQ-PC on 2017/6/30.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private GirlProperties girlProperties;

    /*@RequestMapping(value = {"/","/say"},method = RequestMethod.GET)*/
    @GetMapping(value = {"/","/say"})
    public String say(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){
        /*return girlProperties.getCupSize();*/
        return id.toString();
    }
}
