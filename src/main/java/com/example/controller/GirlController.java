package com.example.controller;

import com.example.model.Girl;
import com.example.model.Result;
import com.example.reposlitory.GirlRepository;
import com.example.service.GirlService;
import com.example.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by CGQ-PC on 2017/6/30.
 */
@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/girls")
    public List<Girl> getGirls(){
        /*return girlProperties.getCupSize();*/
        return girlRepository.findAll();
    }

    @PostMapping(value = "/girls")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                          @RequestParam("age") Integer age){
        Girl girl=new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    @PostMapping(value = "/girls/add")
    public Result<Girl> girlAdd2(@Valid Girl girl, BindingResult bindingResult){
        Result result=new Result();
        if (bindingResult.hasErrors()){
            return ResultUtils.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        /*girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());*/

        /*result.setCode(0);
        result.setMsg("添加成功");
        result.setData(girlRepository.save(girl));*/
        return ResultUtils.success(girlRepository.save(girl));
    }

    @GetMapping(value = "/girls/find/{id}")
    public Girl girlFind(@PathVariable Integer id){
        return girlRepository.findOne(id);
    }

    @PutMapping(value = "/girls/up/{id}")
    public Girl girlUpdate(@PathVariable Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        System.out.println("update");
        Girl girl=new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    @DeleteMapping(value = "/girls/de/{id}")
    public void girlDel(@PathVariable Integer id){
        girlRepository.delete(id);
    }

    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlFindByAge(@PathVariable Integer age){
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.girlTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }

}
