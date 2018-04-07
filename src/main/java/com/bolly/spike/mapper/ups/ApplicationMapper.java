package com.bolly.spike.mapper.ups;

import com.bolly.spike.model.entity.ups.Application;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author   : Bolly
 * CreateAt : 2018/04/07 21:37:47
 */
@Repository
public interface ApplicationMapper {

    List<Application> list();

}
