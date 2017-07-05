package com.example.service;

import com.example.execption.GirlException;
import com.example.model.Girl;
import com.example.model.Result;
import com.example.reposlitory.GirlRepository;
import com.example.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by CGQ-PC on 2017/6/30.
 */
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void girlTwo(){
        Girl girlA=new Girl();
        girlA.setCupSize("A");
        girlA.setAge(1);
        girlRepository.save(girlA);

        Girl girlB=new Girl();
        girlB.setCupSize("B");
        girlB.setAge(25);
        girlRepository.save(girlB);
    }

    public Result getAge(Integer id) throws Exception{
        Girl girl=girlRepository.findOne(id);
        Integer age=girl.getAge();
        if (age < 11){
            //返回"应该在上小学" code=100
            throw new GirlException(100,"你应该在上小学吧!");
        }else if (age >= 11 && age < 16 ){
            //返回"应该在上初中" code=101
            throw new GirlException(101,"你应该在上初中吧!");
        }

        if (age > 16){
            return ResultUtils.success(girl);
        }
        return null;
    }
}
