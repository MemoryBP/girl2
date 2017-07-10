package com.example.reposlitory;

import com.example.model.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by CGQ-PC on 2017/6/30.
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {
    List<Girl> findByAge(Integer age);
    List<Girl> findByCupSizeAndAge(String cupsize,Integer age);
}
