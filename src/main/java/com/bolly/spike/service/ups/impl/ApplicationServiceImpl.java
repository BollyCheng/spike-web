package com.bolly.spike.service.ups.impl;

import com.bolly.spike.mapper.ups.ApplicationMapper;
import com.bolly.spike.model.entity.ups.Application;
import com.bolly.spike.service.ups.ApplicationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author   : Bolly
 * CreateAt : 2018/04/07 22:25:35
 */
@Service("applicationService")
public class ApplicationServiceImpl implements ApplicationService {

    @Resource
    private ApplicationMapper applicationMapper;

    @Override
    public List<Application> list() {
        return applicationMapper.list();
    }
}
