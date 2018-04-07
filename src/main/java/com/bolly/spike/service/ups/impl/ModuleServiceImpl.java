package com.bolly.spike.service.ups.impl;

import com.bolly.spike.mapper.ups.ModuleMapper;
import com.bolly.spike.model.entity.ups.Module;
import com.bolly.spike.service.ups.ModuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author   : Bolly
 * CreateAt : 2018/04/07 22:26:57
 */
@Service("moduleService")
public class ModuleServiceImpl implements ModuleService {

    @Resource
    private ModuleMapper moduleMapper;

    @Override
    public List<Module> list() {
        return moduleMapper.list();
    }
}
