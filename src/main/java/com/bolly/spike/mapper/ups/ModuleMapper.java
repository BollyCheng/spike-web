package com.bolly.spike.mapper.ups;

import com.bolly.spike.model.entity.ups.Module;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author   : Bolly
 * CreateAt : 2018/04/07 21:37:59
 */
@Repository
public interface ModuleMapper {

    List<Module> list();

}
